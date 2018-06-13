package com.example.ricar.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Variables
    int i =0;
    String wc;
    int prc =5;
    String cl;

    //Code for the up button to update the counter up
    public void up(View v){
        TextView txtC = (TextView)findViewById(R.id.txtC);
        i++;
        if (i>0){
        txtC.setText(Integer.toString(i));
        }else if (i<0){
                i=1;
                txtC.setText(Integer.toString(i));
        }
    }

    //Code for the down button to update the counter down
    public void down(View v){
        TextView txtC = (TextView)findViewById(R.id.txtC);
        i--;
        if (i>0){
        txtC.setText(Integer.toString(i));
        }else{
            i=0;
            txtC.setText(Integer.toString(i));
        }
    }

    //All text except for counter setting and getting here
    public void print(View v){
        CheckBox ck = (CheckBox)findViewById(R.id.ck);
        CheckBox ckc = (CheckBox)findViewById(R.id.ckC);
        EditText et1 = (EditText)findViewById(R.id.et1);
        if (ck.isChecked()){
            wc = getResources().getString(R.string.confirm);
            prc = prc + 1;
        }else{
            wc = getResources().getString(R.string.negate);
        }
        if (ckc.isChecked()){
            cl = getResources().getString(R.string.confirm);
            prc = prc + 1;
        }else {
            cl = getResources().getString(R.string.negate);
        }
        String txt = getString(R.string.n);
        String name = (txt + " " + et1.getText().toString() + "\n");
        String Whipped_cream = (getString(R.string.cream) + " ?: " + wc + "\n");
        String Chocolate = (getString(R.string.chocolate) + " ?: " + cl + "\n");
        String Quantity = (getString(R.string.q) + ": " + i + "\n");
        String Total = (getString(R.string.tot) + " " + getString (R.string.qrc) + (i * prc) + "\n");
        String Thanks = (getString(R.string.tu));
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("message/rfc822");
        String Subject = (getString(R.string.app_name) + " " + getString(R.string.subj) + " " + et1.getText().toString());
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT,Subject );
        intent.putExtra(Intent.EXTRA_TEXT, (name + Whipped_cream + Chocolate + Quantity + Total + Thanks));
        if (intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }
    }
}
