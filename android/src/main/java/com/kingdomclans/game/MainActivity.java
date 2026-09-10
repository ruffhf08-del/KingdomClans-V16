package com.kingdomclans.game;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Initialize Game Manager
        GameManager.getInstance().init(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        GameManager.getInstance().resume();
    }

    @Override
    protected void onPause() {
        GameManager.getInstance().pause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        GameManager.getInstance().dispose();
        super.onDestroy();
    }
}
