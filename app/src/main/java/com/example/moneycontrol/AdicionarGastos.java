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

import data.AppDatabase;
import data.GastosDB;
import data.GastosDao;

public class AdicionarGastos extends AppCompatActivity {
    private EditText nome_Gasto, valor_gasto, data_gasto;
    private CheckBox lazer, streming, exencial, alimentacao, fixo_gasto;
    private Button salvar_Gasto, fechar_Gasto;
    private String checkBoxTexto,valorstr;
    private double valor_gastoDouble;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("antes");
        System.out.println("depois");
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

        AppDatabase db = AppDatabase.getInstance(this);
        GastosDao dao = db.gastosDao();


        salvar_Gasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valorstr = valor_gasto.getText().toString().replace(",",".");
                valor_gastoDouble = Double.parseDouble(valorstr);
                GastosDB banco = new GastosDB(nome_Gasto.getText().toString(),data_gasto.getText().toString(),valor_gastoDouble,checkBoxTexto);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        dao.inserirGasto(banco);
                    }
                }).start();
                finish();
            }
        });
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
                checkBoxTexto = clicou.getText().toString();
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

