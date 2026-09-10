#!/bin/bash
# Release build script

echo "🔨 Building Kingdom Clans V16 Release APK..."
echo ""

chmod +x ./gradlew

echo "📦 Building Release APK..."
./gradlew clean assembleRelease

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ RELEASE APK BUILD SUCCESSFUL!"
    echo ""
    echo "📁 APK Location:"
    echo "android/build/outputs/apk/release/app-release.apk"
    echo ""
    echo "📊 APK Info:"
    ls -lh android/build/outputs/apk/release/app-release.apk
    echo ""
    echo "🚀 Ready to release!"
else
    echo ""
    echo "❌ RELEASE BUILD FAILED!"
    exit 1
fi
