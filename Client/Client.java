
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Client {
    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9000);

            Student x = (Student) registry.lookup("l");
            Student y = (Student) registry.lookup("m");
        
            System.out.println("shariff Age : "+ x.getAge());
            System.out.println("Shariff Name : "+ x.getName());
            System.out.println("Glorry Name : "+ y.getName());
            System.out.println("Glorry Age :"+ y.getAge());

            
        }catch(Exception e){
            System.out.println("Client Side Error"+e);
        }
    }
   
}

