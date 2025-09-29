public interface State {
    void insertCard();

    void ejectCard();

    void enterPIN(String pin);

    void chooseTransaction(String type, int amount);

    void dispenseCash(int amount);
}
