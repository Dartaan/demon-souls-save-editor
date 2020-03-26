import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50"
    application
}

application {
    mainClassName = "ru.dartaan.demon_souls_save_editor.Main"
}

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("org.python:jython-standalone:2.7.1")
}

tasks.withType<Wrapper> {
    gradleVersion = "5.6"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = application.mainClassName
    }
    from(configurations.compile.get().map {if (it.isDirectory) it else zipTree(it)})
}


