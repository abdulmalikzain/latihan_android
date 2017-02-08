package abdulmalik.shopreceipts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ReceiptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        Intent intent = getIntent();

        ArrayList<Integer> num_barang = new ArrayList<>();
        num_barang = (ArrayList<Integer>) intent.getSerializableExtra("main.barang.num");

        int [] harga_barang = new int[6];
        harga_barang [0] = 3000000;
        harga_barang [1] = 1500000;
        harga_barang [2] = 1000000;
        harga_barang [3] = 3500000;
        harga_barang [4] = 500000;
        harga_barang [5] = 500000;

        int [] id_num = {R.id.plasma2_num, R.id.microwave2_num, R.id.vacum2_num, R.id.ac2_num, R.id.secure2_num, R.id.dvd2_num};
        int [] id_total = {R.id.plasma2_total, R.id.microwave2_total, R.id.vacum2_total, R.id.ac2_total, R.id.secure2_total, R.id.dvd2_total};

        int total = 0;
        for (int i = 0; i<6; i++){
            total +=harga_barang[i] *num_barang.get(i);
            ((TextView) findViewById(id_num[i])).setText(Integer.toString(num_barang.get(i)));
            ((TextView) findViewById(id_total[i])).setText(Integer.toString(num_barang.get(i) *harga_barang[i]));
        }
        ((TextView) findViewById(R.id.grand_total)).setText(Integer.toString(total));
    }
}
