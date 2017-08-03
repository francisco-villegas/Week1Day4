package com.example.francisco.week1day4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        switch (intent.getAction()) {
            case "sendingPerson":
                Person person = (Person) intent.getParcelableExtra(getString(R.string.KEY1));
                Log.d(TAG, "onCreate: " + person.getName() + " " + person.getGender());
                Toast.makeText(this, person.getName() + " " + person.getGender(), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Second toast", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
