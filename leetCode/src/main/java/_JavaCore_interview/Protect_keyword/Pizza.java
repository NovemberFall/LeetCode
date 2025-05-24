package _JavaCore_interview.Protect_keyword;

class Pizza {
    protected String toppings;
    protected int size;
    protected boolean isDelivery;

    public Pizza(String toppings, int size, boolean isDelivery) {
        this.toppings = toppings;
        this.size = size;
        this.isDelivery = isDelivery;
    }

    protected void order() {
        System.out.println("Ordering a " + size + " inch pizza with " + toppings + " toppings.");
        if (isDelivery) {
            System.out.println("Delivery requested.");
        } else {
            System.out.println("Pickup requested.");
        }
    }
}

class HawaiiPizza extends Pizza {
    public HawaiiPizza(int size, boolean isDelivery) {
        super("Tomato sauce, bacaon, and pineapple", size, isDelivery);
    }
}

class PizzaOrder {
    public static void main(String[] args) {
        HawaiiPizza pizza = new HawaiiPizza(12, true);
        pizza.order();
    }
}

