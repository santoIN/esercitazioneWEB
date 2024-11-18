import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartitaDaoImpl implements PartitaDao {
    private Connection connection;

    public PartitaDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createPartita(Partita p) {
        String sql = "INSERT INTO partite (casa, ospite, golCasa, golOspite) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, p.getCasa());
            stmt.setString(2, p.getOspite());
            stmt.setInt(3, p.getGolCasa());
            stmt.setInt(4, p.getGolOspite());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Partita getPartitaById(int id) {
        String sql = "SELECT * FROM partite WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Partita(
                        rs.getInt("id"),
                        rs.getString("casa"),
                        rs.getString("ospite")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updatePartita(Partita p) {
        String sql = "UPDATE partite SET casa = ?, ospite = ?, golCasa = ?, golOspite = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, p.getCasa());
            stmt.setString(2, p.getOspite());
            stmt.setInt(3, p.getGolCasa());
            stmt.setInt(4, p.getGolOspite());
            stmt.setInt(5, p.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePartitaById(int id) {
        String sql = "DELETE FROM partite WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Partita> getAllPartita() {
        List<Partita> partite = new ArrayList<>();
        String sql = "SELECT * FROM partite";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Partita partita = new Partita(
                        rs.getInt("id"),
                        rs.getString("casa"),
                        rs.getString("ospite")
                );
                partita.setGolCasa(rs.getInt("golCasa"));
                partita.setGolOspite(rs.getInt("golOspite"));
                partite.add(partita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partite;
    }
}
