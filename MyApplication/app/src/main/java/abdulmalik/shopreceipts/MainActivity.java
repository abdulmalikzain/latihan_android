package abdulmalik.shopreceipts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printReceipt (View view){
        String [] barang = new String[6];
        ArrayList<Integer> num_barang = new ArrayList<>();

        barang[0] = ((EditText) findViewById(R.id.plasma_num)).getText().toString();
        barang[1] = ((EditText) findViewById(R.id.microwave_num)).getText().toString();
        barang[2] = ((EditText) findViewById(R.id.vacum_num)).getText().toString();
        barang[3] = ((EditText) findViewById(R.id.ac_num)).getText().toString();
        barang[4] = ((EditText) findViewById(R.id.secure_num)).getText().toString();
        barang[5] = ((EditText) findViewById(R.id.dvd_num)).getText().toString();

        num_barang.add(Integer.parseInt(barang[0]));
        num_barang.add(Integer.parseInt(barang[1]));
        num_barang.add(Integer.parseInt(barang[2]));
        num_barang.add(Integer.parseInt(barang[3]));
        num_barang.add(Integer.parseInt(barang[4]));
        num_barang.add(Integer.parseInt(barang[5]));

        Intent intent = new Intent(this, ReceiptActivity.class);
        intent.putExtra("main.barang.num", num_barang);

        startActivity(intent);

    }
}
