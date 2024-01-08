package interfaces;
import dados.Funcionario;
import excepcoes.*;
import dados.*;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Map;

public interface admininterface extends Remote
{
    Map<String, Medico> getMedico() throws MedicoNaoExiste, RemoteException;
    Map<String, Medicamento> getMedicamento() throws RemoteException;
    Map<String, Funcionario> getFuncionario() throws RemoteException;
    String loginadmin(String user, String password) throws RemoteException;
    String AdicionaMedico(String nome, String  nif, String cc, LocalDate datanasc, String num_trabalhador, String especialidade, String email) throws RemoteException;
    String AdicionaFuncionario(String nome, String  nif, String cc, LocalDate datanasc, String num_funcionario) throws RemoteException;
    String AdicionaMedicamento(String nome, String principioAtivo, String dose) throws RemoteException;
    Medicamento getMedicamentoEspecifico(String idmed) throws RemoteException;
    Funcionario getFuncionarioEspecifico(String num_funcionario) throws RemoteException;
    Medico getMedicoEspecifico(String num_trabalhador) throws RemoteException;
}
