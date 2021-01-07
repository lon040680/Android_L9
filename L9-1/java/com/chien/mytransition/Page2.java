package com.chien.mytransition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;

public class Page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        //建立動畫物件
        Transition explode = TransitionInflater.from(this).inflateTransition(android.R.transition.explode);
        Transition slide = TransitionInflater.from(this).inflateTransition(android.R.transition.slide_left);
        Transition fade = TransitionInflater.from(this).inflateTransition(android.R.transition.fade);
        Transition myfade = TransitionInflater.from(this).inflateTransition(R.transition.fade);

        //指定執行時間點
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(myfade);
    }

    public void onClick(View view) {
        Intent it2 = new Intent();
        it2.setClass(Page2.this, MainActivity.class);

        startActivity(it2, ActivityOptionsCompat
                .makeSceneTransitionAnimation(Page2.this).toBundle());
    }
}