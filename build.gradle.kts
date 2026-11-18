plugins {
    kotlin("jvm") version "2.4.20"
    id("xyz.jpenilla.run-paper") version "3.1.0"
    id("de.eldoria.plugin-yml.paper") version "0.9.0"
}

group = "dev.thebjoredcraft.mcdp"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.codemc.io/repository/maven-releases/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.3.build.201-stable")
    compileOnly("com.github.retrooper:packetevents-spigot:2.14.0")
}

kotlin {
    jvmToolchain(25)
}

tasks {
    runServer {
        minecraftVersion("26.3")
    }
}

paper {
    main = "dev.thebjoredcraft.mcdp.PluginMain"
    apiVersion = "1.21"
    foliaSupported = true

    authors = listOf("TheBjoRedCraft")

    serverDependencies {
        register("packetevents")
    }
}