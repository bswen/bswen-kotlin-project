plugins {
    //id("java")
    kotlin("jvm")
}

//group = "com.example"
//version = "1.0.0"


dependencies {

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}