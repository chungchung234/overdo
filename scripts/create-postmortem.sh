#!/usr/bin/env bash
# Usage: ./create-postmortem.sh <incident-id>
# Scaffolds postmortem tasks or documentation for an incident.

INCIDENT_ID=$1
if [ -z "$INCIDENT_ID" ]; then
  echo "Usage: $0 <incident-id>" >&2
  exit 1
fi

dir="postmortems/$INCIDENT_ID"
mkdir -p "$dir"
cat <<PM > "$dir/README.md"
# Postmortem for $INCIDENT_ID

Describe the incident, impact, timeline, and action items.
PM

echo "Postmortem scaffold created at $dir"
