package com.taylorrbailey.week06activity;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateTask extends AsyncTask<Void, Integer, Void> {

    ProgressBar pbProgress;
    String filePath;
    Context _currentContext;

    CreateTask(ProgressBar pbProgress, String fileName, Context currentContext){
        this.pbProgress = pbProgress;
        this.filePath = fileName;
        this._currentContext = currentContext;
    }

    @Override
    protected void onPreExecute() {
        pbProgress.setProgress(0);
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params){
        try(FileOutputStream outputStream = _currentContext.openFileOutput(filePath, Context.MODE_PRIVATE)) {
            for (int i = 0; i < 10; i++) {

                String line = String.format("%d\n", i+1);
                outputStream.write(line.getBytes());
                Thread.sleep(250);
                publishProgress(i+1);
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
    protected void onProgressUpdate(Integer... values) {

        pbProgress.setProgress(values[0]);
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        pbProgress.setProgress(10);
        super.onPostExecute(aVoid);
    }
}
