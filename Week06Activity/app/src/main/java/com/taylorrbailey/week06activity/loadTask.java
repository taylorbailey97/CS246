package com.taylorrbailey.week06activity;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class loadTask extends AsyncTask<Void, String, Void> {
    ProgressBar _progressBar;
    String _fileName;
    Context _currentContext;
    ArrayAdapter<String> adapter;

    loadTask(ProgressBar pbProgress, String fileName, Context theContext, ArrayAdapter<String> stringArrayAdapter){
        _progressBar = pbProgress;
        _fileName = fileName;
        _currentContext = theContext;
        adapter = stringArrayAdapter;
    }

    @Override
    protected void onPreExecute() {
        _progressBar.setProgress(0);
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(_currentContext.openFileInput(_fileName)))) {

            String theLine;
            while ((theLine = br.readLine()) != null) {
                publishProgress(theLine);
                Thread.sleep(250);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {

        adapter.add(values[0]);

        _progressBar.setProgress(adapter.getCount());

        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        _progressBar.setProgress(10);
        super.onPostExecute(aVoid);
    }
}
