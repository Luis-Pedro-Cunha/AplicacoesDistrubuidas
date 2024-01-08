package dados;

import java.io.Serializable;
import java.time.LocalDate;

public class FamiliarUtente extends Utilizador implements Serializable {

    private static final long serialVersionUID = 2095039068141592120L;

    private String nome_familiar, telefone,grau_parentesco;

    public FamiliarUtente(String nome_familiar, String telefone, String grau_parentesco) {
        this.nome_familiar = nome_familiar;
        this.telefone = telefone;
        this.grau_parentesco = grau_parentesco;
    }

    public FamiliarUtente(String nome, String nif, String cc, LocalDate datanasc, String telefone, String grau_parentesco) {
        super(nome, nif, cc, datanasc);
        this.telefone = telefone;
        this.grau_parentesco = grau_parentesco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGrau_parentesco() {
        return grau_parentesco;
    }

    public void setGrau_parentesco(String grau_parentesco) {
        this.grau_parentesco = grau_parentesco;
    }

    @Override
    public String toString() {
        return "FamiliarUtente\n------------------\n" +
                super.toString() + " | " +
                "Telefone: " + telefone + " | " +
                "Grau de parentesco: " + grau_parentesco;
    }
}

