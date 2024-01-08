package dados;

import java.io.Serializable;
import java.time.LocalDate;

public class Prescricao implements Serializable {

    private static final long serialVersionUID = 1799436740506491340L;
    private LocalDate data_inicio;
    private Medicamento medicamento;

    private String indicacoes, duracao;

    public Prescricao() {
        data_inicio = LocalDate.now();
    }

    public Prescricao(LocalDate data_inicio, Medicamento medicamento, String indicacoes, String duracao) {
        this.data_inicio = data_inicio;
        this.medicamento = medicamento;
        this.indicacoes = indicacoes;
        this.duracao = duracao;
    }

    public Prescricao(Medicamento medicamento, String indicacoes, String duracao) {
        this.data_inicio = LocalDate.now();
        this.medicamento = medicamento;
        this.indicacoes = indicacoes;
        this.duracao = duracao;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public String getIndicacoes() {
        return indicacoes;
    }

    public void setIndicacoes(String indicacoes) {
        this.indicacoes = indicacoes;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Prescricões\n-------------\n" + "Data de início" + data_inicio + " | " +
                "Medicamento: " + medicamento + " | " +
                "Indicações de toma: " + indicacoes + " | " +
                "Duração da toma: " + duracao;
    }

    }