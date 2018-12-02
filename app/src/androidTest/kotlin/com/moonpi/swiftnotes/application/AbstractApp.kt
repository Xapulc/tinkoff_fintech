package com.moonpi.swiftnotes.application

import android.app.Activity
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.pressBack
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import java.io.File
import kotlin.io.deleteRecursively

abstract class AbstractApp<T : Activity>(val activity: Class<T>) {
    @get:Rule
    var activityRule:  ActivityTestRule<T>
            = object : ActivityTestRule<T>(activity, false, false) {
        override fun beforeActivityLaunched() {
            super.beforeActivityLaunched()
            deleteUserData()
        }
    }

    private fun deleteUserData() {
        val appPath = InstrumentationRegistry.getTargetContext().filesDir.parentFile

        if (appPath.exists()) {
            val childList = appPath.list()
            for (child in childList) {
                if (child != "lib") {
                    File(appPath, child).deleteRecursively()
                }
            }
        }
    }

    open fun launchActivity() {
        activityRule.launchActivity(null)
    }

    fun goBack() {
        pressBack()
    }
}