plugins {
    java
    application
}

group = "com.rkalbi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

application {
    mainClass.set("com.rkalbi.Main")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed", "standardOut", "standardError")
    }
}