package com.taylorrbailey.week06activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar pbProgress;
    ListView lvList;
    ArrayAdapter<String> stringArrayAdapter;

    public static String FILENAME = "numbers.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loadButton = (Button)findViewById(R.id.loadButton);
        Button clearButton = (Button)findViewById(R.id.clearButton);
        Button createButton = (Button)findViewById(R.id.createButton);

        pbProgress = (ProgressBar)findViewById(R.id.pbLoading);
        lvList = (ListView)findViewById(R.id.lvList);

        stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lvList.setAdapter(stringArrayAdapter);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateTask c = new CreateTask(pbProgress, FILENAME, MainActivity.this);
                c.execute();
            }
        });

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTask l = new loadTask(pbProgress, FILENAME, MainActivity.this, stringArrayAdapter);
                l.execute();
            }
        });


        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringArrayAdapter.clear();
            }
        });
    }
}
