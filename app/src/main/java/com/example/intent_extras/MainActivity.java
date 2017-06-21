package com.example.intent_extras;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button bt_01;
    EditText et_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_01 = (EditText)findViewById(R.id.et_01);

        bt_01 = (Button)findViewById(R.id.bt_01);
        bt_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myMsg = et_01.getText().toString();
                //browseUp(myMsg);
                //sendMail(myMsg);
                sendSMS(myMsg);
            }
        });
    }
    public void browseUp(String myUrl){
        Uri uri = Uri.parse(myUrl);
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        if (it.resolveActivity(getPackageManager()) != null) {
            startActivity(it); }
    }

    public void startMyActivity(){
        //Intent it = new Intent(MainActivity.this, SecondaryActivity.class);
        Intent it = new Intent();
        it.setAction("ACAO_TESTE");
        String myMsg = et_01.getText().toString();
        if (myMsg.length() > 0){
            it.putExtra("addr", myMsg);
            }
        startActivity(it);

    }

    private void sendMail(String Message) {
        if (Message.length()<=0) return;
        String addresses = "luis.trevisan@up.edu.br";
        //Intent intent = new Intent(Intent.ACTION_SEND); //editor de notas, mail, sms, whats app
        Intent intent = new Intent(Intent.ACTION_SENDTO); //apenas e-mail
        intent.setData(Uri.parse("mailto:"+addresses));//apenas e-mail
        //intent.setData(Uri.parse("mailto:"));//apenas e-mail
        // intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Teste e-mail");//assunto
        //corpo do e-mail
        intent.putExtra(Intent.EXTRA_TEXT, Message);
        if (intent.resolveActivity(getPackageManager()) != null) { startActivity(intent); }
    }

    /** * This method sends an SMS with the input message on body */
    private void sendSMS(String Message) {
        if (Message.length()<=0) return;
        //Intent intent = new Intent(Intent.ACTION_SEND);
        //para qualquer tel
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        // para tel especificado
         intent.setType("*/*");
         intent.setData(Uri.parse("smsto:"));
        // This ensures only SMS apps respond
         intent.putExtra("sms_body", Message);
        // intent.putExtra(Intent.EXTRA_STREAM, "");
        // if (intent.resolveActivity(getPackageManager()) != null) {
          startActivity(intent); }




}
