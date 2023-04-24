package com.devfiveurjc.agendaly;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.core.app.ActivityScenario;

import com.devfiveurjc.agendaly.activities.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class NavigationTest {

    @Test
    public void testNavigation() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.addFloatingButton)).perform(click());
        onView(withId(R.id.TaskAddFragment)).check(matches(isDisplayed()));
    }

}
