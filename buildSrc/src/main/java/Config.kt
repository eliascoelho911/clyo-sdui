import org.gradle.api.JavaVersion

object Config {
    const val compileSdk = 33
    const val minSdk = 21
    const val targetSdk = 33
    val javaVersion = JavaVersion.VERSION_1_8
    const val jvmJavaVersion = "1.8"
}