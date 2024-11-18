import java.util.List;

public interface CalciatoreDao {
    void createCalciatore(Calciatore calciatore);
    Calciatore getCalciatoreById(int id);
    List<Calciatore> getAllCalciatori();
    void updateCalciatore(Calciatore calciatore);
    void deleteCalciatore(int id);
}
