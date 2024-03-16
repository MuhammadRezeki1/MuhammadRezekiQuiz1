package com.example.muhammadrezekiquiz1;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;



public class hasil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);


        klik();


    }
    void klik(){
        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String tipePelanggan = intent.getStringExtra("tipePelanggan");
        String kodebrg = intent.getStringExtra("kodebrg");
        long harga = intent.getLongExtra("harga", 0); // 0 adalah nilai default jika data tidak ditemukan
        int jmlbrg = intent.getIntExtra("jmlbrg", 0); // 0 adalah nilai default jika data tidak ditemukan
        long totalHarga = intent.getLongExtra("totalHarga", 0); // 0 adalah nilai default jika data tidak ditemukan

        // Menampilkan data di TextView atau elemen UI lainnya
        TextView namaTextView = findViewById(R.id.namaTextView);
        namaTextView.setText("Nama: " + nama);

        TextView tipePelangganTextView = findViewById(R.id.tipePelangganTextView);
        tipePelangganTextView.setText("Tipe Pelanggan: " + tipePelanggan);

        TextView kodebrgTextView = findViewById(R.id.kodebrgTextView);
        kodebrgTextView.setText("Kode Barang: " + kodebrg);

        TextView hargaTextView = findViewById(R.id.hargaTextView);
        hargaTextView.setText("Harga: " + "Rp." + harga);

        TextView jmlbrgTextView = findViewById(R.id.jmlbrgTextView);
        jmlbrgTextView.setText("Jumlah Barang: " + jmlbrg);

        TextView totalHargaTextView = findViewById(R.id.totalHargaTextView);
        totalHargaTextView.setText("Total Harga: " + "Rp."+ totalHarga);

        Button share = findViewById(R.id.sharebtn);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sharetxt = "Nama :"+nama  +"\n"+
                "Tipe pelanggan :"+tipePelanggan +"\n"+
                "Kode Barang :"+ kodebrg +"\n"+
                "harga : Rp."+harga +"\n"+
                "Jumlah Barang : "+ jmlbrg +"\n" +
                "Total Harga :"+ totalHarga +"\n"
                ;

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, sharetxt);
                startActivity(Intent.createChooser(shareIntent,"Bagikan Melalui"));
            }
        });
    }


}
