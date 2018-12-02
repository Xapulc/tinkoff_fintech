package com.moonpi.swiftnotes.test

import android.support.test.runner.AndroidJUnit4
import com.moonpi.swiftnotes.application.App
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.annotations.DisplayName
import ru.tinkoff.allure.step

@RunWith(AndroidJUnit4::class)
@DisplayName("Тестирование Swiftnotes")
class Test : AbstractTest<App>(App()) {
    @Test
    @DisplayName("Тестирование кнопки NO")
    fun testButtonNo() {
        app.launchActivity()
        step("Проверка основных элементов на главном экране") {
            app.checkMainMenu()
            deviceScreenshot("Главное меню")
        }

        step("Проверка элементов при создании заметки") {
            app.createNewNote()
            app.checkDefaultNote()
            deviceScreenshot("Меню создание заметки")
        }

        step("Проверка диалогового окна при выходе из режима редактирования заметки") {
            app.goBack()
            app.goBack()
            app.checkSaveDialog()
            deviceScreenshot("Диалоговое окно")
        }

        step("Проверка открытия стартового экрана") {
            app.saveChanges(false)
            app.checkMainMenu()
            deviceScreenshot("Главное меню после диалогового окна")
        }
    }

    private val titleText = "Заметка 1"
    private val noteText = "Тестовая запись 1"

    @Test
    @DisplayName("Тестирование заполнения текста")
    fun testFillingText() {
        app.launchActivity()
        step("Открытие меню создания заметки") {
            app.createNewNote()
            deviceScreenshot("Меню создание заметки")
        }
        step("Открытие меню создания заметки") {
            app.fillTitle(titleText)
            app.fillNote(noteText)

            app.checkTitleEdit(titleText)
            app.checkNoteEdit(noteText)

            deviceScreenshot("Введен некоторый текст")
        }
        step("Проверка диалогового окна при выходе из режима редактирования заметки") {
            app.goBack()
            app.goBack()
            app.checkSaveDialog()
            deviceScreenshot("Диалоговое окно")
        }
        step("Проверка сохранения изменений") {
            app.saveChanges(true)
            app.checkTitleMain(titleText)
            app.checkNoteMain(noteText)
            deviceScreenshot("Главное меню с новой записью")
        }
    }

    @Test
    @DisplayName("Тестирование дополнительного функционала")
    fun testAddFunctional() {
        app.launchActivity()
        step("Проверка дополнительных кнопок на главном экране") {
            app.openMenu()
            app.checkAddFuncMain()
            deviceScreenshot("Дополнительный функционал на главном экране")
//            click on free space
            app.goBack()
        }
        step("Открытие меню создания заметки") {
            app.createNewNote()
            deviceScreenshot("Меню создание заметки")
        }
        step("Проверка дополнительных кнопок на экране редактора заметки") {
            app.openMenu()
            app.checkAddFuncEdit()
            deviceScreenshot("Дополнительный функционал на экране редактора заметки")
        }
    }
}