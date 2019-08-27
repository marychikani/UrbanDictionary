package chikani.marycarmen.urbandictionary.ui.dictionary


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import chikani.marycarmen.urbandictionary.R
import chikani.marycarmen.urbandictionary.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ValidateInputTypeEditText {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun validateStringType(){
        onView(withId(R.id.word_to_search)).perform(typeText("text"))
    }
}