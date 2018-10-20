package com.taylorrbailey.scripturereference;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class scriptReference extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.SciptureReference.MESSAGE";
    public static String TAG = "scriptReference";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_script_reference);
    }

    public void sendReference(View view) {
        Intent intent = new Intent(this, DisplayScripture.class);
        EditText book = (EditText) findViewById(R.id.bookText);
        EditText chapter = (EditText) findViewById(R.id.chapterText);
        EditText verses = (EditText) findViewById(R.id.versesText);

        String message = book.getText().toString() + " " + chapter.getText().toString() + ":" + verses.getText().toString();
        String[] messageArray = {book.getText().toString(), chapter.getText().toString(), verses.getText().toString()};
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("values", messageArray);
        Log.d(TAG, "About to create intent with " + message);
        startActivity(intent);
    }

}
