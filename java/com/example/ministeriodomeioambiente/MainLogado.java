package com.example.ministeriodomeioambiente;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MainLogado extends AppCompatActivity {

    private TextView nomeUsuario, nivelUsuario;
    private Button btn_logout, btn_primeiro_nivel,btn_segundo_nivel,btn_terceiro_nivel;
    private FirebaseAuth mAuth;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String usuarioID;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_logado);

        //Realiza o logout na seção e volta para a página principal
        mAuth = FirebaseAuth.getInstance();
        btn_logout = findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();

                Intent i = new Intent(MainLogado.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        nomeUsuario = findViewById(R.id.txvNome);
        nivelUsuario = findViewById(R.id.txvNivel);

        btn_primeiro_nivel = findViewById(R.id.btn_primeiro_nivel);
        btn_segundo_nivel = findViewById(R.id.btn_segundo_nivel);
        btn_terceiro_nivel = findViewById(R.id.btn_terceiro_nivel);

        btn_primeiro_nivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainLogado.this, MainPrimeiro.class);
                startActivity(i);
                finish();
            }
        });

        btn_segundo_nivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainLogado.this, MainSegundo.class);
                startActivity(i);
                finish();
            }
        });

        btn_terceiro_nivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainLogado.this, MainTerceiro.class);
                startActivity(i);
                finish();
            }
        });


    }
/*
    @Override
    protected void onStart() {
        super.onStart();

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        usuarioID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference documentReference = db.collection("usuarios").document(usuarioID);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {

                if(documentSnapshot != null){
                    nomeUsuario.setText(documentSnapshot.getString("nome"));
                    nivelUsuario.setText(email);
                }
            }
        });


    }

 */
}