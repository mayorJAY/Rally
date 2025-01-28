package com.example.compose.rally

import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import com.example.compose.rally.ui.components.RallyTabRow
import com.example.compose.rally.ui.theme.RallyTheme
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyTopAppBarTest() {
        composeTestRule.setContent {
            RallyTheme {
                RallyTabRow(
                    allScreens = rallyTabRowScreens,
                    onTabSelected = { },
                    currentScreen = Accounts
                )
            }
        }

        composeTestRule
            .onNodeWithContentDescription(Accounts.route)
            .assertIsSelected()
    }

    @Test
    fun rallyTopAppBarTest_currentLabelExists() {
        composeTestRule.setContent {
            RallyTheme {
                RallyTabRow(
                    allScreens = rallyTabRowScreens,
                    onTabSelected = { },
                    currentScreen = Accounts
                )
            }
        }

        composeTestRule
            .onNode(
                hasText(Accounts.route.uppercase()) and
                        hasParent(hasContentDescription(Accounts.route)),
                useUnmergedTree = true
            )
            .assertExists()
    }
}