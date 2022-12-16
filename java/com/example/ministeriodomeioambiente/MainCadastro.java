package com.example.ministeriodomeioambiente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.HashMap;
import java.util.Map;

public class MainCadastro extends AppCompatActivity {

    private EditText editNome, editEmail, editSenha, editNivel;
    private Button btn_cadastrar, btn_voltar;
    private FirebaseAuth mAuth;
    String usuarioID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cadastro);

        //Realiza a ativação do botão para voltar para a página inicial
        btn_voltar = findViewById(R.id.btn_voltar);
        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainCadastro.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });


/*
        //Realiza o cadastro do usuario
        btn_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = editNome.getText().toString();
                String email = editEmail.getText().toString();
                String senha = editSenha.getText().toString();
                String nivel = editNivel.getText().toString();

                if (!nome.isEmpty() || !email.isEmpty() || !senha.isEmpty() || !nivel.isEmpty()){

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                FirebaseFirestore db = FirebaseFirestore.getInstance();

                                Map<String, Object> usuarios = new HashMap<>();
                                usuarios.put("nome", nome);
                                usuarios.put("nivel", nivel);
                                usuarios.put("email", email);
                                usuarios.put("senha", senha);

                                usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                DocumentReference documentReference = db.collection("usuarios").document(usuarioID);
                                documentReference.set(usuarios).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                    }
                                });
                            }


                        }
                    });
                }

                Intent i = new Intent(MainCadastro.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

 */
    }

}