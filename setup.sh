#!/bin/bash
# Setup script for Kingdom Clans V16

echo "🎮 Kingdom Clans V16 - Setup Script"
echo "====================================="
echo ""

# Check Java
echo "Checking Java..."
if ! command -v java &> /dev/null; then
    echo "❌ Java not found! Install Java 11+"
    exit 1
fi
echo "✅ Java found: $(java -version 2>&1 | head -n 1)"
echo ""

# Check Android SDK
echo "Checking Android SDK..."
if [ -z "$ANDROID_SDK_ROOT" ] && [ -z "$ANDROID_HOME" ]; then
    echo "⚠️  Android SDK not found. Set ANDROID_HOME environment variable."
    echo "   Linux/Mac: export ANDROID_HOME=~/Android/Sdk"
    echo "   Windows: set ANDROID_HOME=C:\\Android\\Sdk"
else
    echo "✅ Android SDK found"
fi
echo ""

# Make scripts executable
echo "Making scripts executable..."
chmod +x ./gradlew
chmod +x ./build.sh
chmod +x ./release.sh
echo "✅ Scripts ready"
echo ""

# Download dependencies
echo "Downloading dependencies..."
./gradlew dependencies
echo ""

echo "✅ Setup complete!"
echo ""
echo "Next steps:"
echo "1. Build APK: ./gradlew assembleDebug"
echo "2. Or run: bash build.sh"
echo "3. Find APK: android/build/outputs/apk/debug/app-debug.apk"
echo ""
echo "Happy building! 🚀"
