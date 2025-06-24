# Terraform Infrastructure for Overdo

This configuration provisions a minimal AWS environment for the Overdo application. It creates
an EKS cluster, VPC, ECR repository, Redis cache and a Microsoft SQL Server instance. All
resources are deployed to the `ap-northeast-2` region.

## Usage

1. Install [Terraform](https://www.terraform.io/downloads) and configure AWS credentials.
2. Initialize the working directory:

   ```bash
   terraform init
   ```
3. Review the execution plan:

   ```bash
   terraform plan
   ```
4. Apply the configuration:

   ```bash
   terraform apply
   ```
5. Destroy the resources when you are finished:

   ```bash
   terraform destroy
   ```
