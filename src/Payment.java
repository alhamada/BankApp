public class Payment {
    private int id ;
    private String category;
    private double amount;
    private int month;
    private int year;


    public Payment(Integer id, String category, double amount, int month, int year) {
        this.id = id;
        this.category = category;
        this.amount = amount;
        this.month = month;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "The biggest payment is: " +
                "ID :" + id +
                "[ " + amount  +
                "€ ,'" + category+'\'' +
                ", " + month +
                ", " + year +
                ']';
    }
}
