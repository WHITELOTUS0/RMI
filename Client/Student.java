//package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Student extends Remote{

    public String getName() throws RemoteException;
    public int getAge() throws RemoteException;

}

