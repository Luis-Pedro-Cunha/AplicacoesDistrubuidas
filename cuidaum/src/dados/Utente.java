package dados;

import java.io.Serializable;
import java.time.LocalDate;
public class Utente extends Utilizador implements Serializable{

    private static final long serialVersionUID = -8832014226231788388L;

    private String numutente;
    private String telefone;
    private String telefone_familiar;
    private String email;
    private String morada;

    public Utente(String nome,String nif, String cc, LocalDate datanasc,
                  String numutente, String telefone,
                  String telefone_familiar, String email, String morada) {
        super(nome, nif, cc, datanasc);
        this.numutente = numutente;
        this.telefone = telefone;
        this.telefone_familiar = telefone_familiar;
        this.email = email;
        this.morada = morada;
    }

    public Utente() {
        super();
        this.numutente = "";
        this.telefone = "";
        this.telefone_familiar = "";
        this.email = "";
        this.morada = "";
    }

    public Utente(String numutente, String telefone, String telefone_familiar, String email, String morada) {
        super();
        this.numutente = numutente;
        this.telefone = telefone;
        this.telefone_familiar = telefone_familiar;
        this.email = email;
        this.morada = morada;
    }

    public String getNumutente() {
        return numutente;
    }

    public void setNumutente(String numutente) {
        this.numutente = numutente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone_familiar() {
        return telefone_familiar;
    }

    public void setTelefone_familiar(String telefone_familiar) {
        this.telefone_familiar = telefone_familiar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    @Override
    public String toString() {
        return "Utente: " + super.toString() + " | " +
                "Número do utente: " + numutente + " | " +
                "Telefone: " + telefone + " | " +
                "Telefone familiar: " + telefone_familiar + " | " +
                "E-mail: " + email + " | " +
                "Morada: " + morada;
    }
}
