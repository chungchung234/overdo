#!/usr/bin/env bash
# Usage: ./deploy-prod.sh
# Deploy dev branch directly to main and production.

set -e

# Ensure we have the latest code
git fetch origin dev main

# Merge dev into main
git checkout main
git merge --no-ff origin/dev -m "Merge dev into main for deployment"

# Push updated main
git push origin main

# Run deployment steps
echo "Deploying to production..."
# TODO: Add production deployment steps
