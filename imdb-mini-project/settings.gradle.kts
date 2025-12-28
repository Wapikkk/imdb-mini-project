rootProject.name = "imdb-mini-project"

pluginManagement {
    repositories {
        google ()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/public")
    }
}

dependencyResolutionManagement {
    repositories {
        google ()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/public")
    }
}
include(":shared")
include(":sample:composeApp")
//include(":sample:terminalApp")

