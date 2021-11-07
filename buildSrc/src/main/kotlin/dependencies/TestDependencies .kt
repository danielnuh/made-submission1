package dependencies

object TestDependencies {
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val JUNIT_BOM = "org.junit:junit-bom:${Versions.JUNIT}"
    const val JUNIT_API = "org.junit.jupiter:junit-jupiter-api"
    const val JUNIT_ENGINE = "org.junit.jupiter:junit-jupiter-engine"
    const val JUNIT_PARAM = "org.junit.jupiter:junit-jupiter-params"
    const val ANDROIDX_CORE = "androidx.test:core-ktx:${Versions.TEST}"
    const val ARCH_CORE = "androidx.arch.core:core-testing:${Versions.ARCH_CORE}"
    const val EXT_JUNIT = "androidx.test.ext:junit:${Versions.EXT}"
    const val ROBOELECTRIC = "org.robolectric:robolectric:${Versions.ROBOELECTRIC}"

    const val TRUTH = "com.google.truth:truth:${Versions.TRUTH}"
    const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
    const val MOCK_WEB_SERVER = "com.squareup.okhttp3:mockwebserver:${Versions.MOCK_WEB_SERVER}"

    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
    const val ROOM = "androidx.room:room-testing:${Versions.ROOM}"
    const val PAGING = "androidx.paging:paging-common:${Versions.PAGING}"
}
