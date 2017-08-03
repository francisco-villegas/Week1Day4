package com.example.francisco.week1day4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText, etPersonName, etPersonGender;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.etname);
        textView = (TextView) findViewById(R.id.tvName);

        etPersonName = (EditText) findViewById(R.id.PersonName);
        etPersonGender = (EditText) findViewById(R.id.PersonGender);

    }

    public void doSomething(View view) {
        switch (view.getId()){
            case R.id.btnChangeText:
                String data = editText.getText().toString();
                textView.setText(data);
                break;
            case R.id.btnGoToSecond:

                String personName = etPersonName.getText().toString();
                String personGender = etPersonGender.getText().toString();

                Person person = new Person(personName,personGender);

                Intent intent = new Intent(this,SecondActivity.class);
                intent.setAction("sendingPerson");
                intent.putExtra(getString(R.string.KEY1), person);
                startActivity(intent);
                break;
            case R.id.btnShareData:

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,"This is a message2");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String data = textView.getText().toString();
        outState.putString("data", data);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        textView.setText(savedInstanceState.getString("data"));
    }

}
