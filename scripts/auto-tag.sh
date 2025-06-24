#!/usr/bin/env bash
# Usage: ./auto-tag.sh [tag]
# Creates or updates Git tags automatically.

TAG=${1:-"auto-$(date +%Y%m%d%H%M%S)"}

git tag -f "$TAG"
git push -f origin "$TAG"
