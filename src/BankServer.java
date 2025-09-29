public class BankServer {
    private int balance = 5000;

    public BankServer(int balance) {
        this.balance = balance;
    }

    public boolean verifyPIN(String pin) {
        return "1234".equals(pin);
    }

    public boolean checkFunds(int amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
