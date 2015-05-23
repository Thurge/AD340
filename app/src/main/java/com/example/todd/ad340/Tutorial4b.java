package com.example.todd.ad340;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;


public class Tutorial4b extends ActionBarActivity {
    public static String setMe = "";
    public static final String setMeTag = "setMeTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial4b);

        EditText edit= (EditText) findViewById(R.id.textBox);
        setMe = edit.getText().toString();
        edit.setOnEditorActionListener(
                new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(
                        TextView v,
                        int actionId,
                        KeyEvent event) {
                    boolean handled = false;
                    if(actionId == EditorInfo.IME_ACTION_GO)
                    {
                        handled = true;
                        Intent in = new Intent(Tutorial4b.this, Tutorial1.class);
                        in.putExtra(setMeTag, setMe);
                        startActivity(in);
                    }
                    return handled;
                }
            }

        );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tutorial4b, menu);
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
}
