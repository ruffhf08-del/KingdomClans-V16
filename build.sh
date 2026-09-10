#!/bin/bash
# Build APK Script

echo "🔨 Building Kingdom Clans V16 APK..."
echo ""

# Check if gradlew exists
if [ ! -f "./gradlew" ]; then
    echo "❌ gradlew not found!"
    exit 1
fi

# Make gradlew executable
chmod +x ./gradlew

echo "📦 Building Debug APK..."
./gradlew clean assembleDebug

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ APK BUILD SUCCESSFUL!"
    echo ""
    echo "📁 APK Location:"
    echo "android/build/outputs/apk/debug/app-debug.apk"
    echo ""
    echo "📊 APK Info:"
    ls -lh android/build/outputs/apk/debug/app-debug.apk
    echo ""
    echo "🚀 Ready to install!"
else
    echo ""
    echo "❌ BUILD FAILED!"
    exit 1
fi
