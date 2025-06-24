#!/usr/bin/env bash
# Usage: ./release-notes.sh [from-tag] [to-tag]
# Generates release notes from commit history between two tags.

FROM_TAG=${1}
TO_TAG=${2:-HEAD}

git log --pretty=format:'- %s (%an)' "${FROM_TAG}..${TO_TAG}"
