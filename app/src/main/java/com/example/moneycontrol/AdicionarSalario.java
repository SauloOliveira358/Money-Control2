package com.example.moneycontrol;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

public class AdicionarSalario extends AppCompatActivity {
private EditText data_Renda,Valor_Renda,nome;
private CheckBox salario_Fixo,renda_Extra,salario_variavel;
private Button salvar_Salario, fechar_Salario;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_salario);
        //EditText variaveis
        nome = findViewById(R.id.IdEditTxtNomeRenda);
        Valor_Renda = findViewById(R.id.IdEditTxtValorSalario);
        data_Renda = findViewById(R.id.IdEditTxtDateRenda);
        //CheckBox
        salario_Fixo = findViewById(R.id.IdCheckBoxSalarioFixo);
        renda_Extra = findViewById(R.id.IdCheckBoxRendaExtra);
        salario_variavel = findViewById(R.id.IdCheckBoxSalarioVariavel);
        //Botão variaveis
        salvar_Salario = findViewById(R.id.IdBtnAdicionarSalarioMain);
        fechar_Salario = findViewById(R.id.IdBtnFechardcionarRenda);

                    //Botao Fechar janela do Adcionar Salario a tela
        fechar_Salario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
                //CheckBox clicar somente em um
        View.OnClickListener escutar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox clicou = (CheckBox) view;
                salario_Fixo.setChecked(false);
                renda_Extra.setChecked(false);
                salario_variavel.setChecked(false);

                clicou.setChecked(true);
            }
        };
        //cada checkbox ir para o metodo escutar
        salario_Fixo.setOnClickListener(escutar);
        renda_Extra.setOnClickListener(escutar);
        salario_variavel.setOnClickListener(escutar);

    }
}