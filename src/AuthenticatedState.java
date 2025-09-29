public class AuthenticatedState implements State {
    private ATM atm;

    public AuthenticatedState(ATM atm) {
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
        System.out.println("Already authenticated.");
    }

    @Override
    public void chooseTransaction(String type, int amount) {
        atm.setState(new ProcessingState(atm, type, amount));
        atm.chooseTransaction(type, amount);
    }

    @Override
    public void dispenseCash(int amount) {
        System.out.println("Select transaction first.");
    }
}
