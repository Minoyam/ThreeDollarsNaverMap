// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.ANDROID_APPLICATION) version "7.1.2" apply false
    id(Plugins.ANDROID_LIBRARY) version "7.1.2" apply false
    id(Plugins.KOTLIN_ANDROID) version "1.6.10" apply false
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}