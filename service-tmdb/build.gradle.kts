val ktor_version: String by project

dependencies{
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-gson:$ktor_version")
    implementation("io.ktor:ktor-client-json-jvm:$ktor_version")
}