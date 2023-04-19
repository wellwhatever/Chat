import com.example.conventions.libsVersionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = libsVersionCatalog()
            with(pluginManager) {
                apply("dagger.hilt.android.plugin")
                apply("org.jetbrains.kotlin.kapt")
            }
            dependencies {
                "implementation"(libs.findBundle("hilt").get())
                "kapt"(libs.findBundle("hilt.kapt").get())
            }
        }
    }
}