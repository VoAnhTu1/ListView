package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

  private String gioitinh;
  int vitri;

  @Override
    protected void onCreate(Bundle saveInstancetate) {
    super.onCreate(saveInstancetate);
    setContentView(R.layout.activity_main);
    // anh xa
    EditText edTen = findViewById(R.id.edten);
    Spinner spinner = findViewById(R.id.spinner);
    ListView lv = findViewById(R.id.lv);
    Button btnthem, btnXoa, btnSua;
    btnthem = findViewById(R.id.btnthem);
    btnSua = findViewById(R.id.btnSua);
    btnXoa = findViewById(R.id.btnxoa);

    ArrayList<String> ar = new ArrayList<>();
    ar.add("Nam");
    ar.add("Nu");
    ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity2.this, android.R.layout.simple_spinner_item, ar);
    spinner.setAdapter(arrayAdapter);
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
         gioitinh = ar.get(i);
      }

      @Override
      public void onNothingSelected(AdapterView<?> adapterView) {

      }
    });
    ArrayList<ThongTin> dsthongtin=new ArrayList<>();
    dsthongtin.add(new ThongTin("A","Nam") );
    Addapter addapter =new Addapter(dsthongtin );
    lv.setAdapter(addapter);
    btnthem.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        dsthongtin.add(new ThongTin(edTen.getText().toString(),gioitinh));
        addapter.notifyDataSetChanged();
      }
    });
    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        vitri=i;
      }
    });


    btnXoa.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
         dsthongtin.remove(vitri);
         addapter.notifyDataSetChanged();
      }
    });
    btnSua.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        dsthongtin.set(vitri, new ThongTin(edTen.getText().toString(),gioitinh  ) );
        addapter.notifyDataSetChanged();
      }
    });

  }
}