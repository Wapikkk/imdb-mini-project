plugins {
    alias(libs.plugins.multiplatform)
}

kotlin {
    listOf(
        mingwX64(),
    ).forEach {
        it.binaries.executable {
            entryPoint = "main"
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared"))
        }
    }
}
