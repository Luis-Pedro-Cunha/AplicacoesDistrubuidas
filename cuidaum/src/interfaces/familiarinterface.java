package interfaces;

import dados.*;
import excepcoes.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface familiarinterface extends Remote
{
    String loginfamiliar(String numutente, String nif, String nif_familiar) throws RemoteException;
    FichaUtente getFichaUtenteEspecifico(String numutente) throws RemoteException;
}
