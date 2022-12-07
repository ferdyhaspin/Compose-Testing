package org.ferdyhaspin.compose_testing.ui

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.ferdyhaspin.compose_testing.ui.theme.ComposeTestingTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.ferdyhaspin.compose_testing.R
/**
 * Created by ferdyhaspin on 07/12/22.
 */
class CalculatorAppTest {
//    @get:Rule
//    val composeTestRule = createComposeRule()

    @get:Rule
    val composeTestRuleAndroid = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
//        composeTestRule.setContent {
//            ComposeTestingTheme {
//                CalculatorApp()
//            }
//        }
        composeTestRuleAndroid.setContent {
            ComposeTestingTheme {
                CalculatorApp()
            }
        }
    }

//    @Test
//    fun calculate_area_of_rectangle_correct() {
//        composeTestRule.onNodeWithText("Masukkan panjang").performTextInput("3")
//        composeTestRule.onNodeWithText("Masukkan lebar").performTextInput("4")
//        composeTestRule.onNodeWithText("Hitung!").performClick()
//        composeTestRule.onNodeWithText("Hasil: 12.0").assertExists()
//    }

    @Test
    fun calculate_area_of_rectangle_correct_android() {
        composeTestRuleAndroid.onNodeWithText(composeTestRuleAndroid.activity.getString(R.string.enter_length))
            .performTextInput("3")
        composeTestRuleAndroid.onNodeWithText(composeTestRuleAndroid.activity.getString(R.string.enter_width))
            .performTextInput("4")
        composeTestRuleAndroid.onNodeWithText(composeTestRuleAndroid.activity.getString(R.string.count))
            .performClick()
        composeTestRuleAndroid.onNodeWithText(composeTestRuleAndroid.activity.getString(R.string.result, 12.0))
            .assertExists()
    }

    @Test
    fun wrong_input_not_calculated() {
        composeTestRuleAndroid.onNodeWithText(composeTestRuleAndroid.activity.getString(R.string.enter_length))
            .performTextInput("..3")
        composeTestRuleAndroid.onNodeWithText(composeTestRuleAndroid.activity.getString(R.string.enter_width))
            .performTextInput("4")
        composeTestRuleAndroid.onNodeWithText(composeTestRuleAndroid.activity.getString(R.string.count))
            .performClick()
        composeTestRuleAndroid.onNodeWithText(composeTestRuleAndroid.activity.getString(R.string.result, 0.0))
            .assertExists()
    }
}