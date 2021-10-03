plugins {
    id("org.jetbrains.kotlin.js") version "1.5.31"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
}

kotlin {
    js {
        nodejs {
        }
        binaries.executable()
    }
}