val kotlin_version: String by project

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.41")
    }
}

plugins {
    java
}


allprojects {

    group = "com.cdev"
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        jcenter()
        mavenLocal()
        maven { url = uri("https://kotlin.bintray.com/ktor") }
    }

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    }
}

subprojects {
    version = "1.0"
}

project(":api-rest") {
    dependencies {
        implementation(project(":api-gateway"))
        implementation(project(":service-config"))
        implementation(project(":service-data"))
    }
}

project(":api-gateway") {
    dependencies {
        implementation(project(":service-config"))
        implementation(project(":service-data"))
    }
}

project(":service-data") {
    dependencies {
        implementation(project(":service-tmdb"))
    }
}