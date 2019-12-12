package com.example.appturismo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistroActivity extends AppCompatActivity {

    private EditText edTName;
    private EditText edTPwd;
    private EditText edTMail;
    private Button btnRegistro;

    private String nombre = "";
    private String correo = "";
    private String password = "";

    FirebaseAuth fAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        fAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        edTName = (EditText) findViewById(R.id.edTName);
        edTMail = (EditText) findViewById(R.id.edTMail);
        edTPwd = (EditText) findViewById(R.id.edTPwd);
        btnRegistro = (Button) findViewById(R.id.btnRegistro);

        Button btnIniciar = (Button) findViewById(R.id.btnIniciarS);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                nombre = edTName.getText().toString();
                correo = edTMail.getText().toString();
                password = edTName.getText().toString();

                if(!nombre.isEmpty() && !correo.isEmpty() && !password.isEmpty()){
                    if(password.length() >= 6){
                        registerUser();
                    }else{
                        Toast.makeText(RegistroActivity.this, "La contraseña debe tener al menos 6 caracteres",Toast.LENGTH_SHORT).show();
                    }
                    registerUser();
                }else{
                    Toast.makeText(RegistroActivity.this, "Llene todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registerUser(){
        fAuth.createUserWithEmailAndPassword(correo, password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String, Object> map = new HashMap<>();
                    map.put("nombre", nombre);
                    map.put("correo", correo);
                    map.put("password", password);

                    String id = fAuth.getCurrentUser().getUid();

                    mDatabase.child("users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){
                                startActivity(new Intent(RegistroActivity.this ,PlacesActivity.class));
                                finish();
                            }else{
                                Toast.makeText(RegistroActivity.this, "No se pudieron crear los datos correctamente",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(RegistroActivity.this, "No se pudo registrar este usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static class Slide {

        private int image;
        private String Title;

        public Slide(int image, String title){
            image = image;
            Title = title;
        }

        public int getImage(){
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getTitle(){
            return Title;
        }
    }
}
