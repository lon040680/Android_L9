package com.chien.mytransition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //建立動畫物件 這是切換頁面(Activity)時可以看到的動畫 設定了四個 
        Transition explode = TransitionInflater.from(this).inflateTransition(android.R.transition.explode);
        Transition slide = TransitionInflater.from(this).inflateTransition(android.R.transition.slide_left);
        Transition fade = TransitionInflater.from(this).inflateTransition(android.R.transition.fade);
        Transition myfade = TransitionInflater.from(this).inflateTransition(R.transition.fade);

        //指定執行時間點 選擇上方設定 頁面 進(setEnterTransition) 出(setExitTransition) 的動畫
        getWindow().setEnterTransition(myfade);
        getWindow().setExitTransition(fade);
    }

    public void onClick(View view) {
        Intent it = new Intent();
        it.setClass(MainActivity.this, Page2.class);

        startActivity(it, ActivityOptionsCompat
                .makeSceneTransitionAnimation(MainActivity.this).toBundle());
    }
}
