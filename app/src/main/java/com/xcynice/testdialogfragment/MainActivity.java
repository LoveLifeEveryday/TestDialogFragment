package com.xcynice.testdialogfragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements NiceDialogFragment.OnDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn_open_dialog);
        final NiceDialogFragment niceDialogFragment = new NiceDialogFragment(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                niceDialogFragment.show(getSupportFragmentManager(), "android");
            }
        });
    }

    @Override
    public void onDialogClick(String person) {
        Toast.makeText(this, "选择的人数是:" + person, Toast.LENGTH_SHORT).show();
    }
}