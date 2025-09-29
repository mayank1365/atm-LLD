## ATM System 

```mermaid
classDiagram
    class ATM {
        - balance : int
        - state : State
        + ATM(initialBalance:int)
        + setState(state: State)
        + getBalance() int
        + insertCard()
        + ejectCard()
        + enterPIN(pin:String)
        + chooseTransaction(type:String, amount:int)
        + dispenseCash(amount:int)
    }

    class State {
        <<interface>>
        + insertCard()
        + ejectCard()
        + enterPIN(pin:String)
        + chooseTransaction(type:String, amount:int)
        + dispenseCash(amount:int)
    }

    class IdleState {
        - atm : ATM
        + insertCard()
        + ejectCard()
        + enterPIN(pin:String)
        + chooseTransaction(type:String, amount:int)
        + dispenseCash(amount:int)
    }

    class CardInsertedState {
        - atm : ATM
        + insertCard()
        + ejectCard()
        + enterPIN(pin:String)
        + chooseTransaction(type:String, amount:int)
        + dispenseCash(amount:int)
    }

    class AuthenticatedState {
        - atm : ATM
        + insertCard()
        + ejectCard()
        + enterPIN(pin:String)
        + chooseTransaction(type:String, amount:int)
        + dispenseCash(amount:int)
    }

    class ProcessingState {
        - atm : ATM
        - type : String
        - amount : int
        + insertCard()
        + ejectCard()
        + enterPIN(pin:String)
        + chooseTransaction(type:String, amount:int)
        + dispenseCash(amount:int)
    }

    class BankServer {
        - balance : int
        + verifyPIN(pin:String) bool
        + checkFunds(amount:int) bool
    }

    ATM --> State : uses
    State <|.. IdleState
    State <|.. CardInsertedState
    State <|.. AuthenticatedState
    State <|.. ProcessingState
    ATM --> BankServer : communicates
