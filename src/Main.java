public class Main {
    public static class BankAccount {
        protected String accountNumber;
        private double balance;

        public BankAccount(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public void deposit(double amount) {
            balance += amount;
            System.out.println("$" + amount + " deposited into account " + accountNumber);
        }

        public void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("$" + amount + " withdrawn from account " + accountNumber);
            } else {
                System.out.println("Insufficient balance in account " + accountNumber);
            }
        }

        public double getBalance() {
            return balance;
        }
    }

    public static class SavingsAccount extends BankAccount {
        private static final double MIN_BALANCE = 100;

        public SavingsAccount(String accountNumber, double balance) {
            super(accountNumber, balance);
        }

        @Override
        public void withdraw(double amount) {
            if (getBalance() - amount >= MIN_BALANCE) {
                super.withdraw(amount);
            } else {
                System.out.println("Withdrawal failed: Minimum balance requirement not met for account " + accountNumber);
            }
        }
    }

    public static void main(String[] args) {
        BankAccount BA1234 = new BankAccount("BA1234", 20000);
        SavingsAccount SA1234 = new SavingsAccount("SA1234", 100000);
        SavingsAccount SA1000 = new SavingsAccount("SA1000", 25000);

        BA1234.deposit(20000);
        BA1234.withdraw(15000);

        SA1234.withdraw(5000);
        SA1000.withdraw(10000);
    }
}
