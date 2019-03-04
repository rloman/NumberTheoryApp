package nl.carpago.numbertheoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String NUMBER_KEY = "nl.carpago.numberapp.NUMBER_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNumber(View view) {
        Intent intent = new Intent(this, DisplayNumberPropertiesActivity.class);

        EditText editText = (EditText) findViewById(R.id.editText);
        int number = Integer.valueOf(editText.getText().toString());
        intent.putExtra(NUMBER_KEY, number);

        startActivity(intent);

    }

    public void setRandom(View view) {
        int random = (int) (1+ Math.random()*1000);
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText(String.valueOf(random));
    }
}
