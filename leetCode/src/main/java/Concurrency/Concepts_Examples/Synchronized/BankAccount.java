package Concurrency.Concepts_Examples.Synchronized;

class BankAccount {
    private int balance;
    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
class User implements Runnable {
    private BankAccount account;
    private String name;
    public User(BankAccount account, String name) {
        this.account = account;
        this.name = name;
    }

    public void run() {
        // perform transactions
        account.deposit(100);
        account.withdraw(50);
    }
}
class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(1000);
        Thread user1 = new Thread(new User(account, "User1"));
        Thread user2 = new Thread(new User(account, "User2"));

        user1.start();
        user2.start();

        user1.join();
        user2.join();

        System.out.println("Final balance: " + account.getBalance());
    }
}

