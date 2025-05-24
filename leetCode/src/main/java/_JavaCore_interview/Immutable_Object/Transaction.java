package _JavaCore_interview.Immutable_Object;

import java.time.LocalDate;

public final class Transaction {
    private final String id;
    private final LocalDate date;
    private final double amount;
    private final String description;

    private Transaction(String id, LocalDate date, double amount, String description) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public static Transaction create(String id, LocalDate date, double amount, String description) {
        return new Transaction(id, date, amount, description);
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        Transaction t = Transaction.create(
                "123",
                LocalDate.now(),
                100.0,
                "Payment for services rendered");
    }
}

