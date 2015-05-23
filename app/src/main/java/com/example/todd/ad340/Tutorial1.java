package com.example.todd.ad340;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Tutorial1 extends ActionBarActivity implements GestureDetector.OnGestureListener{

    public float halfHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String getMe = getIntent().getStringExtra("setMeTag");
        TextView text = (TextView) findViewById(R.id.intentHere);
        text.setText(getMe);
        setContentView(R.layout.activity_tutorial1);

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String defaultValue = sharedPref.getString(
                String.valueOf(R.string.save_string_key),
                String.valueOf(R.string.type_here));

        EditText text = (EditText) findViewById(R.id.saveText);
        text.setText(defaultValue);

        halfHeight = (float) text.getHeight()/2;

        text.setOnTouchListener(new View.OnTouchListener() {
            public final String DEBUG_TAG = "Gestures";

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(DEBUG_TAG, "onTouch: " + event.toString());
                MotionEvent.PointerCoords outCoord = new MotionEvent.PointerCoords();
                event.getPointerCoords(0,outCoord);
                if(outCoord.y > halfHeight)
                {
                    launchEvent();
                }
                return true;
            }
        });


    }

    private void launchEvent()
    {
        Intent intent = new Intent(this, Tutorial1a.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        EditText text = (EditText) findViewById(R.id.saveText);
        editor.putString(String.valueOf(R.string.save_string_key), text.getText().toString());
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tutorial1, menu);
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

    @Override
    public boolean onDown(MotionEvent e) {

        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
