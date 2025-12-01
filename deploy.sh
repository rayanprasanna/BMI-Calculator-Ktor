#!/bin/bash

# ============================================
# EDIT THESE VALUES WITH YOUR ACTUAL INFO
# ============================================

PROJECT_ID="your-project-id-here"          # Your project ID here
MONGO_URI="your-mongodb-uri-here"  # Your MongoDB URI here

# ============================================
# DON'T EDIT BELOW THIS LINE
# ============================================

echo "Setting up project: $PROJECT_ID"
gcloud config set project $PROJECT_ID

echo "Enabling APIs..."
gcloud services enable cloudbuild.googleapis.com run.googleapis.com

echo "Deploying..."
gcloud run deploy bmi-api \
  --source . \
  --region us-central1 \
  --allow-unauthenticated \
  --set-env-vars MONGO_URI="$MONGO_URI" \
  --port 8080 \
  --memory 512Mi

echo "Done!"
