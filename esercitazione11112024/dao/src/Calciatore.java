public class Calciatore {
    private int id;
    private String nome;
    private String squadra;
    private int gol;


    public Calciatore(int id, String nome, String squadra, int gol) {
        this.id = id;
        this.nome = nome;
        this.squadra = squadra;
        this.gol = gol;
    }

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

    public String getSquadra() {
        return squadra;
    }

    public void setSquadra(String squadra) {
        this.squadra = squadra;
    }

    public int getGol() {
        return gol;
    }

    public void setGol(int gol) {
        this.gol = gol;
    }
}
