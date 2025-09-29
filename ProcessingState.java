public class ProcessingState implements State {
    private ATM atm;
    private String type;
    private int amount;

    public ProcessingState(ATM atm, String type, int amount) {
        this.atm = atm;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public void insertCard() {
        System.out.println("Transaction in progress.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Transaction cancelled. Card ejected.");
        atm.setState(new IdleState(atm));
    }

    @Override
    public void enterPIN(String pin) {
        System.out.println("Already authenticated.");
    }

    @Override
    public void chooseTransaction(String type, int amount) {
        if (type.equalsIgnoreCase("withdrawl")) {
            if (atm.getBankServer().checkFunds(amount)) {
                atm.dispenseCash(amount);
            } else {
                System.out.println("Insufficient funds.");
                atm.setState(new AuthenticatedState(atm));
            }
        } else {
            System.out.println("Unsupported transaction type.");
            atm.setState(new AuthenticatedState(atm));
        }
    }

    @Override
    public void dispenseCash(int amount) {
        atm.setBalance(atm.getBalance() - amount);
        System.out.println("Dispensed: " + amount);
        System.out.println("Remaining ATM balance: " + atm.getBalance());
        System.out.println("Card ejected.");
        atm.setState(new IdleState(atm));
    }
}
