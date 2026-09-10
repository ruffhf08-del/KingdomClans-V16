# Kingdom Clans V16 - Release Build Guide

## 🚀 Complete Release Process

### Step 1: Setup Environment

```bash
# Clone repository
git clone https://github.com/ruffhf08-del/KingdomClans-V16.git
cd KingdomClans-V16

# Run setup script
bash setup.sh
```

### Step 2: Build APK

#### Option A: Using Script (Recommended)
```bash
bash build.sh
```

#### Option B: Using Gradle
```bash
./gradlew clean assembleDebug
```

#### Option C: Using Android Studio
1. Open project in Android Studio
2. Build > Build Bundle(s) / APK(s) > Build APK(s)
3. Select "debug" or "release"
4. APK generated automatically

### Step 3: Verify APK

```bash
# Check file exists
ls -lh android/build/outputs/apk/debug/app-debug.apk

# Expected output:
# -rw-r--r-- 1 user staff 50M Sep 10 09:30 app-debug.apk
```

### Step 4: Test on Device

```bash
# Connect Android device via USB
adb devices

# Install APK
adb install android/build/outputs/apk/debug/app-debug.apk

# Launch app
adb shell am start -n com.kingdomclans.game/.MainActivity

# View logs
adb logcat
```

### Step 5: Release Build

```bash
# Create release APK (smaller, optimized)
./gradlew assembleRelease

# Output: android/build/outputs/apk/release/app-release.apk
```

### Step 6: Upload to GitHub

```bash
# Tag release
git tag v1.0.0
git push origin v1.0.0

# Create Release on GitHub
# 1. Go to https://github.com/ruffhf08-del/KingdomClans-V16/releases
# 2. Click "Create a new release"
# 3. Select tag: v1.0.0
# 4. Upload APK file
# 5. Add release notes
# 6. Publish release
```

---

## 📊 Build Output

### Debug APK
```
File: app-debug.apk
Size: ~50 MB
Path: android/build/outputs/apk/debug/
Usage: Testing on emulator/device
```

### Release APK
```
File: app-release.apk
Size: ~35 MB
Path: android/build/outputs/apk/release/
Usage: Production release
Note: Requires keystore for signing
```

---

## 🔐 Signing Release APK

```bash
# Create keystore (first time only)
keytool -genkey -v -keystore release.keystore -keyalg RSA \
  -keysize 2048 -validity 10000 -alias kingdomclans

# Build signed APK
./gradlew clean assembleRelease \
  -Pandroid.injected.signing.store.file=release.keystore \
  -Pandroid.injected.signing.store.password=YOUR_PASSWORD \
  -Pandroid.injected.signing.key.alias=kingdomclans \
  -Pandroid.injected.signing.key.password=YOUR_PASSWORD
```

---

## ✅ Pre-Release Checklist

- [ ] Code compiles without errors
- [ ] No warnings in build
- [ ] APK file generated successfully
- [ ] APK tested on device
- [ ] Game launches without crashes
- [ ] All features working
- [ ] Documentation updated
- [ ] Version number updated
- [ ] Release notes prepared
- [ ] APK uploaded to GitHub

---

## 🎉 Release Complete!

After uploading to GitHub Releases:

```
Download URL:
https://github.com/ruffhf08-del/KingdomClans-V16/releases/download/v1.0.0/app-debug.apk
```

---

## 📱 Distribution

### GitHub Releases (Best for devs)
- Direct APK download
- Version history
- Release notes
- Easy to share

### Google Play Store (Best for users)
1. Create developer account
2. Upload signed APK
3. Fill app details
4. Submit for review
5. Live on Play Store

### Direct Download
- Host on website
- Share download link
- Easy updates

---

**Ready to release? Let's go! 🚀**
