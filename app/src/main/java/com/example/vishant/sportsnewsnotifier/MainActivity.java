/* Created by Vishant, Sep, Ahmed, Zack on 3/3/2018.
 */
package com.example.vishant.sportsnewsnotifier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    /*Spinners are dropdowns. sportSpinner = list of sports, teamSpinner = list of teams*/
    Spinner teamSpinner, sportSpinner;

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override

        /* onCreate loads the xml activity to begin. Spinners are dynamically created and arrays
        hardcoded in another file are stored into the spinners. We set the teamSpinner dropdown to be disabled
        first because we want to select a team first. After the user selects a sport/team, we want to pass this
        data into an intent to the secondactivity class. The intent is called when the user presses the next
        button. Start activity will pass information to the secondactivity.class which handles the next
        set of operations. */

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamSpinner = findViewById(R.id.spinner);
        sportSpinner = findViewById(R.id.spinner2);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this,
                R.array.Sports_array, android.R.layout.simple_spinner_item);
        teamSpinner.setAdapter(adapter1);
        teamSpinner.setOnItemSelectedListener(this);
        sportSpinner.setEnabled(false);
        Button nextButton = findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    /* onItemSelected is a method that executes when a sport is selected. After a sport is selected, we enable
       the teamSpinner and populate that spinner with the appropriate array holding team values for that sport.
       We need to take the spinner value for the team and parse it so that we get news items relating to that team
       (we are only receiving general news).
     */
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        if (teamSpinner.getSelectedItem().equals("NBA")) {
            Toast.makeText(getApplicationContext(), "NBA",
                    Toast.LENGTH_SHORT).show();
            sportSpinner.setEnabled(true);
            ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,
                    R.array.NBA_array, android.R.layout.simple_spinner_item);
            sportSpinner.setAdapter(adapter2);
        } else if (teamSpinner.getSelectedItem().equals("MLB")) {
            Toast.makeText(getApplicationContext(), "MLB",
                    Toast.LENGTH_SHORT).show();
            sportSpinner.setEnabled(true);
            ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,
                    R.array.MLB_array, android.R.layout.simple_spinner_item);
            sportSpinner.setAdapter(adapter2);
        } else if (teamSpinner.getSelectedItem().equals("NFL")) {
            Toast.makeText(getApplicationContext(), "NFL",
                    Toast.LENGTH_SHORT).show();
            sportSpinner.setEnabled(true);
            ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,
                    R.array.NFL_array, android.R.layout.simple_spinner_item);
            sportSpinner.setAdapter(adapter2);
        } else if (teamSpinner.getSelectedItem().equals("NHL")) {
            Toast.makeText(getApplicationContext(), "NHL",
                    Toast.LENGTH_SHORT).show();
            ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,
                    R.array.NHL_array, android.R.layout.simple_spinner_item);
            sportSpinner.setAdapter(adapter2);
            sportSpinner.setEnabled(true);
        }
    }
}