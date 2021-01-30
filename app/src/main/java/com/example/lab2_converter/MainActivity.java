package com.example.lab2_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {


    double value =0;

    TextView disp_conv, dispText, change_state;
    Button conv_act;
    EditText input_value;
    String text;
    DecimalFormat fmt = new DecimalFormat("#.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         Spinner spinner = findViewById(R.id.input_spin);
         ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.temp_conv, android.R.layout.simple_spinner_item);
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         spinner.setAdapter(adapter);
         spinner.setOnItemSelectedListener(this);



        input_value = findViewById(R.id.input_temp);
        disp_conv = findViewById(R.id.h_text);
        dispText = findViewById(R.id.show_conv);
        conv_act = findViewById(R.id.convert);
        change_state = findViewById(R.id.state);


        /* Adding a click event handler for button */

        conv_act.setOnClickListener(new View.OnClickListener() {

            @Override                /* Override the onClick method */
            public void onClick(View v){

                /* Calling ConvertFromCelsiusToFahrenheit and ConvertFromFahrenheitToCelsius */
                if ( text.equals("Celsius to Fahrenheit")) {

                    ConvertFromCelToFa();
                }

                else {

                    ConvertFromFatoCel();
                }
            }
        });

            /* Removes text in input box when clicked */

        input_value.setOnClickListener(new View.OnClickListener() {

            @Override                /* Override the onClick method */
            public void onClick(View v){

                input_value.setText("");
            }
        });


    }

    private void ConvertFromFatoCel() {


        String temp = input_value.getText().toString();

        double fah = Double.parseDouble(temp);

        double celsius = (fah - 32) * 5/9;

        /* Display the value in textView id: h_text */
        dispText.setText("" + fmt.format(celsius ) + " Celsius");


    }

    private void ConvertFromCelToFa() {

        /* This will convert Celsius to Fahrenheit*/

        String temp = input_value.getText().toString();

        double celsius = Double.parseDouble(temp);

        double fah = (celsius * 1.8) + 32;

        /* Display the value in textView id: h_text */
        dispText.setText("" + fmt.format(fah )+ " Fahrenheit");
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();

        change_state.setText("State: " + text);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



    }
}