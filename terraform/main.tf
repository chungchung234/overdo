########################################
# Terraform MVP 인프라 구성 (EKS + VPC + ECR + Redis + RDS - MSSQL)
########################################

provider "aws" {
  region = "ap-northeast-2"
}

########################################
# VPC 모듈 (퍼블릭 서브넷만 사용)
########################################
module "vpc" {
  source  = "terraform-aws-modules/vpc/aws"
  version = "5.1.0"

  name = "overdo-vpc"
  cidr = "10.0.0.0/16"

  azs             = ["ap-northeast-2a", "ap-northeast-2c"]
  public_subnets = ["10.0.1.0/24", "10.0.2.0/24"]

  enable_dns_support     = true
  enable_dns_hostnames   = true
  enable_nat_gateway     = false
  single_nat_gateway     = false
  create_igw             = true
}

########################################
# EKS 클러스터 구성
########################################
module "eks" {
  source  = "terraform-aws-modules/eks/aws"
  version = "20.4.0"

  cluster_name    = "overdo-cluster"
  cluster_version = "1.29"
  subnet_ids      = module.vpc.public_subnets
  vpc_id          = module.vpc.vpc_id

  eks_managed_node_groups = {
    default = {
      instance_types = ["t3.medium"]
      desired_size   = 2
      max_size       = 3
      min_size       = 1
    }
  }
}

########################################
# ECR 저장소
########################################
resource "aws_ecr_repository" "overdo" {
  name = "overdo"
}

########################################
# Redis (ElastiCache Cluster, 단일 노드)
########################################
resource "aws_elasticache_subnet_group" "redis" {
  name       = "redis-subnet-group"
  subnet_ids = module.vpc.public_subnets
}

resource "aws_elasticache_cluster" "redis" {
  cluster_id           = "overdo-redis"
  engine               = "redis"
  node_type            = "cache.t3.micro"
  num_cache_nodes      = 1
  parameter_group_name = "default.redis7"
  subnet_group_name    = aws_elasticache_subnet_group.redis.name
  port                 = 6379
}

########################################
# RDS (Microsoft SQL Server Express Edition, 단일 AZ, 퍼블릭 접근)
########################################
resource "aws_db_subnet_group" "rds" {
  name       = "rds-subnet-group"
  subnet_ids = module.vpc.public_subnets
}

resource "aws_db_instance" "overdo" {
  identifier              = "overdo-mssql"
  engine                  = "sqlserver-ex"
  engine_version          = "15.00.4073.23.v1"
  instance_class          = "db.t3.micro"
  allocated_storage       = 20
  username                = "adminuser"
  password                = "OverdoMssql123!" # 운영 시 Secrets Manager 사용 권장
  publicly_accessible     = true
  skip_final_snapshot     = true
  db_subnet_group_name    = aws_db_subnet_group.rds.name
  vpc_security_group_ids  = [module.vpc.default_security_group_id]
  port                    = 1433
  license_model           = "license-included"
}

########################################
# 출력값
########################################
output "cluster_name" {
  value = module.eks.cluster_name
}

output "ecr_url" {
  value = aws_ecr_repository.overdo.repository_url
}

output "redis_endpoint" {
  value = aws_elasticache_cluster.redis.cache_nodes[0].address
}

output "rds_endpoint" {
  value = aws_db_instance.overdo.address
}

output "kubeconfig_command" {
  value = "aws eks update-kubeconfig --region ap-northeast-2 --name ${module.eks.cluster_name}"
}
