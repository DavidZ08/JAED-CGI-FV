package com.example.conuhacks2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.logInButton);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userNameEditText = (EditText) findViewById(R.id.UsernameEditText); // check the view on the XML for element on screen with same ID
                EditText passwordEditText = (EditText) findViewById(R.id.PwEditText);

                String user = userNameEditText.getText().toString();
                String pwrd = passwordEditText.getText().toString();
                if (user.equals("test") && pwrd.equals("test")) {
                    Intent toProfileConfig = new Intent(MainActivity.this, AvailabilityAndPref.class);
                    MainActivity.this.startActivity(toProfileConfig);
                }
            }
        });
    }
}
