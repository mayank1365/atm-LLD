import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(5000);
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to the ATM ===");

        atm.insertCard();

        System.out.print("Enter PIN: "); // pin = 1234
        String pin = sc.nextLine();
        atm.enterPIN(pin);

        System.out.print("Enter transaction type (withdrawl): ");
        String type = sc.nextLine();

        System.out.print("Enter amount: ");
        int amount = sc.nextInt();
        atm.chooseTransaction(type, amount);

        sc.close();
    }
}
