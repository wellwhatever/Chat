import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.example.conventions.libsVersionCatalog
import com.google.firebase.crashlytics.buildtools.gradle.CrashlyticsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationFirebaseConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = libsVersionCatalog()
            with(pluginManager) {
                listOf(
                    "com.google.gms.google-services",
                    "com.google.firebase.crashlytics",
                    "com.google.firebase.analytics",
                    "com.google.firebase.database"
                ).forEach { apply(it) }
            }
            dependencies {
                val bom = libs.findLibrary("firebase-bom").get()
                add("implementation", platform(bom))
                "implementation"(libs.findBundle("firebase"))
            }
            extensions.configure<ApplicationAndroidComponentsExtension> {
                finalizeDsl {
                    // Disable the Crashlytics mapping file upload. This feature should only be
                    // enabled if a Firebase backend is available and configured
                    it.buildTypes.forEach { buildType ->
                        buildType.configure<CrashlyticsExtension> {
                            mappingFileUploadEnabled = false
                        }
                    }
                }
            }
        }
    }
}