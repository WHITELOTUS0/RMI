import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    private static final int DELAY_TIME_MS = 500;

    public static void IndeterminateDotProgressBar(){
        int count = 0;
        while (true) {
            System.out.print(".");
            try {
                Thread.sleep(DELAY_TIME_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            if (count == 10) {
                System.out.print("\r");  // move cursor back to beginning of line
                for (int i = 0; i < 10; i++) {
                    System.out.print(" ");  // overwrite dots with spaces
                }
                System.out.print("\r");  // move cursor back to beginning of line
                count = 0;
            }
        }
    }
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
            IndeterminateDotProgressBar();

        } catch (Exception e) {
            System.out.println("Server side Error" + e);
        }
    }
}

//Server
//fixed bugs
//remote