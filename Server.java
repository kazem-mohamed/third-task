package rmi_calculator;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            // Start RMI Registry on port 6000
            LocateRegistry.createRegistry(6000);

            // Create Calculator service
            Calculator calc = new CalculatorImpl();

            // Bind service with name "CalculatorService"
            Naming.rebind("rmi://localhost:6000/CalculatorService", calc);

            System.out.println("Server --> Calculator Service bound.");
        } catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
