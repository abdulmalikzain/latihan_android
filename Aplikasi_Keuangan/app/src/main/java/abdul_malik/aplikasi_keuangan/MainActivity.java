package abdul_malik.aplikasi_keuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String strShow = "";
    TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onResume() {
        super.onResume();
        txtShow = (TextView) findViewById(R.id.txt_show);

        ListView listTransaksi = (ListView) findViewById(R.id.list_transaksi);
        TransaksiHelper dbHelper = new TransaksiHelper(this);
        final List<Transaksi> ListTrans = dbHelper.getTransaksi();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListTrans);
        listTransaksi.setAdapter(adapter);

        int saldo = 0;
        for(int i=0; i<ListTrans.size(); i++){
            if(ListTrans.get(i).jenis==1){
                saldo +=ListTrans.get(i).jumlah;
            }else {
                saldo -=ListTrans.get(i).jumlah;
            }
        }

        TextView txtSaldo = (TextView) findViewById(R.id.txt_saldo);
        txtSaldo.setText("Saldo Tersisa: "+Integer.toString(saldo));

        listTransaksi.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Transaksi transaksi = ListTrans.get(position);
                Intent intent = new Intent(parent.getContext(), DetailActivity.class);
                intent.putExtra("transaksi.detail", transaksi);
                startActivity(intent);
            }
        });
    }

    public void addTransaksi(View view){
        Intent intent = new Intent (this, FormTransaksi.class);
        startActivity(intent);
    }
}
