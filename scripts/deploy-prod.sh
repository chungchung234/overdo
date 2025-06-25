#!/usr/bin/env bash
# Usage: ./deploy-prod.sh
# Deploy develop branch directly to main and production.

set -e

# Ensure we have the latest code
git fetch origin develop main

# Merge develop into main
git checkout main
git merge --no-ff origin/develop -m "Merge develop into main for deployment"

# Push updated main
git push origin main

# Run deployment steps
echo "Deploying to production..."
# TODO: Add production deployment steps
