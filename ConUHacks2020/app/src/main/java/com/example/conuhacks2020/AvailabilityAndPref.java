package com.example.conuhacks2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AvailabilityAndPref extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availability_and_pref);

        Button nextBtn = (Button) findViewById(R.id.NextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSwipingAct = new Intent(AvailabilityAndPref.this, SwipingActivity.class);
               AvailabilityAndPref.this.startActivity(toSwipingAct);
            }
        });

        TextView monBegH = (TextView) findViewById(R.id.MonBegH);
        TextView monEndH = (TextView) findViewById(R.id.MonEndH);

        TextView tueBegH = (TextView) findViewById(R.id.TueBegH);
        TextView tueEndH = (TextView) findViewById(R.id.TueEndH);

        TextView wedBegH = (TextView) findViewById(R.id.WedBegH);
        TextView wedEndH = (TextView) findViewById(R.id.WedEndH);

        TextView thuBegH = (TextView) findViewById(R.id.ThuBegH);
        TextView thuEndH = (TextView) findViewById(R.id.ThuEndH);

        TextView friBegH = (TextView) findViewById(R.id.FriBegH);
        TextView friEndH = (TextView) findViewById(R.id.FriEndH);

        TextView pref1 = (TextView) findViewById(R.id.Pref1);
        TextView pref2 = (TextView) findViewById(R.id.Pref2);
        TextView pref3 = (TextView) findViewById(R.id.Pref3);
        TextView pref4 = (TextView) findViewById(R.id.Pref4);
        TextView pref5 = (TextView) findViewById(R.id.Pref5);
        TextView pref6 = (TextView) findViewById(R.id.Pref6);
        TextView pref7 = (TextView) findViewById(R.id.Pref7);
        TextView pref8 = (TextView) findViewById(R.id.Pref8);
        TextView pref9 = (TextView) findViewById(R.id.Pref9);
        TextView pref10 = (TextView) findViewById(R.id.Pref10);
        TextView pref11 = (TextView) findViewById(R.id.Pref11);
        TextView pref12 = (TextView) findViewById(R.id.Pref12);
    }
}
