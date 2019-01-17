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

        // maf moet naar Java 8 en dat wil ik ook hier!
        String formattedString ="";
        for(Integer element: primeFactors) {
            formattedString += element.toString()+".";
        }
        formattedString = formattedString.substring(0, formattedString.length()-1);

        primeFactorsTextView.setText(formattedString);

        // crap need Java 8
        List<Integer> divisors = this.service.divisors(number);
        int sumOfDivisors = 0;
        formattedString = "";
        for(int element: divisors) {
            formattedString += element +".";
            sumOfDivisors += element;
        }
        formattedString = formattedString.substring(0, formattedString.length()-1);
        TextView divisorsTextiew = (TextView) this.findViewById(R.id.divisorsTextView);
        divisorsTextiew.setText(formattedString);

        CheckBox checkboxPerfectNumber = (CheckBox) this.findViewById(R.id.perfectNumberCheckbox);
        checkboxPerfectNumber.setChecked(sumOfDivisors == number);
    }


}
