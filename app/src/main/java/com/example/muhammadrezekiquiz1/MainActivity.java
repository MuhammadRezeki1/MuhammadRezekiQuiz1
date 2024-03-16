package com.example.muhammadrezekiquiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText namaEditText, kodeBarangEditText, jumlahBarangEditText;
    RadioGroup radioGroup;
    Button processButton;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namaEditText = findViewById(R.id.nama);
        kodeBarangEditText = findViewById(R.id.kodebrg);
        jumlahBarangEditText = findViewById(R.id.jmlbrg);
        radioGroup = findViewById(R.id.radioGroup);
        processButton = findViewById(R.id.process);

        klik();
    }
    void klik() {
        processButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String nama = namaEditText.getText().toString();
                String kodebrg = kodeBarangEditText.getText().toString();
                int jmlbrg = Integer.parseInt(jumlahBarangEditText.getText().toString());
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                String tipePelanggan = " ";

                if(namaEditText.getText().toString().isEmpty() || kodeBarangEditText.getText().toString().isEmpty() || jumlahBarangEditText.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Mohon Isi Semua Data", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (selectedRadioButtonId == -1) {
                    // Jika tidak ada radio button yang dipilih
                    Toast.makeText(MainActivity.this, "Pilih salah satu member", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Mendapatkan radio button yang dipilih
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

                // Mendapatkan tipe pelanggan berdasarkan radio button yang dipilih
                tipePelanggan = selectedRadioButton.getText().toString();

                // Mendapatkan harga barang berdasarkan kode barang
                long harga = 0;
                switch (kodebrg) {
                    case "SGS":
                        harga = 12999999;
                        break;
                    case "OAS":
                        harga = 1989123;
                        break;
                    case "PCO":
                        harga = 2730551;
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Kode barang tidak valid", Toast.LENGTH_SHORT).show();
                        return;
                }

                // Menghitung total harga
                long totalHarga = harga * jmlbrg;

                //menghitung diskon
                double diskon = 0;

                switch(tipePelanggan){
                    case "Gold":
                        diskon   = (10.0 / 100) * totalHarga;
                        break;
                    case "Silver":
                        diskon = (5.0 / 100) * totalHarga;
                        break;
                    case "Biasa":
                        diskon = (2.0 / 100 ) * totalHarga;
                        break;
                }

                totalHarga -=  diskon;
                // Menambahkan diskon jika total harga melebihi 10 juta
                if (totalHarga > 10000000) {
                    totalHarga += 100000;
                }if (totalHarga < 0) {
                    totalHarga = 0;
                }

                Intent intent = new Intent(MainActivity.this, hasil.class);

                intent.putExtra("nama", nama);
                intent.putExtra("tipePelanggan", tipePelanggan);
                intent.putExtra("kodebrg", kodebrg);
                intent.putExtra("harga", harga);
                intent.putExtra("jmlbrg", jmlbrg);
                intent.putExtra("totalHarga", totalHarga);

                startActivity(intent);
            }


        });
    }
}

