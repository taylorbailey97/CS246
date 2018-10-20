package com.taylorrbailey.scripturereference;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class DisplayScripture extends AppCompatActivity {
    public static String TAG = "DisplayScripture";
    public String message;
    public String[] messageArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scripture);

        Intent intent = getIntent();
        messageArray = (String[])intent.getSerializableExtra("values");
        message = intent.getStringExtra(scriptReference.EXTRA_MESSAGE);
        Log.d(TAG, "Received intent with " + message);
        TextView textView = findViewById(R.id.displayText);
        textView.setText(message);
    }

}
