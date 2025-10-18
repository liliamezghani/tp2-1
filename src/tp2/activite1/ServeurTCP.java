package tp2.activite1;
import java.io.*;
import java.net.*;

public class ServeurTCP {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Serveur en attente sur le port 1234...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connecté !");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String operation = in.readLine();
        System.out.println("Opération reçue: " + operation);
        String resultat = calculer(operation);
        out.write(resultat);
        out.newLine();
        out.flush();
        System.out.println("Résultat envoyé: " + resultat);
        in.close();
        out.close();
        socket.close();
        serverSocket.close();
    }
    public static String calculer(String operation) {
        try {
            String[] parties = operation.split(" ");
            double nb1 = Double.parseDouble(parties[0]);
            String op = parties[1];
            double nb2 = Double.parseDouble(parties[2]);
            
            switch (op) {
                case "+": return String.valueOf(nb1 + nb2);
                case "-": return String.valueOf(nb1 - nb2);
                case "*": return String.valueOf(nb1 * nb2);
                case "/": 
                    if (nb2 == 0) return "Erreur: Division par zéro";
                    return String.valueOf(nb1 / nb2);
                default: return "Erreur: Opérateur invalide";
            }
        } catch (Exception e) {
            return "Erreur: Format incorrect";
        }
    }
}
