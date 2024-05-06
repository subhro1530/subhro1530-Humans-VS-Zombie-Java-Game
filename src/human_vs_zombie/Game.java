package human_vs_zombie;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Player humans;
    private Player zombies;
    private List<String[]> results;

    public Game(int initialHumans, double lambdaH, int initialZombies, double lambdaZ) {
        humans = new Player(initialHumans, lambdaH, "Human");
        zombies = new Player(initialZombies, lambdaZ, "Zombie");
        results = new ArrayList<>();
    }

    public void simulate(double totalTime, double dt) {
        double currentTime = 0;

        while (currentTime < totalTime && humans.isAlive() && zombies.isAlive()) {
            double killsByZombies = humans.getN() * zombies.getKillRate();
            double killsByHumans = zombies.getN() * humans.getKillRate();

            humans.iterate(dt, killsByZombies);
            zombies.iterate(dt, killsByHumans);

            results.add(new String[]{Double.toString(currentTime), Integer.toString(humans.getN()), Integer.toString(zombies.getN())});

            currentTime += dt;
        }

        printResults();
        saveResultsToCSV("game_results.csv");
    }

    private void printResults() {
        if (humans.isAlive() && !zombies.isAlive()) {
            System.out.println("Humans win!");
        } else if (!humans.isAlive() && zombies.isAlive()) {
            System.out.println("Zombies win!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private void saveResultsToCSV(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Time,Humans,Zombies\n");
            for (String[] row : results) {
                writer.write(String.join(",", row) + "\n");
            }
            System.out.println("Results saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving results to CSV: " + e.getMessage());
        }
    }

    public void adminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter admin password:");
        String password = scanner.nextLine();

        if (password.equals("humanhateszombie")) {
            System.out.println("Admin login successful!");
            System.out.println("Current parameters:");
            System.out.println("Lambda for Humans: " + humans.getKillRate());
            System.out.println("Lambda for Zombies: " + zombies.getKillRate());

            System.out.println("Do you want to change parameters? (yes/no)");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("yes")) {
                System.out.println("Enter new lambda for Humans:");
                double newLambdaH = scanner.nextDouble();
                humans.setKillRate(newLambdaH);

                System.out.println("Enter new lambda for Zombies:");
                double newLambdaZ = scanner.nextDouble();
                zombies.setKillRate(newLambdaZ);

                System.out.println("Parameters updated successfully!");
            } else {
                System.out.println("Admin session ended.");
            }
        } else {
            System.out.println("Invalid password. Access denied.");
        }
    }
}
