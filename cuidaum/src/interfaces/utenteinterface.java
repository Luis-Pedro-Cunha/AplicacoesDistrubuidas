package interfaces;

import dados.FichaUtente;
import excepcoes.*;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface utenteinterface extends Remote
{
    String loginutente(String numutente, String nif) throws RemoteException;
    FichaUtente getFichaUtenteEspecifico(String numutente) throws RemoteException;
    String AdicionarFamiliarUtente(String numutente, String nome, String nif, String cc, LocalDate datanasc, String telefone, String grau_parentesco) throws RemoteException;

}
