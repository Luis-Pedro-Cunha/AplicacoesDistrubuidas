package dados;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Consulta implements Serializable {

    private static final long serialVersionUID = -74661440005618893L;

    private LocalDateTime data;

    private Medico medico;

    private Utente utente;

    private List<Prescricao> prescricoes;

    private List<Exame> exames;

    private String observacoes;

    public Consulta(LocalDateTime data, Medico medico, Utente utente, String observacoes) {
        this.data = data;
        this.medico = medico;
        this.utente = utente;
        this.prescricoes = new ArrayList<>();
        this.exames = new ArrayList<>();
        this.observacoes = observacoes;}

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<Prescricao> getPrescricoes() {
        return prescricoes;
    }

    public void adicionarPrescricaoAux(Prescricao p){ this.prescricoes.add(p);}

    public void setPrescricoes(List<Prescricao> prescricoes) {
        this.prescricoes = prescricoes;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void adicionarExamesAux(Exame e){ this.exames.add(e);}

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }


    @Override
    public String toString() {
        return "Consultas\n-------------\n" +
                "Data: " + data + " | " +
                "Observações: " + observacoes + " | " +
                "Prescrições: " + prescricoes + " | " +
                "Exames: " + exames + " | " +
                "Profissional de saúde: " + medico;
    }
}
