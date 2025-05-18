package com.example.moneycontrol;

import android.content.Context;

import com.google.firebase.firestore.FirebaseFirestore;

public class GastosDB {
    private String nome,data;
    private Double valor_Gasto;
    private String checkbox;


    public GastosDB(String nome, String data, Double valor_Gasto, String checkbox){
        this.nome= nome;
        this.data= data;
        this.valor_Gasto = valor_Gasto;
        this.checkbox = checkbox;


    }

    public void salvarNoFirebase(Context context){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
    }





    public Double getValor_Gasto() {
        return valor_Gasto;
    }

    public String getCheckbox() {
        return checkbox;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public void setCheckbox(String checkbox) {
        this.checkbox = checkbox;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor_Gasto(Double valor_Gasto) {
        this.valor_Gasto = valor_Gasto;
    }

}
