plugins {
    id(Plugins.ANDROID_APPLICATION)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.mino.threedollarsnavermap"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(Dependency.Android.CORE_KTX)
    implementation(Dependency.Android.ANDROIDX_APPCOMPAT)
    implementation(Dependency.Android.ANDROID_MATERIAL)
    implementation(Dependency.Android.CONSTRAINT_LAYOUT)
    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.Test.ANDROIDX_JUNIT)
    androidTestImplementation(Dependency.Test.ANDROIDX_ESPRESSO)

    implementation(Dependency.Naver.NAVER_MAP)
    implementation(project(":naverMap"))
}