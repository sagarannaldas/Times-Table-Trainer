package com.sagarannaldas.timestabletrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button tablesChartsButton1, tablesChartsButton2, quiz1Button, quiz2Button, rateButton;


    public void tablesCharts(View view){

        Button button = (Button) view;

        Log.i("Tables Button pressed", button.getTag().toString());

        Intent intent = new Intent(MainActivity.this, TablesChart.class);
        intent.putExtra("TABLES_CHARTS_ID", button.getTag().toString());
        startActivity(intent);

    }

    public void quiz(View view){

        Button button = (Button) view;

        Log.i("Quiz Button pressed", button.getTag().toString());

        Intent intent = new Intent(MainActivity.this, Quiz.class);
        intent.putExtra("QUIZ_ID", button.getTag().toString());
        startActivity(intent);


    }

    public void rate(View view){

        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*tablesChartsButton1 = findViewById(R.id.tablesChartsButton1);
        tablesChartsButton2 = findViewById(R.id.tablesChartsButton2);
        quiz1Button = findViewById(R.id.quiz1Button);
        quiz2Button = findViewById(R.id.quiz2button);
        rateButton = findViewById(R.id.rateButton);*/
    }
}
