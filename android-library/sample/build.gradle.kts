val RELEASE_ARTIFACT: String by project

plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example"
    testNamespace = "$namespace.test"
    defaultConfig {
        applicationId = namespace
        multiDexEnabled = true
    }
    lint.abortOnError = false
}

dependencies {
    implementation(project(":$RELEASE_ARTIFACT-extension"))
    implementation(libs.material)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.multidex)
}