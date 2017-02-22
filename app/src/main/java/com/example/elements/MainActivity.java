package com.example.elements;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_SHORT).show();

                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.toast_view, (ViewGroup) findViewById(R.id.toast_container));
                TextView textView = (TextView) view.findViewById(R.id.textView2);

                textView.setText("Toast");

                Toast toast = new Toast(MainActivity.this);
                toast.setView(view);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        Log.d("MainActivity", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("MainActivity", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("MainActivity", "onDestroy");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.d("MainActivity", "onConfigurationChanged");
    }
}
