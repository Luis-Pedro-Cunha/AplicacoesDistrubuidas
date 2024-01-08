package interfaces;

import dados.Consulta;
import dados.FichaUtente;
import dados.Medico;
import dados.Utente;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface funcionariointerface extends Remote
{
    String adicionaUtente(String nome, String nif, String cc, LocalDate datanasc, String numutente, String telefone, String telefone_familiar, String email, String morada) throws RemoteException;
    String loginfuncionario(String num_funcionario, String nif) throws RemoteException;
    void AdicionarConsulta(LocalDateTime data, String num_trabalhador, String numutente, String observacoes) throws  RemoteException;
    FichaUtente getFichaUtenteEspecifico(String numutente) throws RemoteException;
}
