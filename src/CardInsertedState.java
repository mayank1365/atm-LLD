package src;

public class CardInsertedState implements State {
    private ATM atm;

    public CardInsertedState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card already inserted.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected.");
        atm.setState(new IdleState(atm));
    }

    @Override
    public void enterPIN(String pin) {
        if (atm.getBankServer().verifyPIN(pin)) {
            System.out.println("PIN verified.");
            atm.setState(new AuthenticatedState(atm));
        } else {
            System.out.println("Incorrect PIN. Card ejected.");
            atm.setState(new IdleState(atm));
        }
    }

    @Override
    public void chooseTransaction(String type, int amount) {
        System.out.println("Enter PIN first.");
    }

    @Override
    public void dispenseCash(int amount) {
        System.out.println("Enter PIN first.");
    }
}
