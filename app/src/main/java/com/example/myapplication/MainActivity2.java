package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity2 extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); // Убедитесь, что этот макет содержит dropdown_menu

        Spinner spinner = findViewById(R.id.dropdown_menu);
        if (spinner != null) {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.choice_color, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        } else {
            Log.e("MainActivity2", "Spinner не найден!");
        }

        Button buttonHeart = findViewById(R.id.heart_button);
        buttonHeart.setOnClickListener(v -> {
            if (buttonHeart.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.ic_heart).getConstantState())) {
                buttonHeart.setBackgroundResource(R.drawable.ic_heart_2);
            } else {
                buttonHeart.setBackgroundResource(R.drawable.ic_heart);
            }
        });

        findViewById(R.id.bottom_next).setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity2.class); // Убедитесь, что это правильно
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            finish();
        });

        String data = getIntent().getStringExtra("key");
        TextView textView = findViewById(R.id.text_ex);
        textView.setText(data);
    }

}