# Kingdom Clans V16 - Build Instructions

## 🔨 Building APK

### Prerequisites
- Java 11+
- Android SDK (API 33+)
- Gradle 7.0+
- Git

### Quick Build (Debug)

```bash
# Clone repository
git clone https://github.com/ruffhf08-del/KingdomClans-V16.git
cd KingdomClans-V16

# Build APK
./gradlew assembleDebug

# APK output
android/build/outputs/apk/debug/app-debug.apk
```

### Release Build

```bash
./gradlew assembleRelease

# APK output
android/build/outputs/apk/release/app-release.apk
```

### Using Build Scripts

```bash
# Debug build
bash build.sh

# Release build
bash release.sh
```

## 📱 Installation

### Via ADB

```bash
adb install android/build/outputs/apk/debug/app-debug.apk
```

### Manual Installation

1. Transfer APK to phone
2. Enable "Unknown Sources" in Settings
3. Open APK file
4. Tap Install

## 🧹 Clean Build

```bash
./gradlew clean
./gradlew assembleDebug
```

## 📊 Build Info

- **Min SDK**: 21 (Android 5.0)
- **Target SDK**: 33 (Android 13)
- **Compile SDK**: 33
- **Build Tools**: 33.0.1

## 🐛 Troubleshooting

### Build Fails
```bash
# Clear gradle cache
./gradlew clean --refresh-dependencies
./gradlew assembleDebug
```

### Memory Error
```bash
# Increase gradle memory
export GRADLE_OPTS="-Xmx2048m"
./gradlew assembleDebug
```

### Android SDK Issues
```bash
# Update SDK
# Via Android Studio: Tools > SDK Manager
# Or command line
sdkmanager "platforms;android-33"
```

## 📦 APK Size

- Debug APK: ~50 MB
- Release APK: ~35 MB

## ✅ Verification

```bash
# Check APK exists
ls -lh android/build/outputs/apk/debug/app-debug.apk

# Get APK info
aapt dump badging android/build/outputs/apk/debug/app-debug.apk
```

---

**Build successful? Time to release!** 🚀
