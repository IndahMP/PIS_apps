package com.example.loginsigninpis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class TestKuis extends AppCompatActivity {

    TextView kuis;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //pertanyaan
    String[] pertanyaan_kuis = new String[]{
            "1. ..... the demands of aerospace, medicine, and agriculture, aengineers, are creating exotic new metallic substances.",
            "2. ..... James A. Bland, Carry Me Back to Old Virginny was adopted is the state song of Virginia in 1940.",
            "3. Mary Garden, ..... the early 1900s was considered one of the best singing actresses of her time.",
            "4. In the realm of psychological theory Margaret F. Washburn was a dualist ..... that motor phenomena have an essential role in psychology.",
            "5. ..... was backed up for miles on freeway"
    };

    //pilihan jawaban a, b, c, d
    String[] pilihan_jawaban = new String[]{
            "Meet", "Being met are" , "To meet" , "They are meeting",
            "Was written b", "His writing was", "He wroten the", "Written by",
            "A soprano was popular", "In a popular soprano", "Was a popular soprano", "A popular soprano in",
            "Who she believed", "Who believed", "Believed", "Who did she believe",
            "Yesterday", " In the morning", "Traffict", "Cars"
    };

    //jawaban benar
    String[] jawaban_benar = new String[]{
            "To meet",
            "Written by",
            "a popular soprano in",
            "Who believed",
            "Traffict"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_kuis);

        kuis = (TextView) findViewById(R.id.kuis);
        rg = (RadioGroup) findViewById(R.id.pilihan);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        kuis.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void next(View view) {
        if (PilihanA.isChecked() || PilihanB.isChecked() || PilihanC.isChecked() || PilihanD.isChecked()) {

            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_kuis.length) {
                kuis.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);

            } else {
                hasil = benar * 20;
                Intent selesai = new Intent(getApplicationContext(), HasilKuis.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this,"You must Answer!",Toast.LENGTH_LONG).show();
        }
    }
}
