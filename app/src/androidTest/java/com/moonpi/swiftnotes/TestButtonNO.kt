package com.moonpi.swiftnotes

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.annotations.DisplayName
import ru.tinkoff.allure.step

@RunWith(AndroidJUnit4::class)
@DisplayName("Тестирование кнопки NO")
class TestButtonNO : App() {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    @DisplayName("Тестирование кнопки NO")
    fun test() {
        step("Проверка основных элементов на главном экране") {
            checkText(R.string.app_name, "Swiftnotes")
            checkText(R.string.no_notes_text, "Press \'+\' to add new note")
            checkId(R.id.newNote)
            deviceScreenshot("Главное меню")
            clickId(R.id.newNote)
        }

        step("Проверка элементов при создании заметки") {
            checkId(R.id.titleEdit, "Title")
            checkId(R.id.bodyEdit, "Note")
            deviceScreenshot("Меню создание заметки")
        }

//        step("Проверка диалогового окна при выходе из режима редактирования заметки") {
//
//        }
    }

//    @Test
//    fun test() {
//        checkText(R.string.app_name, "Swiftnotes")
//        checkText(R.string.no_notes_text, "Press \'+\' to add new note")
//        checkId(R.id.newNote)
//        clickId(R.id.newNote)
//
//        checkId(R.id.titleEdit, "Title")
//        checkId(R.id.bodyEdit, "Note")
//    }
}