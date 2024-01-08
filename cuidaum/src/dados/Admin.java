package dados;


import java.io.Serializable;
import java.time.LocalDate;

public class Admin extends Utilizador implements Serializable {
    private String telefone;
    private String email;

    public Admin(String nome,String nif, String cc, LocalDate datanasc,
                 String telefone, String email) {
        super(nome, nif, cc, datanasc);
        this.telefone = telefone;
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Admin\n-------------\n" +
                super.toString() + " | " +
                "Telefone: " + telefone + " | " +
                "E-mail: " + email;
    }
}
