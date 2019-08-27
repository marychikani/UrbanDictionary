package chikani.marycarmen.urbandictionary.ui.dictionary

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import chikani.marycarmen.urbandictionary.R
import chikani.marycarmen.urbandictionary.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith




@RunWith(AndroidJUnit4::class)
class ShowButtonSearch {


    @get:Rule
    var activityActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun editInput(){
        onView(withId(R.id.btn_search)).check(matches(isDisplayed()))
    }
}