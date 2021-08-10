package com.example.snake;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import Juegos.Snake.JuegoSnake;

public class MainActivity extends AppCompatActivity {
    private JuegoSnake juegoSnake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}