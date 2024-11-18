import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalciatoreDaoImpl implements CalciatoreDao {
    private Connection connection;

    public CalciatoreDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createCalciatore(Calciatore calciatore) {
        String sql = "INSERT INTO calciatori (nome, squadra, gol) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, calciatore.getNome());
            stmt.setString(2, calciatore.getSquadra());
            stmt.setInt(3, calciatore.getGol());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Calciatore getCalciatoreById(int id) {
        String sql = "SELECT * FROM calciatori WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Calciatore(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("squadra"),
                        rs.getInt("gol")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Calciatore> getAllCalciatori() {
        List<Calciatore> calciatori = new ArrayList<>();
        String sql = "SELECT * FROM calciatori";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                calciatori.add(new Calciatore(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("squadra"),
                        rs.getInt("gol")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return calciatori;
    }

    @Override
    public void updateCalciatore(Calciatore calciatore) {
        String sql = "UPDATE calciatori SET nome = ?, squadra = ?, gol = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, calciatore.getNome());
            stmt.setString(2, calciatore.getSquadra());
            stmt.setInt(3, calciatore.getGol());
            stmt.setInt(4, calciatore.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCalciatore(int id) {
        String sql = "DELETE FROM calciatori WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


