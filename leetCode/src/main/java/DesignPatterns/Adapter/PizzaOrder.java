package DesignPatterns.Adapter;

interface PizzaOrder {
    public String getPizzaType();

    public int getQuantity();
}

class WebsiteOrder implements PizzaOrder {
    private String pizzaType;
    private int quantity;

    public WebsiteOrder(String pizzaType, int quantity) {
        this.pizzaType = pizzaType;
        this.quantity = quantity;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public int getQuantity() {
        return quantity;
    }
}

class MobileOrder {
    private String pizza;
    private int count;

    public MobileOrder(String pizza, int count) {
        this.pizza = pizza;
        this.count = count;
    }

    public String getPizza() {
        return pizza;
    }

    public int getCount() {
        return count;
    }
}

class MobileOrderAdapter implements PizzaOrder {
    private MobileOrder mobileOrder;

    public MobileOrderAdapter(MobileOrder mobileOrder) {
        this.mobileOrder = mobileOrder;
    }

    public String getPizzaType() {
        return mobileOrder.getPizza();
    }

    public int getQuantity() {
        return mobileOrder.getCount();
    }
}

class PizzaOrderingSystem {
    public void processOrder(PizzaOrder order) {
        System.out.println("Processing order for " +
                order.getQuantity() + " " +
                order.getPizzaType() + " pizzas...");
    }
}

class Main {
    public static void main(String[] args) {
        PizzaOrderingSystem system = new PizzaOrderingSystem();

        PizzaOrder websiteOrder = new WebsiteOrder("Pepperoni", 2);
        system.processOrder(websiteOrder);

        MobileOrder mobileOrder = new MobileOrder("Hawaii", 3);
        PizzaOrder mobileOrderAdapter = new MobileOrderAdapter(mobileOrder);
        system.processOrder(mobileOrderAdapter);

        // Processing order for 2 Pepperoni pizzas...
        // Processing order for 3 Hawaii pizzas...
    }
}


