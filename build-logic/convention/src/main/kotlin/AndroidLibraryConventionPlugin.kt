import com.android.build.gradle.LibraryExtension
import com.example.conventions.configureAndroidKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<LibraryExtension> {
                configureAndroidKotlin(this)
                defaultConfig {
                    consumerProguardFiles("consumer-rules.pro")
                }
                buildTypes {
                    release {
                        isMinifyEnabled = true
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
            }
        }
    }
}