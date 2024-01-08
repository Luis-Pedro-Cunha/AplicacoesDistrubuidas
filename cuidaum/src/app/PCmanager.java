package app;

import dados.Funcionario;
import excepcoes.*;
import interfaces.*;
import dados.*;

import java.io.*;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class PCmanager implements Serializable, medicointerface, utenteinterface, funcionariointerface, admininterface, familiarinterface {

    private static final long serialVersionUID = -9149826635246618824L;

    private Map<String, FichaUtente> fichasUtente;
    private Map<String, Medico> medicos;
    private Map<String, Funcionario> funcionarios;
    private Map<String, Medicamento> medicamentos;
    private List<FamiliarUtente> familiaresutente;
    private Map<String, Consulta> consultas;
    private Map<String, Exame> exames;
    private Map<String, Prescricao> prescricoes;
    private Map<String, Medicao> medicoes;
    private Map<String, Utente> utentes;
    int c1=0;
    int c2=0;
    int c3=0;
    int c4=0;
    int c5=0;
    public PCmanager(){
        fichasUtente = new HashMap<>();
        medicos = new HashMap<>();
        funcionarios = new HashMap<>();
        medicamentos = new HashMap<>();
        consultas = new HashMap<>();
        exames = new HashMap<>();
        prescricoes = new HashMap<>();
        medicoes = new HashMap<>();
        utentes = new HashMap<>();
        familiaresutente = new ArrayList<>();
    }




    // METODOS DE LOGIN

    
    public String loginadmin(String user, String password) throws RemoteException {
        if(!user.equals("Admin")){
            return("ERRO_1: Utilizador inválido!");
        } else if (!password.equals("1234")) {
            return("ERRO_2: Password inválida!");
        } else {
            return("Login efetuado com sucesso!");
        }
    }
    
    public String loginmedico(String num_trabalhador, String nif) throws RemoteException {
        if(!this.medicos.containsKey(num_trabalhador))
        {
            return("ERRO_1: Utilizador inválido!");
        }
        else if(!this.medicos.get(num_trabalhador).getNif().equals(nif))
        {
            return("ERRO_2: Password inválida!");
        }
        else {
            return("Login efetuado com sucesso!");
        }
    }

    
    public String loginfuncionario(String num_funcionario, String nif) throws RemoteException
    {

        if(!this.funcionarios.containsKey(num_funcionario))
        {
            return("ERRO_1: Utilizador inválido!");
        }
        else if(!this.funcionarios.get(num_funcionario).getNif().equals(nif))
        {
            return("ERRO_2: Password inválida!");
        }
        else {
            return("Login efetuado com sucesso!");
        }
    }
    
    public String loginutente(String numutente, String nif) throws RemoteException
    {
        if(!this.fichasUtente.containsKey(numutente))
        {
            return("ERRO_1: Utilizador inválido!");
        }
        else if(!this.fichasUtente.get(numutente).getUtente().getNif().equals(nif))
        {
            return("ERRO_2: Password inválida!");
        }
        else {
            return("Login efetuado com sucesso!");
        }
    }

    public String loginfamiliar(String numutente, String nif, String nif_familiar) throws RemoteException
    {
        String mensagem = "";
        if(!this.fichasUtente.containsKey(numutente))
        {
            mensagem = "ERRO_1: Utilizador inválido!";
        }
        else if(!this.fichasUtente.get(numutente).getUtente().getNif().equals(nif))
        {
            mensagem = "ERRO_2: Password do utente inválida!";
        }
        else if (!this.fichasUtente.get(numutente).getNif().equals(nif_familiar))
        {
            mensagem = "ERRO_3: Password do familiar inválida!";
        }
        else
        {
            mensagem = "Login efetuado com sucesso!";
        }
        return mensagem;
    }

    //METODOS DE ADICAO
    public  String adicionaUtente(String nome, String nif, String cc, LocalDate datanasc, String numutente, String telefone, String telefone_familiar, String email, String morada) throws RemoteException
    {
        Utente u = new Utente(nome,  nif, cc, datanasc, numutente, telefone,telefone_familiar, email, morada);
        if(!utentes.containsKey(numutente)){
            utentes.put(numutente, u);
            return("Utente adicionado com sucesso!");
        } else if (utentes.get(numutente).getNif().equals(nif) && utentes.get(numutente).getCc().equals(cc)) {
            return("ERRO_5: O indivíduo já é utente.");
        } else if (utentes.get(numutente).getNif().equals(nif) || utentes.get(numutente).getCc().equals(cc)) {
            return("ERRO_6: Ou o NIF ou o número de CC é inválido");
        } else {
            return("ERRO_4: O ID do utente já existe!");
        }


    }

    public String AdicionaMedico(String nome, String nif, String cc, LocalDate datanasc, String num_trabalhador, String especialidade, String email) throws RemoteException
    {
        Medico m = new Medico(nome, nif, cc, datanasc, num_trabalhador, especialidade, email);
        if(!medicos.containsKey(num_trabalhador)){
            medicos.put(num_trabalhador, m); //adiciona o num_trabalhador como key e as restantes informacoes do medico como values
            return("Médico adicionado com sucesso!");
        }
        else {
            return("ERRO_3: O ID do médico já existe!");
        }

    }
    public String AdicionaMedicamento(String nome, String principioAtivo, String dose) throws RemoteException
    {
        c1+=1;
        Medicamento m = new Medicamento(nome, principioAtivo, dose);
        this.medicamentos.put(String.valueOf(c1), new Medicamento(m.getNome(),m.getPrincipioAtivo(), m.getDose()));
        return("Medicamento adicionado com sucesso!");

    }
    public  String AdicionaFuncionario(String nome, String nif, String cc, LocalDate datanasc, String num_funcionario) throws RemoteException
    {
        Funcionario f = new Funcionario(nome, nif, cc, datanasc, num_funcionario);
        if(!funcionarios.containsKey(num_funcionario)){
            funcionarios.put(num_funcionario, f); //adiciona o num_funcionario como key e as restantes informacoes do funcionario como values
            return("Funcionário adicionado com sucesso!");
        }
        else {
            return("ERRO_4: O ID do funcionário já existe!");
        }
    }

    public  String AdicionaFichaUtente(String numutente) throws RemoteException{
        FichaUtente fichautente = new FichaUtente(getUtenteEspecifico(numutente));
        if(!fichasUtente.containsKey(numutente)){
            fichasUtente.put(numutente, fichautente);
            return("Funcionário adicionado com sucesso!");
        }
        else {
            return("ERRO_7: A ficha de utente para o utente referido já existe!");
        }
    }

    public void AdicionarMedicao(String num_utente, LocalDate data, double peso, double altura, int tensao_arterial, int saturacao_oxigenio, int imc) throws RemoteException, UtenteNaoExiste {
        c2+=1;
        Medicao m = new Medicao(data, peso, altura, tensao_arterial, saturacao_oxigenio, imc);
        medicoes.put(String.valueOf(c2),m);
        FichaUtente fumedicao = fichasUtente.get(num_utente);
        fumedicao.adicionarMedicaoAux(m);
    }

    public void AdicionarConsulta(LocalDateTime data, String num_trabalhador, String numutente, String observacoes) throws  RemoteException
    {
        c3+=1;
        Consulta c = new Consulta(data, medicos.get(num_trabalhador), utentes.get(numutente), observacoes);
        consultas.put(String.valueOf(c3),c);
        FichaUtente fuconsulta = fichasUtente.get(numutente);
        fuconsulta.adicionarConsultasAux(c);
    }

    public void AdicionarExame(String numutente, String idconsulta, LocalDateTime data, String tipo, String descricao, String resultado) throws RemoteException {
        c4+=1;
        Exame e = new Exame(data, tipo, descricao, resultado);
        exames.put(String.valueOf(c4),e);
        FichaUtente fuexame = fichasUtente.get(numutente);
        fuexame.adicionarExamesAux(e);
        Consulta cexame = consultas.get(idconsulta);
        cexame.adicionarExamesAux(e);
    }

    public void AdicionarPrescricao(String numutente,String idconsulta, LocalDate data_inicio, String id_medicamento, String indicacoes, String duracao) throws RemoteException {
        c5+=1;
        Prescricao p = new Prescricao(data_inicio, medicamentos.get(id_medicamento), indicacoes,duracao);
        prescricoes.put(String.valueOf(c5),p);
        FichaUtente fuprescricoes = fichasUtente.get(numutente);
        fuprescricoes.adicionarPrescricaoAux(p);
        Consulta cprescricoes = consultas.get(idconsulta);
        cprescricoes.adicionarPrescricaoAux(p);
    }
    public String AdicionarFamiliarUtente(String numutente, String nome, String nif, String cc, LocalDate datanasc, String telefone, String grau_parentesco) throws RemoteException{
        FamiliarUtente fu = new FamiliarUtente(nome,  nif, cc, datanasc, telefone, grau_parentesco);
        FichaUtente fufamiliar = fichasUtente.get(numutente);
        if(!fufamiliar.getNif().equals(nif)){
            fufamiliar.adicionarFamiliarAux(fu);
            return("Familiar adicionado com sucesso!");
        } else {
            return("ERRO_8: O indivíduo já foi adicionado.");
        }
    }

    // METODOS TIPO GET


    
    public Map<String, Medico> getMedico() throws MedicoNaoExiste, RemoteException {
        return medicos;
    }

    
    public Map<String, Medicamento> getMedicamento() throws RemoteException {
        return medicamentos;
    }

    
    public Map<String, Funcionario> getFuncionario() throws RemoteException {
        return funcionarios;
    }
    
    public Map<String, FichaUtente> getFichasUtente() throws RemoteException {
        return fichasUtente;
    }

    public Map<String, Medicao> getMedicoes() throws RemoteException{
        return medicoes;
    }

    public Map<String, Utente> getUtente() throws RemoteException {
        return utentes;
    }

    public Medico getMedicoEspecifico(String num_trabalhador) throws RemoteException{  //FichaUtente em vez do void para retornar o FichaMedico
        if(! this.medicos.containsKey(num_trabalhador)){
            throw new MedicoNaoExiste();
        }
        return this.medicos.get(num_trabalhador); //dá a informação do medico consoante o num_trabalhador
    }

    public Utente getUtenteEspecifico(String num_utente) throws RemoteException{
        if(! this.utentes.containsKey(num_utente)){
            throw new UtenteNaoExiste();
        }
        return this.utentes.get(num_utente);
    }
    public Funcionario getFuncionarioEspecifico(String num_funcionario) throws RemoteException {
        if(! this.funcionarios.containsKey(num_funcionario)){
            throw new FuncionarioNaoExiste();
        }
        return this.funcionarios.get(num_funcionario); //dá a informação do funcionario consoante o num_funcionario
    }

    public Medicamento getMedicamentoEspecifico(String idmed) throws RemoteException {
        if(! this.medicamentos.containsKey(idmed)){
            throw new MedicamentoNaoExiste();
        }
        return this.medicamentos.get(idmed); //dá a informação do medicamento consoante o seu nome
    }

    public FichaUtente getFichaUtenteEspecifico(String numutente) throws RemoteException {
        if(! this.fichasUtente.containsKey(numutente)){
            throw new FichaUtenteNaoExiste();
        }
        return this.fichasUtente.get(numutente);
    }

    // METODOS ESTATÍSTICOS

    public String MediaAltura() throws RemoteException {
        Double somaAltura = 0.0;
        Double numeroDados = 0.0;
        List<Double> alturas = new ArrayList<>();
        List<String> keyListUtente = new ArrayList<>(fichasUtente.keySet());
        Boolean mensagem;
        double mediaAltura;
        List<Boolean> mensagens = new ArrayList<>();
        List<String> numerosUtente = new ArrayList<>(utentes.keySet());
        Integer index;
        String mensagemfinal;
        for (int i=0; i < keyListUtente.size();i++) {
            if (!fichasUtente.get(numerosUtente.get(i)).getMedicoes().isEmpty()) {
                index = (fichasUtente.get(numerosUtente.get(i)).getMedicoes().size())-1;
                double altura = fichasUtente.get(numerosUtente.get(i)).getMedicoes().get(index).getAltura();
                alturas.add(altura);
                numeroDados += 1.0;
                mensagem = TRUE;
                mensagens.add(mensagem);
            } else {
                mensagem = FALSE;
                mensagens.add(mensagem);
            }
        }
        if ((mensagens.contains(FALSE))&&(!mensagens.contains(TRUE))) {
            mensagemfinal = "Por favor, adicione medições antes de testar!";
        }
        else {
            for (int j=0;j<alturas.size();j++){
                somaAltura += alturas.get(j);
            }
            mediaAltura = somaAltura / numeroDados;
            mensagemfinal = "A média das alturas dos utentes é " + mediaAltura + ".";
        }


        return mensagemfinal;
    }
    public String MediaPeso() throws RemoteException {
        Double somaPesos = 0.0;
        Double numeroDados = 0.0;
        List<Double> pesos = new ArrayList<>();
        List<String> keyListUtente = new ArrayList<>(fichasUtente.keySet());
        Boolean mensagem;
        double mediaPesos;
        List<Boolean> mensagens = new ArrayList<>();
        List<String> numerosUtente = new ArrayList<>(utentes.keySet());
        Integer index;
        String mensagemfinal;
        for (int i=0; i < keyListUtente.size();i++) {
            if (!fichasUtente.get(numerosUtente.get(i)).getMedicoes().isEmpty()) {
                index = (fichasUtente.get(numerosUtente.get(i)).getMedicoes().size())-1;
                double peso = fichasUtente.get(numerosUtente.get(i)).getMedicoes().get(index).getPeso();
                pesos.add(peso);
                numeroDados += 1.0;
                mensagem = TRUE;
                mensagens.add(mensagem);
            } else {
                mensagem = FALSE;
                mensagens.add(mensagem);
            }
        }
        if ((mensagens.contains(FALSE))&&(!mensagens.contains(TRUE))) {
            mensagemfinal = "Por favor, adicione medições antes de testar!";
        }
        else {
            for (int j=0;j<pesos.size();j++){
                somaPesos += pesos.get(j);
            }
            mediaPesos = somaPesos / numeroDados;
            mensagemfinal = "A média dos pesos dos utentes é " + mediaPesos + ".";
        }


        return mensagemfinal;
    }
    public String MedianaAltura() throws RemoteException {
        List<Double> alturas = new ArrayList<>();
        List<String> keyListUtente = new ArrayList<>(fichasUtente.keySet());
        Boolean mensagem;
        Double medianaAltura;
        List<Boolean> mensagens = new ArrayList<>();
        List<String> numerosUtente = new ArrayList<>(utentes.keySet());
        Integer index;
        String mensagemfinal = null;
        for (int i=0; i < keyListUtente.size();i++) {
            if (!fichasUtente.get(numerosUtente.get(i)).getMedicoes().isEmpty()) {
                index = (fichasUtente.get(numerosUtente.get(i)).getMedicoes().size())-1;
                double altura = fichasUtente.get(numerosUtente.get(i)).getMedicoes().get(index).getAltura();
                alturas.add(altura);
                mensagem = TRUE;
                mensagens.add(mensagem);
            } else {
                mensagem = FALSE;
                mensagens.add(mensagem);
            }
        }
        if ((mensagens.contains(FALSE))&&(!mensagens.contains(TRUE))) {
            mensagemfinal = "Por favor, adicione medições antes de testar!";
        }
        else {
            if (alturas.size()%2==0){
                Integer meioLista = alturas.size()/2;
                medianaAltura = (alturas.get(meioLista-1)+alturas.get(meioLista))/2;
                mensagemfinal = ("A mediana das alturas dos utentes é " + medianaAltura.toString() + ".");
            } else if (alturas.size()%2==1) {
                Double meiolista = (alturas.size()/2)-0.5;
                medianaAltura = alturas.get(meiolista.intValue());
                mensagemfinal = ("A mediana das alturas dos utentes é " + medianaAltura.toString() + ".");
            }

        }

        return mensagemfinal;
    }
    public String MedianaPeso() throws RemoteException {
        List<Double> pesos = new ArrayList<>();
        List<String> keyListUtente = new ArrayList<>(fichasUtente.keySet());
        Boolean mensagem;
        Double medianaPeso;
        List<Boolean> mensagens = new ArrayList<>();
        List<String> numerosUtente = new ArrayList<>(utentes.keySet());
        Integer index;
        String mensagemfinal = null;
        for (int i=0; i < keyListUtente.size();i++) {
            if (!fichasUtente.get(numerosUtente.get(i)).getMedicoes().isEmpty()) {
                index = (fichasUtente.get(numerosUtente.get(i)).getMedicoes().size())-1;
                double peso = fichasUtente.get(numerosUtente.get(i)).getMedicoes().get(index).getPeso();
                pesos.add(peso);
                mensagem = TRUE;
                mensagens.add(mensagem);
            } else {
                mensagem = FALSE;
                mensagens.add(mensagem);
            }
        }
        if ((mensagens.contains(FALSE))&&(!mensagens.contains(TRUE))) {
            mensagemfinal = "Por favor, adicione medições antes de testar!";
        }
        else {
            if (pesos.size()%2==0){
                Integer meioLista = pesos.size()/2;
                medianaPeso = (pesos.get(meioLista-1)+pesos.get(meioLista))/2;
                mensagemfinal = ("A mediana dos pesos dos utentes é " + medianaPeso.toString() + ".");
            } else if (pesos.size()%2==1) {
                Double meiolista = (pesos.size()/2)-0.5;
                medianaPeso = pesos.get(meiolista.intValue());
                mensagemfinal = ("A mediana dos pesos dos utentes é " + medianaPeso.toString() + ".");
            }

        }

        return mensagemfinal;
    }
    public String MaxMinAltura() throws RemoteException {
        List<Double> alturas = new ArrayList<>();
        List<String> keyListUtente = new ArrayList<>(fichasUtente.keySet());
        Boolean mensagem;
        List<Boolean> mensagens = new ArrayList<>();
        List<String> numerosUtente = new ArrayList<>(utentes.keySet());
        Integer index;
        String mensagemfinal;
        for (int i=0; i < keyListUtente.size();i++) {
            if (!fichasUtente.get(numerosUtente.get(i)).getMedicoes().isEmpty()) {
                index = (fichasUtente.get(numerosUtente.get(i)).getMedicoes().size())-1;
                double altura = fichasUtente.get(numerosUtente.get(i)).getMedicoes().get(index).getAltura();
                alturas.add(altura);
                mensagem = TRUE;
                mensagens.add(mensagem);
            } else {
                mensagem = FALSE;
                mensagens.add(mensagem);
            }
        }
        if ((mensagens.contains(FALSE))&&(!mensagens.contains(TRUE))) {
            mensagemfinal = "Por favor, adicione medições antes de testar!";
        }
        else {
            alturas.sort(null);
            mensagemfinal = ("O utente mais alto tem " + alturas.get(alturas.size()-1) + " e o mais baixo tem " + alturas.get(0) + ".");
        }


        return mensagemfinal;
    }
    public String MaxMinPeso() throws RemoteException {
        List<Double> pesos = new ArrayList<>();
        List<String> keyListUtente = new ArrayList<>(fichasUtente.keySet());
        Boolean mensagem;
        List<Boolean> mensagens = new ArrayList<>();
        List<String> numerosUtente = new ArrayList<>(utentes.keySet());
        Integer index;
        String mensagemfinal;
        for (int i=0; i < keyListUtente.size();i++) {
            if (!fichasUtente.get(numerosUtente.get(i)).getMedicoes().isEmpty()) {
                index = (fichasUtente.get(numerosUtente.get(i)).getMedicoes().size())-1;
                double peso = fichasUtente.get(numerosUtente.get(i)).getMedicoes().get(index).getPeso();
                pesos.add(peso);
                mensagem = TRUE;
                mensagens.add(mensagem);
            } else {
                mensagem = FALSE;
                mensagens.add(mensagem);
            }
        }
        if ((mensagens.contains(FALSE))&&(!mensagens.contains(TRUE))) {
            mensagemfinal = "Por favor, adicione medições antes de testar!";
        }
        else {
            pesos.sort(null);
            mensagemfinal = ("O utente mais pesado tem " + pesos.get(pesos.size()-1) + " e o mais leve tem " + pesos.get(0) + ".");
        }


        return mensagemfinal;
    }
    public String MaxMinImc() throws RemoteException {
        List<Integer> imcs = new ArrayList<>();
        List<String> keyListUtente = new ArrayList<>(fichasUtente.keySet());
        Boolean mensagem;
        List<Boolean> mensagens = new ArrayList<>();
        List<String> numerosUtente = new ArrayList<>(utentes.keySet());
        Integer index;
        String mensagemfinal;
        for (int i=0; i < keyListUtente.size();i++) {
            if (!fichasUtente.get(numerosUtente.get(i)).getMedicoes().isEmpty()) {
                index = (fichasUtente.get(numerosUtente.get(i)).getMedicoes().size())-1;
                int imc = fichasUtente.get(numerosUtente.get(i)).getMedicoes().get(index).getImc();
                imcs.add(imc);
                mensagem = TRUE;
                mensagens.add(mensagem);
            } else {
                mensagem = FALSE;
                mensagens.add(mensagem);
            }
        }
        if ((mensagens.contains(FALSE))&&(!mensagens.contains(TRUE))) {
            mensagemfinal = "Por favor, adicione medições antes de testar!";
        }
        else {
            imcs.sort(null);
            mensagemfinal = ("O utente com maior IMC tem " + imcs.get(imcs.size()-1) + " IMC e o com menor tem " + imcs.get(0) + " IMC.");
        }


        return mensagemfinal;

    }
    public String RiscoOxiBaixo() throws RemoteException {
        List<String> listaNomes = new ArrayList<>();
        List<String> keyListUtente = new ArrayList<>(fichasUtente.keySet());
        Boolean mensagem;
        List<Boolean> mensagens = new ArrayList<>();
        List<String> numerosUtente = new ArrayList<>(utentes.keySet());
        Integer index;
        String mensagemfinal;
        for (int i=0; i < keyListUtente.size();i++) {
            if (!fichasUtente.get(numerosUtente.get(i)).getMedicoes().isEmpty()) {
                index = (fichasUtente.get(numerosUtente.get(i)).getMedicoes().size())-1;
                int sp02 = fichasUtente.get(numerosUtente.get(i)).getMedicoes().get(index).getSaturacao_oxigenio();
                if (sp02 < 90){
                    listaNomes.add(fichasUtente.get(numerosUtente.get(i)).getUtente().getNome());
                }
                mensagem = TRUE;
                mensagens.add(mensagem);
            } else {
                mensagem = FALSE;
                mensagens.add(mensagem);
            }
        }
        if ((mensagens.contains(FALSE))&&(!mensagens.contains(TRUE))) {
            mensagemfinal = "Por favor, adicione medições antes de testar!";
        }
        else {
            mensagemfinal = ("A lista dos utentes em situação de risco por causa de valores reduzidos de saturação de oxigénio é: " + listaNomes);
        }

        return mensagemfinal;
    }
    public String RiscoHipertensao() throws RemoteException {
        List<String> listaNomes = new ArrayList<>();
        List<String> keyListUtente = new ArrayList<>(fichasUtente.keySet());
        Boolean mensagem;
        List<Boolean> mensagens = new ArrayList<>();
        List<String> numerosUtente = new ArrayList<>(utentes.keySet());
        Integer index;
        String mensagemfinal;
        for (int i=0; i < keyListUtente.size();i++) {
            if (!fichasUtente.get(numerosUtente.get(i)).getMedicoes().isEmpty()) {
                index = (fichasUtente.get(numerosUtente.get(i)).getMedicoes().size())-1;
                int press_art = fichasUtente.get(numerosUtente.get(i)).getMedicoes().get(index).getTensao_arterial();
                if (press_art > 120){
                    listaNomes.add(fichasUtente.get(numerosUtente.get(i)).getUtente().getNome());
                }
                mensagem = TRUE;
                mensagens.add(mensagem);
            } else {
                mensagem = FALSE;
                mensagens.add(mensagem);
            }
        }
        if ((mensagens.contains(FALSE))&&(!mensagens.contains(TRUE))) {
            mensagemfinal = "Por favor, adicione medições antes de testar!";
        }
        else {
            mensagemfinal = ("A lista dos utentes em situação de risco por motivos de hipertensão é: " + listaNomes);
        }

        return mensagemfinal;
    }


}
