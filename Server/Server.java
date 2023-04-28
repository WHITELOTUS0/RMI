import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("Starting Server");

            System.setProperty("java.rmi.server.hostname", "127.0.0.1");

            System.out.println("...........");

            StudentImpl s1 = new StudentImpl("Shariff", 22);
            StudentImpl s2 = new StudentImpl("Glorry", 20);

            Student uni1 = (Student) UnicastRemoteObject.exportObject(s1, 0);
            Student uni2 = (Student) UnicastRemoteObject.exportObject(s2, 0);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9000);

            registry.rebind("l", uni1);
            registry.rebind("m", uni2);
            System.out.println("Server Has Started");

        } catch (Exception e) {
            System.out.println("Server side Error" + e);
        }
    }
}

//Server
