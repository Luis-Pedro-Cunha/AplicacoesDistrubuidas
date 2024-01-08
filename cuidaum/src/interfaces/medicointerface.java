package interfaces;

import dados.*;
import excepcoes.MedicoNaoExiste;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

public interface medicointerface extends Remote
{
    Map<String, FichaUtente> getFichasUtente() throws RemoteException;
    Map<String, Medicamento> getMedicamento() throws RemoteException;
    String loginmedico(String num_trabalhador, String nif) throws RemoteException;
    void AdicionarExame(String numutente, String idconsulta, LocalDateTime data, String tipo, String descricao, String resultado) throws RemoteException;
    void AdicionarPrescricao(String numutente,String idconsulta, LocalDate data_inicio, String id_medicamento, String indicacoes, String duracao) throws RemoteException;
    void AdicionarMedicao(String num_utente, LocalDate data, double peso, double altura, int tensao_arterial, int saturacao_oxigenio, int imc) throws RemoteException;
    String AdicionaFichaUtente(String numutente) throws RemoteException;
    FichaUtente getFichaUtenteEspecifico(String numutente) throws RemoteException;
    String MediaAltura() throws RemoteException;
    String MediaPeso() throws RemoteException;
    String MedianaAltura() throws RemoteException;
    String MedianaPeso() throws RemoteException;
    String MaxMinAltura() throws RemoteException;
    String MaxMinPeso() throws RemoteException;
    String MaxMinImc() throws RemoteException;
    String RiscoOxiBaixo() throws RemoteException;
    String RiscoHipertensao() throws RemoteException;
}
