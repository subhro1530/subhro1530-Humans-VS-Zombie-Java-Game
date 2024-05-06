package human_vs_zombie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int initialHumans = 69;
        double lambdaH = 2.0;
        int initialZombies = 99;
        double lambdaZ = 1.0;
        double totalTime = 50.0; // Simulation time
        double dt = 0.1;          // Time step for simulation

        Game game = new Game(initialHumans, lambdaH, initialZombies, lambdaZ);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Humans vs Zombies simulation!");

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Start simulation");
            System.out.println("2. Admin login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    game.simulate(totalTime, dt);
                    break;
                case 2:
                    game.adminLogin();
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
