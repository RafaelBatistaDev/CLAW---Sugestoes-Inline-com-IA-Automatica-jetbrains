plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.9.21"
    id("org.jetbrains.intellij") version "1.17.1"
}

group = "com.clawrafaelia"
version = "1.0.4"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}

// See https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2023.2.1")  // IntelliJ IDEA 2023.2.1 - supports Rider 2026
    plugins.set(listOf())
    
    // Uncomment to target Rider specifically:
    // productCode.set("RD")  // Rider
}

tasks {
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("232.10300")
        untilBuild.set("261.*")
    }

    buildSearchableOptions {
        enabled = false
    }
}
