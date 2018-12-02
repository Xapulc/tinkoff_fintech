package com.moonpi.swiftnotes.test

import android.os.Environment
import org.junit.BeforeClass
import java.io.File

open class AbstractTest<T>(val app: T) {
    companion object {
        @BeforeClass
        @JvmStatic
        fun deleteOldResults() {
            val resultPath = File(Environment.getExternalStorageDirectory()
                    .absolutePath + "/allure-results")

            if (resultPath.exists()) {
                resultPath.deleteRecursively()
            }
        }
    }
}