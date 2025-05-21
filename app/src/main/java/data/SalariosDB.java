package data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "salario")
public class SalariosDB {

    @PrimaryKey(autoGenerate = true)
    private  int id;
    private String nomeSalario,dataSalario,checkboxSalario;
    private double salario;

    public SalariosDB(){

    }
    public SalariosDB(String nome,String data, String checkbox, Double salario){
        this.nomeSalario = nome;
        this.dataSalario = data;
        this.salario = salario;
        this.checkboxSalario = checkbox;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeSalario() {
        return nomeSalario;
    }

    public void setNomeSalario(String nomeSalario) {
        this.nomeSalario = nomeSalario;
    }

    public String getDataSalario() {
        return dataSalario;
    }

    public void setDataSalario(String dataSalario) {
        this.dataSalario = dataSalario;
    }

    public String getCheckboxSalario() {
        return checkboxSalario;
    }

    public void setCheckboxSalario(String checkboxSalario) {
        this.checkboxSalario = checkboxSalario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
