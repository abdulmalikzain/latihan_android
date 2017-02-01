package com.example.d2j_00.javaclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String showString;
    public TextView showText;
    public Barang [] arrBarang = new Barang[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showText = (TextView) findViewById(R.id.show_text);

        showString = "Manipulasi class java android";
        addSeparate();

        initBarang();
//        showString+= arrBarang[5].toString();
//        addSeparate();
//        showString += arrBarang[1].toString();

        Transaksi trans1 = new Transaksi();
        trans1.addBarang(arrBarang[3]);
        trans1.addBarang(arrBarang[7]);
        trans1.addBarang(arrBarang[9]);
        showString +=trans1.printTransaksi();
        showString +="rata - rata harga barang yang dibeli: "+trans1.averageTransaksi();
        showString +=trans1.maxBarang();
        showText.setText(showString);

    }

     public void addSeparate(){
         showString+= "\n-----------------------\n";
     }

    public void initBarang(){
        arrBarang[0]= new Barang("laptop", 1, 7000000);
        arrBarang[1]= new Barang("laptop", Barang.ELEKTRONIK, 2500000);
        arrBarang[2]= new Barang("Monitor", Barang.ELEKTRONIK, 1500000);
        arrBarang[3]= new Barang("Scanner", Barang.ELEKTRONIK, 1000000);
        arrBarang[4]= new Barang("Meja", Barang.Non_ELECTRONIK, 700000);
        arrBarang[5]= new Barang("Mouse", Barang.ELEKTRONIK, 200000);
        arrBarang[6]= new Barang("Kursi", Barang.Non_ELECTRONIK, 2000000);
        arrBarang[7]= new Barang("RAM", Barang.ELEKTRONIK, 1000000);
        arrBarang[8]= new Barang("Almari", Barang.Non_ELECTRONIK, 10000000);
        arrBarang[9]= new Barang("Pintu", Barang.Non_ELECTRONIK, 15000000);
    }
}
