package com.example.moneycontrol;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class AdicionarGastos extends AppCompatActivity {
    private EditText nome_Gasto, valor_gasto, data_gasto;
    private CheckBox lazer, streming, exencial, alimentacao, fixo_gasto;
    private Button salvar_Gasto, fechar_Gasto;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_adicionar_gastos);
        //editText
        nome_Gasto = findViewById(R.id.IdEditTextNomeGasto);
        valor_gasto = findViewById(R.id.IdEditTextValorGasto);
        data_gasto = findViewById(R.id.IdEditTextDate);

        //CheckBox
        lazer = findViewById(R.id.IdCheckBoxLazer);
        streming = findViewById(R.id.IdCheckBoxStreming);
        exencial = findViewById(R.id.IdCheckBoxExcencial);
        alimentacao = findViewById(R.id.IdCheckBoxAlimentação);
        fixo_gasto = findViewById(R.id.IdCheckBoxfixo);
        //Botao
        salvar_Gasto = findViewById(R.id.IdBtnSalvar);
        fechar_Gasto = findViewById(R.id.IdBtnVoltarAdicionarGasto);

        //Fazer o botao X voltar pro main
        fechar_Gasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });



        //Confirmar apenas um checkbox
        View.OnClickListener escuta = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox clicou = (CheckBox) view;  //o view e que pega do parametro que clicou entao ja vai no certo

                lazer.setChecked(false);
                streming.setChecked(false);
                exencial.setChecked(false);
                alimentacao.setChecked(false);
                fixo_gasto.setChecked(false);

                clicou.setChecked(true);

            }


        };

        //fazer cada um escutar o click pra entrar no metodo pra dar false nos click la
        lazer.setOnClickListener(escuta);
        streming.setOnClickListener(escuta);
        exencial.setOnClickListener(escuta);
        alimentacao.setOnClickListener(escuta);
        fixo_gasto.setOnClickListener(escuta);
    }
}

