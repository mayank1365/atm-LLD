package src;

public class ATM {
    private int balance;
    private State state;
    private BankServer bankServer;

    public ATM(int initialBalance) {
        this.balance = initialBalance;
        this.bankServer = new BankServer(initialBalance);
        this.state = new IdleState(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public BankServer getBankServer() {
        return bankServer;
    }

    public void insertCard() {
        state.insertCard();
    }

    public void ejectCard() {
        state.ejectCard();
    }

    public void enterPIN(String pin) {
        state.enterPIN(pin);
    }

    public void chooseTransaction(String type, int amount) {
        state.chooseTransaction(type, amount);
    }

    public void dispenseCash(int amount) {
        state.dispenseCash(amount);
    }
}
