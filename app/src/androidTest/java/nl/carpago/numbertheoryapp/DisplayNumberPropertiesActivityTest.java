package nl.carpago.numbertheoryapp;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@MediumTest
@RunWith(AndroidJUnit4.class)
public class DisplayNumberPropertiesActivityTest {

    @Rule
    public ActivityTestRule<DisplayNumberPropertiesActivity> rule  = new  ActivityTestRule<DisplayNumberPropertiesActivity>(DisplayNumberPropertiesActivity.class)
    {
        @Override
        protected Intent getActivityIntent() {
            InstrumentationRegistry.getTargetContext();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.putExtra(MainActivity.NUMBER_KEY, 42);

            return intent;
        }
    };


    @Test
    public void ensureIntentDataIsDisplayed() throws Exception {
        DisplayNumberPropertiesActivity activity = rule.getActivity();

        {
            View viewById = activity.findViewById(R.id.checkBoxEven);

            assertThat(viewById,notNullValue());
            assertThat(viewById, instanceOf(TextView.class));
            TextView textView = (TextView) viewById;
            assertThat(textView.getText().toString(),is("Even"));
        }

        {
            View viewById = activity.findViewById(R.id.divisorsLabel);

            assertThat(viewById,notNullValue());
            assertThat(viewById, instanceOf(TextView.class));
            TextView textView = (TextView) viewById;
            assertThat(textView.getText().toString(),is("Divisors:"));
        }

        {
            View viewById = activity.findViewById(R.id.divisorsTextView);

            assertThat(viewById,notNullValue());
            assertThat(viewById, instanceOf(TextView.class));
            TextView textView = (TextView) viewById;
            assertThat(textView.getText().toString(),is("[1, 2, 3, 6, 7, 14, 21]"));
        }

    }

}
