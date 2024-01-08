package dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FichaUtente implements Serializable {
    private static final long serialVersionUID = 7924343070283612359L;
    private Utente utente;
    private List<FamiliarUtente> familiarUtente;
    private List<Medicao> medicoes;
    private List<Prescricao> prescricoes;
    private List<Exame> exames;
    private List<Consulta> consultas;


    public FichaUtente(Utente utente) {
        this.utente=utente;
        this.familiarUtente = new ArrayList<>();
        this.medicoes = new ArrayList<>();
        this.prescricoes = new ArrayList<>();
        this.exames= new ArrayList<>();
        this.consultas = new ArrayList<>();
    }


    public Utente getUtente() {
        return utente;
    }

    public String getNif() {
        String nif = "";
        if (!familiarUtente.isEmpty()) {
            for(int i=0;i<familiarUtente.size();i++){
                FamiliarUtente familiar = familiarUtente.get(i);
                nif = familiar.getNif();
            }
        } else {
            nif = "";
        }
        return nif;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<FamiliarUtente> getFamiliarUtente() {
        return this.familiarUtente;
    }

    public void adicionarFamiliarAux(FamiliarUtente fu){this.familiarUtente.add(fu);}

    public void setFamiliarUtente(FamiliarUtente familiarUtente) {
        this.familiarUtente = (List<FamiliarUtente>) familiarUtente;
    }

    public List<Medicao> getMedicoes() {
        return this.medicoes;
    }

    public void adicionarMedicaoAux(Medicao m){this.medicoes.add(m); }

    public void setMedicoes(List<Medicao> medicoes) {
        this.medicoes = medicoes;
    }

    public List<Prescricao> getPrescricoes() {
        return this.prescricoes;
    }

    public void adicionarPrescricaoAux(Prescricao p){ this.prescricoes.add(p);}


    public void setPrescricoes(List<Prescricao> prescricoes) {
        this.prescricoes = prescricoes;
    }

    public List<Exame> getExames() {
        return this.exames;
    }

    public void adicionarExamesAux(Exame e){ this.exames.add(e);}

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    public List<Consulta> getConsultas() {
        return this.consultas;
    }

    public void adicionarConsultasAux(Consulta c){ this.consultas.add(c);}

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "Ficha de Utente\n------------------\n" +
                "Utente: " + utente + " | " +
                "Familiar(res) do utente: " + familiarUtente + " | " +
                "Medições: " + medicoes + " | " +
                "Prescrições: " + prescricoes + " | " +
                "Exames: " + exames + " | " +
                "Consultas: " + consultas;
    }

}
