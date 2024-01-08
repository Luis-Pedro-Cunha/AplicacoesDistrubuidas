package dados;

import java.io.Serializable;

public class Medicamento implements Serializable {
    private static final long serialVersionUID = 5783039555577172905L;
    private String nome;
    private String principioAtivo;
    private String dose;

    public Medicamento (String nome, String principioAtivo, String dose) {
        this.nome = nome;
        this.principioAtivo = principioAtivo;
        this.dose = dose;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    @Override
    public String toString() {
        return "Medicamento\n------------\n" +
                "Nome: " + nome + " | " +
                "Princípio Ativo: " + principioAtivo + " | " +
                "Dose: " + dose;
    }
}
