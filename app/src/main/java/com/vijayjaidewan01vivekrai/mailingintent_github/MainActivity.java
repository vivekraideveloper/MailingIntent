package com.vijayjaidewan01vivekrai.mailingintent_github;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2, e3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        e3 = findViewById(R.id.editText3);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String to = e1.getText().toString();
                String sub = e2.getText().toString();
                String msg = e3.getText().toString();
                String toMail[] = {to};
                sendEmail(toMail,sub, msg);
            }
        });
    }

    public void sendEmail(String to[], String subject, String msg){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        intent.setType("message/UTF-8");
        startActivity(Intent.createChooser(intent, "Email"));
    }
}
