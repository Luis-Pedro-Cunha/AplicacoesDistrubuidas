package dados;

import java.time.LocalDate;

public class Medico extends Utilizador {
    private static final long serialVersionUID = 2650540891875656129L;
    private String num_trabalhador, especialidade, email;

    public Medico(String nome, String nif, String cc, LocalDate datanasc, String num_trabalhador, String especialidade, String email) {
        super(nome, nif, cc, datanasc);
        this.num_trabalhador = num_trabalhador;
        this.especialidade = especialidade;
        this.email = email;
    }

    public String getNum_trabalhador() {
        return num_trabalhador;
    }

    public void setNum_trabalhador(String num_trabalhador) {
        this.num_trabalhador = num_trabalhador;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Médico\n------------------\n" + super.toString() + " | " +
                "ID Médico: " + num_trabalhador + " | " +
                "Especialidade: " + especialidade + " | " +
                "E-mail: " + email;
    }
}
