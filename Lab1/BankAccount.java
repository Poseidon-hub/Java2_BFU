public class BankAccount {
    private final String owner;
    private final String accountNumber;
    private double balance;
    private static int accountsCount = 0;

    public BankAccount(String owner, String accountNumber) {
        this(owner, accountNumber, 0);
    }

    public BankAccount(String owner, String accountNumber, double initialBalance) {
        if (!Double.isFinite(initialBalance) || initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс должен быть конечным неотрицательным числом.");
        }
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        accountsCount++;
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public static int getAccountsCount() {
        return accountsCount;
    }

    public void deposit(double amount) {
        validateAmount(amount);
        if (!Double.isFinite(balance + amount)) {
            throw new IllegalArgumentException("Сумма пополнения слишком велика.");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        validateAmount(amount);
        if (amount > balance) {
            throw new IllegalArgumentException("Недостаточно средств на счёте.");
        }
        balance -= amount;
    }

    private static void validateAmount(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть конечным числом больше нуля.");
        }
    }
}
