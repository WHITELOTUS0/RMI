
import java.rmi.RemoteException;


public class StudentImpl implements Student {

    public String name;
    public int age;

    StudentImpl(String name, int age) throws RemoteException {
        this.name = name;
        this.age = age;
    }

    public String getName() throws RemoteException {
        return this.name;
    }

    public int getAge() throws RemoteException {
        return this.age;
    }
}

//This is my code 
//Interface Implementation
