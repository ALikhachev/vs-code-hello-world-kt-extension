import org.jetbrains.kotlin.gradle.targets.js.npm.npmProject

plugins {
    kotlin("js") version "1.5.31"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation(project(":vscode"))
}

kotlin {
    js(IR) {
        nodejs {
        }
        binaries.executable()

        compilations.named("main") {
            packageJson {
                customField("categories", listOf("Other"))
                customField("activationEvents", listOf("onCommand:helloworld.helloWorld"))
                customField("contributes", mapOf("commands" to listOf(mapOf("command" to "helloworld.helloWorld", "title" to "Hello World"))))
                customField("engines", mapOf("vscode" to "^1.60.0"))
                customField("displayName", "HelloWorld")
                customField("description", "My first extension")
            }
        }
    }

    sourceSets {
        all {
            languageSettings {
                optIn("kotlin.js.ExperimentalJsExport")
            }
        }
    }
}

tasks.register("installExtension", Sync::class) {
    dependsOn("productionExecutableCompileSync")
    from({
        kotlin.js().compilations.named("main").map { it.npmProject.dir }
    })
    into {
        project.provider { File(providers.systemProperty("user.home").get()).resolve(".vscode/extensions").resolve(project.name) }
    }
    doFirst {
        logger.info("Installing VS Code extension into $destinationDir")
    }
}

tasks.register("debugExtension", Exec::class) {
    dependsOn("developmentExecutableCompileSync")
    val path = kotlin.js().compilations.named("main").map { it.npmProject.dir }.get()
    commandLine("code", "--inspect-extensions=9229", "--extensionDevelopmentPath=$path")
}