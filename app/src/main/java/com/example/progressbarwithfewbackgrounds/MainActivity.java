package com.example.progressbarwithfewbackgrounds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ContextWrapper;
import android.os.Bundle;

import com.example.progressbarwithfewbackgrounds.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private boolean greenBackground = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.progressBar.setProgress(75);
        binding.progressBar.setMax(100);

        binding.button.setOnClickListener(v -> {
            var id = R.drawable.background_pb_red;
            if (greenBackground) {
                id = R.drawable.background_pb_green;
            }
            var progressDrawable = ContextCompat.getDrawable(this , id);
            binding.progressBar.setProgressDrawable(progressDrawable);

            greenBackground = !greenBackground;
        });

    }
}