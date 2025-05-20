package data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// 1. Indica que essa classe é o banco de dados do Room
//    entities = as tabelas que o banco terá (aqui só GastosDB)
//    version = versão do banco, começa em 1 e deve ser atualizada se alterar o esquema
@Database(entities = {GastosDB.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    // 2. Aqui declaramos o DAO que o banco vai expor para acessar a tabela GastosDB
    public abstract GastosDao gastosDao();

    // 3. Singleton - manter só uma instância do banco para evitar problemas e otimizar recursos
    private static volatile AppDatabase INSTANCE;

    // 4. Método para pegar a instância do banco, criar se ainda não existir
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {  // trava para evitar criar duas vezes em threads diferentes
                if (INSTANCE == null) {
                    // Aqui é onde realmente criamos o banco, passando o contexto e o nome do arquivo do banco
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "gastos_database")
                            .fallbackToDestructiveMigration() // Permite limpar e recriar banco se versão mudar (não recomendado para produção sem migração)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
