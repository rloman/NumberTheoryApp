package nl.carpago.numbertheoryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nl.carpago.numbertheoryapp.tools.NumberTheoryService;

public class DisplayNumberPropertiesActivity extends AppCompatActivity {

    private NumberTheoryService service;

    public DisplayNumberPropertiesActivity() {
        this.service = new NumberTheoryService();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_number_properties);

        Intent intent = this.getIntent();

        int number = intent.getIntExtra(MainActivity.NUMBER_KEY, 0);

        TextView textView = (TextView) this.findViewById(R.id.numberText);
        textView.setText(String.format("Properties of '%d'", number));

        CheckBox checkBoxEven = (CheckBox) this.findViewById(R.id.checkBoxEven);
        checkBoxEven.setChecked(this.service.isEven(number));

        CheckBox checkboxPrime = (CheckBox) this.findViewById(R.id.checkBoxPrime);
        checkboxPrime.setChecked(this.service.isPrime(number));

        // prime factors
        TextView primeFactorsTextView = (TextView) this.findViewById(R.id.primeFactorsTextView);
        List<Integer> primeFactors = this.service.po(number);

        primeFactorsTextView.setText(primeFactors.toString());

        List<Integer> divisors = this.service.divisors(number);

        TextView divisorsTextiew = (TextView) this.findViewById(R.id.divisorsTextView);
        divisorsTextiew.setText(divisors.toString());

        CheckBox checkboxPerfectNumber = (CheckBox) this.findViewById(R.id.perfectNumberCheckbox);
        checkboxPerfectNumber.setChecked(this.service.isPerfectNumber(number));
    }

}
