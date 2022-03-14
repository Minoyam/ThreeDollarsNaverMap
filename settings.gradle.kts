pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://naver.jfrog.io/artifactory/maven/")
    }
}
rootProject.name = "ThreeDollarsNaverMap"
include (":app")
include(":naverMap")
