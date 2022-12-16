package com.example.ministeriodomeioambiente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

public class MainLogin extends AppCompatActivity {

    private EditText editEmailLogin, editSenhaNumerico;
    private Button btn_logando, btn_voltar, btn_login_biometria;
    private Executor executor;
    private BiometricPrompt biometria;
    private BiometricPrompt.PromptInfo biometria_info;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        //Realiza a ativação do botão para voltar para a página inicial
        btn_voltar = findViewById(R.id.btn_voltar);
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainLogin.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });


        editEmailLogin = findViewById(R.id.editEmailLogin);
        editSenhaNumerico = findViewById(R.id.editSenhaNumerico);
        btn_logando = findViewById(R.id.btn_logando);

        btn_logando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainLogin.this, MainLogado.class);
                startActivity(i);
                finish();
            }
        });
/*
        btn_logando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = editEmailLogin.getText().toString();
                String senha = editSenhaNumerico.getText().toString();

                if (!email.isEmpty() || !senha.isEmpty()){
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                abrirTelaprincipal();
                            }else{
                                String erro;
                                try {
                                    throw task.getException();
                                }catch (Exception e){
                                    erro = "Erro ao logar usuário";
                                }
                                Snackbar snackbar = Snackbar.make(view, erro, Snackbar.LENGTH_SHORT);
                                snackbar.setBackgroundTint(Color.WHITE);
                                snackbar.setTextColor(Color.BLACK);
                                snackbar.show();
                            }
                        }
                    });
                }
            }
        });


 */
        // Login com a Biometria
        btn_login_biometria = findViewById(R.id.btn_login_biometria);

        executor = ContextCompat.getMainExecutor(this);
        biometria = new BiometricPrompt(MainLogin.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Intent i = new Intent(MainLogin.this, MainLogado.class);
                startActivity(i);
                finish();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });


        biometria_info = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Autenticação Biométrica")
                .setSubtitle("Posicione seu dedo no leitor biométrico para acessar o sistema.")
                .setNegativeButtonText("Cancelar")
                .build();

        btn_login_biometria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                biometria.authenticate(biometria_info);
            }
        });
    }


    private void abrirTelaprincipal() {
        Intent i = new Intent(MainLogin.this, MainLogado.class);

        startActivity(i);
        finish();
    }
}