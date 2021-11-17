package src;

/**
 *
 * @author Francisco Javier Araujo Mendoza
 */
public class Account {
    
    private double balance;
    
    public Account(double balance) {
        this.balance = balance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public boolean withdraw(double amount) {
        if (amount < 0) return false;               //Si es negativo, rechazar la operación
        if (balance - amount < -500) return false;  //Si se sobrepasa el límite, rechazar
        else {
            balance -= amount;
            return true;
        }
    }
    
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount < 0) throw new IllegalArgumentException("Amount must be a positive number.");
        else balance += amount;
    }
    
}
