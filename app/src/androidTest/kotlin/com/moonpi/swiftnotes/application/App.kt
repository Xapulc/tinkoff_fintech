package com.moonpi.swiftnotes.application

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.moonpi.swiftnotes.MainActivity
import com.moonpi.swiftnotes.R
import org.hamcrest.CoreMatchers.allOf
import com.moonpi.swiftnotes.util.byContentDesc
import com.moonpi.swiftnotes.util.waitFindObject
import java.lang.Thread.sleep


open class App: AbstractApp<MainActivity>(MainActivity::class.java) {
    fun checkMainMenu() {
        onView(withText("Swiftnotes"))
                .check(matches(isDisplayed()))
        onView(withText("Press \'+\' to add new note"))
                .check(matches(isDisplayed()))
        onView(withId(R.id.newNote))
                .check(matches(isDisplayed()))
    }

    fun createNewNote() {
        onView(allOf(withId(R.id.newNote), isDisplayed()))
                .perform(click())
    }

    fun checkTitleMain(title: String) {
        onView(allOf(withId(R.id.titleView), isDisplayed()))
                .check(matches(withText(title)))
    }

    fun checkNoteMain(note: String) {
        onView(allOf(withId(R.id.bodyView), isDisplayed()))
                .check(matches(withText(note)))
    }

    fun openMenu() {
        byContentDesc("Ещё").waitFindObject().click()
    }

    fun checkAddFuncMain() {
        onView(withText("Backup notes"))
                .check(matches(isDisplayed()))
        onView(withText("Restore notes"))
                .check(matches(isDisplayed()))
        onView(withText("Rate app"))
                .check(matches(isDisplayed()))
    }


    fun checkDefaultNote() {
        onView(withHint("Title"))
                .check(matches(isDisplayed()))
        onView(withHint("Note"))
                .check(matches(isDisplayed()))
    }

    fun fillTitle(title: String) {
        onView(allOf(withId(R.id.titleEdit), isDisplayed()))
                .perform(replaceText(title))
    }

    fun fillNote(note: String) {
        onView(allOf(withId(R.id.bodyEdit), isDisplayed()))
                .perform(replaceText(note))
    }

    fun checkTitleEdit(title: String) {
        onView(allOf(withId(R.id.titleEdit), isDisplayed()))
                .check(matches(withText(title)))
    }

    fun checkNoteEdit(note: String) {
        onView(allOf(withId(R.id.bodyEdit), isDisplayed()))
                .check(matches(withText(note)))
    }

    fun checkAddFuncEdit() {
        onView(withText("Note font size"))
                .check(matches(isDisplayed()))
        onView(withText("Hide note body in list"))
                .check(matches(isDisplayed()))
    }


    fun checkSaveDialog() {
        onView(withText("Save changes?"))
                .check(matches(isDisplayed()))
        onView(withText("Yes"))
                .check(matches(isDisplayed()))
        onView(withText("No"))
                .check(matches(isDisplayed()))
    }

    fun saveChanges(agreement: Boolean) {
        if (agreement) {
            onView(allOf(withText(R.string.yes_button), isDisplayed()))
                    .perform(click())
        } else {
            onView(allOf(withText(R.string.no_button), isDisplayed()))
                    .perform(click())
        }
    }
}