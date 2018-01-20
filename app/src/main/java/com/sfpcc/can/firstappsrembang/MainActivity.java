package com.sfpcc.can.firstappsrembang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String STATE_HASIL = "state_hasil";
    private EditText edtPanjang, edtLebar, edtTinggi;
    private Button btnHasil;
    private TextView tvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPanjang = (EditText) findViewById(R.id.edt_panjang);
        edtLebar = (EditText) findViewById(R.id.edt_lebar);
        edtTinggi =(EditText) findViewById(R.id.edt_tinggi);
        btnHasil = (Button) findViewById(R.id.btn_hitung);
        tvHasil = (TextView) findViewById(R.id.tv_hasil);
        btnHasil.setOnClickListener(this);

        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvHasil.setText(hasil);
        }
    }
    public void onClick(View v){
        if (v.getId()==R.id.btn_hitung){
            String panjang = edtPanjang.getText().toString().trim();
            String lebar = edtLebar.getText().toString().trim();
            String tinggi = edtTinggi.getText().toString().trim();

            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(panjang)){
                isEmptyFields = true;
                edtPanjang.setError("jangan dikosongi woy");
            }
            if (TextUtils.isEmpty(lebar)){
                isEmptyFields = true;
                edtLebar.setError("Masih kosong coy");
            }
            if (TextUtils.isEmpty(tinggi)){
                isEmptyFields = true;
                edtTinggi.setError("Isi dulu ");
            }
            if(!isEmptyFields){
                double p = Double.parseDouble(panjang);
                double l = Double.parseDouble(lebar);
                double t = Double.parseDouble(tinggi);

                double volume = p*l*t;
                tvHasil.setText((String.valueOf(volume)));
            }
        }
    }

    protected void onSaveInstancesState(Bundle outstate){
        outstate.putString(STATE_HASIL, tvHasil.getText().toString());
        super.onSaveInstanceState(outstate);
    }

}
