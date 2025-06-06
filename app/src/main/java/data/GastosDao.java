package data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GastosDao {
    @Query("DELETE FROM gastos")
    void limparTodos();
    @Insert
    void inserirGasto(GastosDB gasto);

    @Query("SELECT * FROM gastos")
    List<GastosDB> listarTodosGastos();

}
