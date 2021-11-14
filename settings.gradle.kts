dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(uri("https://jitpack.io"))
    }
}
rootProject.buildFileName = "build.gradle.kts"
rootProject.name = "Aviata"
include(":app")