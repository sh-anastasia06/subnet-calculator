package com.network;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== SUBNET CALCULATOR =====");

        while (true) {
            System.out.print("Enter IP/CIDR (or 'exit' to quit): ");
            String userInput = scanner.nextLine().trim();
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("\nExit...");
                break;
            }
            if (!validateInput(userInput)) {
                System.out.println("Invalid input. Try again (e.g. 192.168.1.10/24)");
                continue;
            }
            String[] parts = userInput.split("/");
            String ip = parts[0];
            String cidr = parts[1];
            int prefix = Integer.parseInt(cidr);

            SubnetInfo info = SubnetCalculator.calculate(ip, prefix);
            System.out.println("\n=== SUBNET INFO ===");
            System.out.println(info.toString());
            System.out.println("\n");
        }
        scanner.close();
    }

    private static boolean validateInput(String input) {
        if (input == null || input.isEmpty()) return false;

        String regex = "^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.){3}(25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)/(3[0-2]|[12]\\d|\\d)$";
        return input.matches(regex);
    }
}
