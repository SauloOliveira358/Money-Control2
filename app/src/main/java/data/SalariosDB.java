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

    public String getNome() {
        return nomeSalario;
    }

    public void setNome(String nome) {
        this.nomeSalario = nome;
    }

    public String getData() {
        return dataSalario;
    }

    public void setData(String data) {
        this.dataSalario = data;
    }

    public String getCheckbox() {
        return checkboxSalario;
    }

    public void setCheckbox(String checkbox) {
        this.checkboxSalario = checkbox;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
