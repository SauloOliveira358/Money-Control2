package com.example.moneycontrol;

import android.annotation.SuppressLint;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import data.AppDatabase;
import data.GastosDB;
import data.GastosDao;

public class MainActivity extends AppCompatActivity {
private Button adicionar_Gasto, adicionar_Salario;
private TextView texto_Resultado;
    private AppDatabase db;
    private GastosDao gastosDao;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        texto_Resultado = findViewById(R.id.IdeditTextResultado);
        adicionar_Gasto = findViewById(R.id.IdBtnAdicionarGastoMain);
        adicionar_Salario = findViewById(R.id.IdBtnAdicionarSalarioMain);


        //Databas Room
        db = AppDatabase.getInstance(this);
        gastosDao = db.gastosDao();
        //buscar dados e mostrar
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<GastosDB> list = gastosDao.listarTodosGastos();

                StringBuilder texto = new StringBuilder();
for(GastosDB gasto : list){
    texto.append("Nome: ").append(gasto.getNome()).append(", Valor: ").append(gasto.getValor_Gasto())
            .append(", Data: ").append(gasto.getData())
            .append(", Categoria: ").append(gasto.getCheckbox())
            .append("\n");
}
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        texto_Resultado.setText(texto.toString());
                    }
                });
            }
        }).start();

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
                //teste pra limpar o banco quando clicar em adicionar salario
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        gastosDao.limparTodos();
                    }
                }).start();
                //final teste banco limpar
            }
        });


    }
    @Override
    protected void onResume(){
        super.onResume();
        carregarDados();
    }
    public void carregarDados(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<GastosDB> list = gastosDao.listarTodosGastos();

                StringBuilder texto = new StringBuilder();
                for(GastosDB gasto : list){
                    texto.append("Nome: ").append(gasto.getNome()).append(", Valor: ").append(gasto.getValor_Gasto())
                            .append(", Data: ").append(gasto.getData())
                            .append(", Categoria: ").append(gasto.getCheckbox())
                            .append("\n");
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        texto_Resultado.setText(texto.toString());
                    }
                });
            }
        }).start();

    }

}