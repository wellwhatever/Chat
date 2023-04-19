import com.android.build.api.dsl.ApplicationExtension
import com.example.conventions.configureAndroidKotlin
import com.example.conventions.libsVersionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = libsVersionCatalog()
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<ApplicationExtension> {
                configureAndroidKotlin(this)
                defaultConfig.targetSdk = 33
            }
        }
    }
}