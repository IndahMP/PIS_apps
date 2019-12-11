package com.example.loginsigninpis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HasilKuis extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_kuis);

        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView nilai = (TextView)findViewById(R.id.nilai);

        hasil.setText("True  : "+TestKuis.benar+"\nFalse : "+TestKuis.salah);
        nilai.setText(""+TestKuis.hasil);
    }

    public void ulangi(View view){
        finish();
        Intent a = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(a);
    }
}

