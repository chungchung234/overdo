#!/usr/bin/env bash
# Usage: ./deploy-prod.sh
# Deploy develop branch directly to main and production.

set -euo pipefail

# Basic environment validation
command -v git >/dev/null 2>&1 || {
  echo "git command not found" >&2
  exit 1
}
command -v terraform >/dev/null 2>&1 || {
  echo "terraform command not found" >&2
  exit 1
}

if [ -z "${AWS_ACCESS_KEY_ID:-}" ] || [ -z "${AWS_SECRET_ACCESS_KEY:-}" ]; then
  echo "AWS credentials are missing" >&2
  exit 1
fi

trap 'echo "Deployment failed" >&2' ERR

# Ensure we have the latest code
git fetch origin develop main

# Merge develop into main
git checkout main
git merge --no-ff origin/develop -m "Merge develop into main for deployment"

# Push updated main
git push origin main

# Run deployment steps
echo "Deploying to production..."

# Initialize and apply Terraform configuration
terraform -chdir=terraform init -input=false
terraform -chdir=terraform apply -auto-approve

echo "Deployment completed"
