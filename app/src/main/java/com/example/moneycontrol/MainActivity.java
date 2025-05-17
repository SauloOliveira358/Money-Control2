package com.example.moneycontrol;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button adicionar_Gasto, adicionar_Salario;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adicionar_Gasto = findViewById(R.id.IdBtnAdicionarGastoMain);
        adicionar_Salario = findViewById(R.id.IdBtnAdicionarSalarioMain);
        //Botao Mudar a tela Gasto
        adicionar_Gasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdicionarGastos.class);
                startActivity(intent);
            }
        });

        //botao mudar a tela salario
        adicionar_Salario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdicionarSalario.class);
                startActivity(intent);
            }
        });
    }
}