package com.example.mailgnderme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText icerik;
    EditText konu;
    EditText mailAdres;
    Button button;
    String icerikText, konuText,mailAdresText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        mailUygulamalariniGorveGonder();
    }
    public  void tanimla()
    {
        icerik=(EditText)findViewById(R.id.editTextmailIcerik);
        konu=(EditText)findViewById(R.id.editTextMailKonu);
        mailAdres=(EditText)findViewById(R.id.editTextMailAdress);
        button=(Button)findViewById(R.id.mailAt);
    }
    public  void bilgiAl()
    {
        icerikText=icerik.getText().toString();
        konuText=konu.getText().toString();
        mailAdresText=mailAdres.getText().toString();

    }
    public  void mailUygulamalariniGorveGonder()
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bilgiAl();
                try {
                    Intent ıntent=new Intent(Intent.ACTION_SEND);
                   // ıntent.setType("message/rfc822");
                    ıntent.putExtra(Intent.EXTRA_EMAIL,mailAdresText);
                    ıntent.putExtra(Intent.EXTRA_SUBJECT,konuText);
                    ıntent.putExtra(Intent.EXTRA_TEXT,icerikText);
                    Log.i("kader","kader");
                    startActivity(Intent.createChooser(ıntent,"Mail Gönderiniz!..."));
                }
                catch (Exception e)
                {
                    System.out.print(""+e);
                }




            }
        });

    }
}