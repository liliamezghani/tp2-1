package tp2.activite1;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientTCP {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connecté au serveur !");
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une opération (ex: 15 + 25): ");
        String operation = scanner.nextLine();
        out.write(operation);
        out.newLine();
        out.flush();
        System.out.println("Opération envoyée: " + operation);
        String resultat = in.readLine();
        System.out.println("Résultat: " + resultat);
        scanner.close();
        in.close();
        out.close();
        socket.close();
    }
}
