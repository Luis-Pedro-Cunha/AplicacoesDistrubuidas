package app;

import interfaces.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor implements java.io.Serializable
{
    public static void main(String[] args) {
        try {

            PCmanager p = new PCmanager();
            Registry r = LocateRegistry.createRegistry(Configuracoes.rmiPort);
            Remote a = UnicastRemoteObject.exportObject(p, 0);
            funcionariointerface fi = (funcionariointerface) a;
            familiarinterface fai = (familiarinterface) a;
            medicointerface mi = (medicointerface) a;
            utenteinterface ui = (utenteinterface) a;
            admininterface ai = (admininterface) a;

            r.rebind(Configuracoes.rmiService,fi);
            r.rebind(Configuracoes.rmiService,fai);
            r.rebind(Configuracoes.rmiService,mi);
            r.rebind(Configuracoes.rmiService,ui);
            r.rebind(Configuracoes.rmiService, ai);
            System.out.println("Servidor funcional");
            System.in.read();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
