package com.example.todd.ad340;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class Tutorial7b extends ActionBarActivity {

    private ViewGroup mSceneRoot;
    private Scene mAScene;
    private Scene mAnotherScene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial7b);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tutorial7b, menu);
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

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void scene_click(View view) {
        mSceneRoot = (ViewGroup) findViewById(R.id.scene_root);

        mAScene = Scene.getSceneForLayout(
                mSceneRoot,
                R.layout.a_scene,
                this);

        mAnotherScene = Scene.getSceneForLayout(
                mSceneRoot,
                R.layout.another_scene,
                this);


        Transition fade = new Fade(Fade.IN);

        TransitionManager.go(mAnotherScene, fade);
    }
}
