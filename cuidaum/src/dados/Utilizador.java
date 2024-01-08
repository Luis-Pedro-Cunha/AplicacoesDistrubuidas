package dados;

import java.io.Serializable;
import java.time.LocalDate;
public class Utilizador implements Serializable {

    private static final long serialVersionUID = -2974165046967501366L;
    private String nome;
    private String nif;
    private String cc;
    private LocalDate datanasc;

    public Utilizador() {
        this.nome = "";
        this.nif = "";
        this.cc = "";
    }

    public Utilizador(String nome, String nif, String cc, LocalDate datanasc) {
        this.nome = nome;
        this.nif = nif;
        this.cc = cc;
        this.datanasc = datanasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public LocalDate getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(LocalDate datanasc) {
        this.datanasc = datanasc;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | " +
                "Nif: " + nif + " | " +
                "CC: " + cc + " | " +
                "Data de nascimento: " + datanasc;
    }
}
