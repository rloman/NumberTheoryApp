package nl.carpago.numbertheoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayNumberPropertiesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_number_properties);

        Intent intent = this.getIntent();

        int number = intent.getIntExtra(MainActivity.NUMBER_KEY, 0);

        TextView textView = (TextView) this.findViewById(R.id.numberText);
        textView.setText(String.format("Properties of '%d'", number));

    }
}
