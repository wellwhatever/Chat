import com.android.build.api.dsl.TestExtension
import com.example.conventions.configureAndroidKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.test")
                apply("org.jetbrains.android")
            }

            extensions.configure<TestExtension> {
                configureAndroidKotlin(this)
            }
        }
    }
}