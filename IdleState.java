public class IdleState implements State {
    private ATM atm;

    public IdleState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card inserted.");
        atm.setState(new CardInsertedState(atm));
    }

    @Override
    public void ejectCard() {
        System.out.println("No card to eject.");
    }

    @Override
    public void enterPIN(String pin) {
        System.out.println("Insert card first.");
    }

    @Override
    public void chooseTransaction(String type, int amount) {
        System.out.println("Insert card first.");
    }

    @Override
    public void dispenseCash(int amount) {
        System.out.println("Insert card first.");
    }
}
