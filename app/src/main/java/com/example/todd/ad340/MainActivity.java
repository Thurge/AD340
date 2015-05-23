package com.example.todd.ad340;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void tutorial1_click(View view) {
        Intent intent = new Intent(this, Tutorial1.class);
        startActivity(intent);
    }

    public void tutorial4a_click(View view) {
        Intent intent = new Intent(this, Tutorial4a.class);
        startActivity(intent);
    }

    public void tutorial4b_click(View view) {
        Intent intent = new Intent(this, Tutorial4b.class);
        startActivity(intent);
    }

    public void tutorial5a_click(View view) {
        Intent intent = new Intent(this, Tutorial5a.class);
        startActivity(intent);
    }

    public void tutorial6b_click(View view) {
        Intent intent = new Intent(this, Tutorial6b.class);
        startActivity(intent);
    }

    public void map_click(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void tutorial7a_click(View view) {
        Intent intent = new Intent(this, Tutorial7a.class);
        startActivity(intent);
    }

    public void tutorial7b_click(View view) {
        Intent intent = new Intent(this, Tutorial7b.class);
        startActivity(intent);
    }
}
