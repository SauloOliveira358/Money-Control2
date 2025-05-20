package data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SalarioDao {
    @Query("DELETE FROM salario")
    void limparTodosSalarios();
    @Insert
    void inserirSalario(GastosDB salario);

    @Query("SELECT * FROM salario")
    List<GastosDB> listarTodosSalario();
}
