import java.util.List;

public interface PartitaDao {
    void createPartita(Partita p);
    Partita getPartitaById(int id);
    void updatePartita(Partita p);
    void deletePartitaById(int id);
    List<Partita> getAllPartita();
}
