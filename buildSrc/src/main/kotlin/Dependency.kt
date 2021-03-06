object Dependency {
    object Kotlin {
        const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
        const val GRADLE = "com.android.tools.build:gradle:${Versions.GRADLE}"
        const val KOTLIN_GRADLE = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    }

    object Android {
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
        const val ANDROIDX_APPCOMPAT = "androidx.appcompat:appcompat:${Versions.ANDROIDX_APPCOMPAT}"
        const val ANDROID_MATERIAL =
            "com.google.android.material:material:${Versions.ANDROID_MATERIAL}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    }

    object Hilt {
        const val HILT_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}"
        const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
        const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.HILT}"
    }

    object Test {
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
        const val ANDROIDX_JUNIT = "androidx.test.ext:junit:${Versions.ANDROIDX_JUNIT}"
        const val ANDROIDX_ESPRESSO =
            "androidx.test.espresso:espresso-core:${Versions.ANDROIDX_ESPRESSO}"
    }

    object Naver {
        const val NAVER_MAP = "com.naver.maps:map-sdk:${Versions.NAVER_MAP}"
    }

    object Google {
        const val GOOGLE_LOCATION = "com.google.android.gms:play-services-location:${Versions.GOOGLE_LOCATION}"
    }

}