CREATE TABLE trofeo
(
    nome        VARCHAR(100) PRIMARY KEY,
    descrizione VARCHAR(250)
);

CREATE TABLE giocatore
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    nome         VARCHAR(100),
    data_nascita DATE
);

CREATE TABLE giocatore_trofeo
(
    giocatore_id INT,
    trofeo_nome  VARCHAR(100),
    PRIMARY KEY (giocatore_id, trofeo_nome),
    FOREIGN KEY (giocatore_id) REFERENCES giocatore(id) ON DELETE CASCADE,
    FOREIGN KEY (trofeo_nome) REFERENCES trofeo(nome) ON DELETE CASCADE
);
