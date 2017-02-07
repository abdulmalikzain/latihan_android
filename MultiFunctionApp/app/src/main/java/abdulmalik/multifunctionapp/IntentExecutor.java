package abdulmalik.multifunctionapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class IntentExecutor extends AppCompatActivity {
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_executor);
    }
    public void execute(View view){
        Intent exeIntent = null;
        EditText txtExec = (EditText) findViewById(R.id.text_exec);
        String exec = txtExec.getText().toString();

        if (operator.equals("Browser")){
            Uri webpage = Uri.parse("http://"+exec);
            exeIntent = new Intent(Intent.ACTION_VIEW, webpage);
        }else if(operator.equals("phone")){
            Uri number = Uri.parse("tel:"+exec);
            exeIntent = new Intent(exeIntent.ACTION_DIAL, number);
        }else if(operator.equals("map")){
            //script membuka peta
            Uri gmmIntentUri =Uri.parse("geo:"+exec);
            exeIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        }
        startActivity(exeIntent);
    }
}
