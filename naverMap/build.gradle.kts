plugins {
    id(Plugins.ANDROID_LIBRARY)
    id(Plugins.KOTLIN_ANDROID)
    id(Plugins.KOTLIN_KAPT)
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 23
        targetSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
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
    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.Test.ANDROIDX_JUNIT)
    androidTestImplementation(Dependency.Test.ANDROIDX_ESPRESSO)

    implementation(Dependency.Naver.NAVER_MAP)
    implementation(Dependency.Google.GOOGLE_LOCATION)

}