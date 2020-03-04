package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Database.AppDatabase;
import com.example.myapplication.Database.DataDiri;

public class MainActivity extends AppCompatActivity {
    private AppDatabase appDatabase;
    private Button btnInput;
    private EditText etNama, etAlamat, etJK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.iniDB(getApplicationContext());
        btnInput = findViewById(R.id.btnInput);
        etNama = findViewById(R.id.nama);
        etAlamat = findViewById(R.id.alamat);
        etJK = findViewById(R.id.jk);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertData();
            }


        });

    }
    private void InsertData() {

        //simpan inputan sesuai type data
        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        char jk = etJK.getText().toString().charAt(0);

        //masukkan ke dlm item
        DataDiri item = new DataDiri();
        item.setAlamat(alamat);
        item.setJk(jk);
        item.setNama(nama);

        //panggil fungsi InsertData
        appDatabase.dao().insertData(item);

        //hapus inputan
        etNama.setText("");
        etAlamat.setText("");
        etJK.setText("");
    }
}
