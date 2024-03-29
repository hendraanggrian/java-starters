val releaseGroup: String by project
val releaseArtifact: String by project

plugins {
    alias(libs.plugins.android.library)
    checkstyle
    jacoco
    alias(libs.plugins.maven.publish)
}

android {
    namespace = "$releaseGroup.$releaseArtifact"
    testNamespace = "$namespace.test"
    buildFeatures.buildConfig = false
    testOptions.unitTests.isIncludeAndroidResources = true
    buildTypes {
        debug {
            enableAndroidTestCoverage = true
        }
    }
}

dependencies {
    checkstyle(libs.rulebook.checkstyle)

    implementation(libs.androidx.appcompat)

    testImplementation(libs.bundles.androidx.test)
}
