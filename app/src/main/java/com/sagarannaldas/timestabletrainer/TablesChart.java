package com.sagarannaldas.timestabletrainer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import static com.sagarannaldas.timestabletrainer.R.*;

public class TablesChart extends AppCompatActivity {

    String chartID;

    ImageView tablesImageView;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;
    GridLayout gridLayout1, gridLayout2;

    public void showTable(View view) {

        Button button = (Button) view;

        tablesImageView.setImageResource(getResources().getIdentifier(button.getTag().toString(), "raw", getPackageName()));

//        Toast.makeText(this, "table " + view.getTag().toString(), Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_tablescharts);

        tablesImageView = findViewById(id.tablesImageView);
        gridLayout1 = findViewById(id.gridLayout1);
        gridLayout2 = findViewById(id.gridLayout2);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            chartID = extras.getString("TABLES_CHARTS_ID");

            //The key argument here must match that used in the other activity
        }

        if(chartID.equals("1")){

            tablesImageView.setImageResource(raw.one);
            gridLayout1.setVisibility(View.VISIBLE);

        } else {

            tablesImageView.setImageResource(raw.eleven);
            gridLayout2.setVisibility(View.VISIBLE);

        }
//        Toast.makeText(this, chartID, Toast.LENGTH_SHORT).show();

    }
}
