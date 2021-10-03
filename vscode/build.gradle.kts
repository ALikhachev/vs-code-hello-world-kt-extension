plugins {
    kotlin("js")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(npm("@types/vscode", "^1.60.0")) // used by `generateExternals` task
}

kotlin {
    js(IR) {
        nodejs()
    }
}