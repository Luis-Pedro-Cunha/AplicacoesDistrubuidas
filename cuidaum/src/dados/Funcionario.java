package dados;

import java.io.Serializable;
import java.time.LocalDate;

public class Funcionario extends Utilizador implements Serializable {
    private static final long serialVersionUID = -6037955058338097036L;
    private String num_funcionario;


    public Funcionario(String nome, String nif, String cc, LocalDate datanasc, String num_funcionario) {
        super(nome, nif, cc, datanasc);
        this.num_funcionario = num_funcionario;
    }

    public String getNum_funcionario() {
        return num_funcionario;
    }

    public void setNum_funcionario(String num_funcionario) {
        this.num_funcionario = num_funcionario;
    }
    @Override
    public String toString() {
        return "Funcionário\n------------------\n" + " | " +
                super.toString() + " | " +
                "Número de funcionário: " + num_funcionario;
    }
}
