package com.example.rusha.wsdc1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Activity activity = this;
                IntentIntegrator intent = new IntentIntegrator(activity);
                intent.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                intent.setPrompt("Scan");
                intent.setCameraId(0);
                intent.setBeepEnabled(false);
                intent.setBarcodeImageEnabled(false);
                intent.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result!=null&&result.getContents()!=null)
        {
            //Toast.makeText(this,result.getContents(),Toast.LENGTH_SHORT).show();
            TextView text=(TextView)findViewById(R.id.text);
            text.setText(result.getContents());
            String json=Utils.toJson();
            TextView t=(TextView)findViewById(R.id.text6);
            t.setText(json);
        }
        else
        super.onActivityResult(requestCode, resultCode, data);
    }
}