val logback_version: String by project
val ktor_version: String by project
val kotlin_version: String by project
val koin_version: String by project


plugins {
    application
}

application {
    mainClassName = "io.ktor.server.cio.EngineMain"
}

repositories {
    jcenter()
    mavenLocal()
    maven { url = uri("https://kotlin.bintray.com/ktor") }
}

dependencies {
    implementation("io.ktor:ktor-server-cio:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-host-common:$ktor_version")
    implementation("org.koin:koin-ktor:$koin_version")
    implementation("io.ktor:ktor-gson:$ktor_version")


    testImplementation("io.ktor:ktor-client-mock-jvm:$ktor_version")
    testImplementation("io.ktor:ktor-client-mock:$ktor_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("io.ktor:ktor-server-test-host:$ktor_version")
}



