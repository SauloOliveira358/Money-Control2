package data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "gastos")
public class GastosDB {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome;
    private String data;
    private Double valor_Gasto;
    private String checkbox;

    // Construtor vazio (obrigatório pro Room)
    public GastosDB() {}

    // Construtor com parâmetros (opcional, mas útil)
    public GastosDB(String nome, String data, Double valor_Gasto, String checkbox) {
        this.nome = nome;
        this.data = data;
        this.valor_Gasto = valor_Gasto;
        this.checkbox = checkbox;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getValor_Gasto() {
        return valor_Gasto;
    }

    public void setValor_Gasto(Double valor_Gasto) {
        this.valor_Gasto = valor_Gasto;
    }

    public String getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(String checkbox) {
        this.checkbox = checkbox;
    }
}
