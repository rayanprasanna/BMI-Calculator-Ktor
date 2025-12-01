#!/bin/bash

# ============================================
# EDIT THESE VALUES WITH YOUR ACTUAL INFO
# ============================================

PROJECT_ID="bmi-calculator-api"          # Your project ID here
MONGO_URI="mongodb+srv://rayanprasanna224_db_user:rjh684Ayfz57usT4@cluster0.lmk0kg1.mongodb.net/?appName=Cluster0"  # Your MongoDB URI here

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
  --region asia-south1 \
  --allow-unauthenticated \
  --set-env-vars MONGO_URI="$MONGO_URI" \
  --port 8080 \
  --memory 512Mi

echo "Done!"