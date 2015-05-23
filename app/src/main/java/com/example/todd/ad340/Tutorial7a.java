package com.example.todd.ad340;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Tutorial7a extends ActionBarActivity {

    private int numberOfClicks = 0;

    public TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial7a);
        mText = (TextView) findViewById(R.id.threading_change);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tutorial7a, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void threading_click(View view) {
        new SortingTask().execute(1000000);
    }

    public void threading2_click(View view) {
        ++numberOfClicks;
        mText.setText("I've been clicked: "+ Integer.toString(numberOfClicks));
    }

    public class SortingTask extends AsyncTask<Integer, Void, String>
    {
        protected String doInBackground(Integer... num)
        {
            Random rand = new Random();
            int numberOfRandomNumbers = num[0];

            ArrayList<Integer> listOfRandomIntegers = new ArrayList<Integer>();
            for(int i = 0; i<numberOfRandomNumbers; ++i)
            {
                listOfRandomIntegers.add(rand.nextInt());
            }

            Collections.sort(listOfRandomIntegers);
            String returningList = "";
            for(int j =0; j<listOfRandomIntegers.size(); ++j)
            {
                returningList += Integer.toString(listOfRandomIntegers.get(j)) +" ";
            }

            return returningList;
        }

        protected void onPostExecute(String... str)
        {
            mText.setText(str[0]);
        }
    }
}


