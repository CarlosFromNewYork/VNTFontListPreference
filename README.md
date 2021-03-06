VNTFontListPreference
=====================

This is an easy to use custom preference, which opens a dialog with a list of available fonts. The selected font gets automatically saved and you are able to set the font directory as well as the defaultValue.

```xml
<com.vanniktech.vntfontlistpreference.VNTFontListPreference
    android:defaultValue="@string/font_face_default_value"
    android:key="preference_font_face"
    android:title="@string/font_face"
    app:vnt_fontDirectory="@string/font_face_font_directory" />
```

`vntfontlistpreference:vnt_fontDirectory` can be something like `fonts`. This means that the dialog will list all fonts, that have the ending `ttf` or `otf` under `assets/fonts`. If there are no fonts under the provided directory it will throw an exception during initialization.

# Download Sample App

[![Get it on Google Play](https://developer.android.com/images/brand/en_generic_rgb_wo_45.png)](https://play.google.com/store/apps/details?id=com.vanniktech.vntfontlistpreference.sample)

or scan the code on your mobile

![Google Play QR link](http://api.qrserver.com/v1/create-qr-code/?color=000000&bgcolor=FFFFFF&data=https%3A%2F%2Fplay.google.com%2Fstore%2Fapps%2Fdetails%3Fid%3Dcom.vanniktech.vntfontlistpreference.sample&qzone=1&margin=0&size=150x150&ecc=L)

or download it [directly](sample.apk)

# Setup

**build.gradle**

```groovy
compile 'com.vanniktech:vntfontlistpreference:1.0.0'
compile 'com.vanniktech:vntfontlistpreference:1.0.1-SNAPSHOT'
```

Modules are located on [Maven Central](https://oss.sonatype.org/#nexus-search;quick~vntfontlistpreference).

Go to your preference XML file and insert the above mentioned XML tag. Afterwards you are good to go and can run your project!

# Get default font

```java
final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
final String defaultFont = sharedPreferences.getString("preference_font_face", this.getString(R.string.font_face_default_value));
final Typeface typeface = Typeface.createFromAsset(this.getAssets(), font);
```

# Proguard

No configuration needed.

# Preview

<img src="app/src/main/res/drawable-nodpi/preview.png" alt="Image of VNTFontListPreference" width="320">

# License

Copyright (C) 2014-2016 Vanniktech - Niklas Baudy

Licensed under the Apache License, Version 2.0
