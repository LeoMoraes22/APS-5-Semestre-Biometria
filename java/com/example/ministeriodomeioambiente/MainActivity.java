package com.example.ministeriodomeioambiente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btn_novoCadastro;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //realiza a ativação do botão para direcionar para a página do login
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainLogin.class);
                startActivity(i);
                finish();
            }
        });

        //realiza a ativação do botão para direcionar para a página do cadastro
        btn_novoCadastro = findViewById(R.id.btn_novoCadastro);
        btn_novoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainCadastro.class);
                startActivity(i);
                finish();
            }
        });
    }
}