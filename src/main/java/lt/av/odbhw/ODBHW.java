package lt.av.odbhw;

import lt.av.odbhw.controllers.Controller;
import lt.av.odbhw.controllers.OwnerController;
import lt.av.odbhw.controllers.PetController;
import lt.av.odbhw.repositories.Owners;
import lt.av.odbhw.repositories.Pets;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ODBHW {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/odbhw.odb");
        EntityManager em = emf.createEntityManager();

        Owners owners = new Owners(em);

        Map<String, Controller> controllers = Map.of(
            "pet", new PetController(new Pets(em), owners),
            "owner", new OwnerController(owners)
        );

        mainLoop(controllers);

        em.close();
        emf.close();
    }

    private static void mainLoop(Map<String, Controller> controllers) {

        List<String> terminateCommands = List.of("quit", "q", "exit", "e");
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Waiting for command:");
            String[] words = input.nextLine().split(" ");
            String command = words[0];
            if (terminateCommands.contains(command)) {
                break;
            }

            if (words.length < 2) {
                System.out.println("Set must be provided");
                continue;
            }

            String repository = words[1];
            List<String> params;
            params = List.of(words).subList(2, words.length);
            try {
                controllers.get(repository).execute(command, params);
            }
            catch (RuntimeException ignored) {
                ignored.printStackTrace();
            }
        }

    }

}
