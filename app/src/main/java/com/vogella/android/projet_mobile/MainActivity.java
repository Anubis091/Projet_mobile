package com.vogella.android.projet_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vogella.android.projet_mobile.controller.MainController;

public class MainActivity extends AppCompatActivity {

    public static void main(String[] args) {
        MainController controller = new MainController();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
