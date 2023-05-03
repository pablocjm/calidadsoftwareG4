package com.devfiveurjc.agendaly;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.contrib.RecyclerViewActions;

import com.devfiveurjc.agendaly.activities.MainActivity;

import org.junit.Test;


public class NavigationTest {

    @Test
    public void testNavigationCreated() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.addFloatingButton)).perform(click());
        onView(withId(R.id.taskAddDate)).check(matches(isDisplayed()));
    }

    @Test
    public void testNavigationEdit() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.listRecyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        onView(withId(R.id.taskInfoEditButton)).check(matches(isDisplayed()));
    }

    @Test
    public void testNavigationSettings() {
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.listRecyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));
        onView(withId(R.id.taskInfoEditButton)).perform(click());
        onView(withId(R.id.taskEditSaveButton)).check(matches(isDisplayed()));
    }

}