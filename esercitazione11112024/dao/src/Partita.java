public class Partita {
    private int id;
    private String casa;
    private String ospite;
    private int golCasa;
    private int golOspite;

    public Partita(int id, String casa, String ospite) {
        this.id = id;
        this.casa = casa;
        this.ospite = ospite;
        this.golCasa = 0;
        this.golOspite = 0;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getCasa() {return casa;}
    public void setCasa(String casa) {this.casa = casa;}
    public String getOspite() {return ospite;}
    public void setOspite(String ospite) {this.ospite = ospite;}
    public int getGolCasa() {return golCasa;}
    public void setGolCasa(int golCasa) {this.golCasa = golCasa;}
    public int getGolOspite() {return golOspite;}
    public void setGolOspite(int golOspite) {this.golOspite = golOspite;}
}
