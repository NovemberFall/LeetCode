package _DesignPatterns.Bridge.PizzaOrder;

abstract class Pizza {
    protected String description;
    protected double cost;
    protected Toppings toppings;

    public Pizza(Toppings toppings) {
        this.toppings = toppings;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost + toppings.getCost();
    }

    public abstract void prepare();
}

interface Toppings {
    public String getDescription();
    public double getCost();
}

class CheeseToppings implements Toppings {
    public String getDescription() {
        return "Cheese Toppings";
    }

    public double getCost() {
        return 1.99;
    }
}

class PepperoniToppings implements Toppings {
    public String getDescription() {
        return "Pepperoni Toppings";
    }

    public double getCost() {
        return 2.99;
    }
}


// more toppings classes with different costs

class CheesePizza extends Pizza {
    public CheesePizza(Toppings toppings) {
        super(toppings);
        description = "Cheese Pizza";
        cost = 8.99;
    }

    public void prepare() {
        System.out.println("Preparing cheese pizza with " + toppings.getDescription() + "...");
    }
}

class PepperoniPizza extends Pizza {
    public PepperoniPizza(Toppings toppings) {
        super(toppings);
        description = "Pepperoni Pizza";
        cost = 10.99;
    }

    public void prepare() {
        System.out.println("Preparing pepperoni pizza with " + toppings.getDescription() + "...");
    }
}

// more pizza classes with different toppings

class Main {
    public static void main(String[] args) {
        Toppings cheeseToppings = new CheeseToppings();
        Toppings pepperoniToppings = new PepperoniToppings();

        Pizza cheesePizza = new CheesePizza(cheeseToppings);
        Pizza pepperoniPizza = new PepperoniPizza(pepperoniToppings);

        System.out.println(cheesePizza.getDescription() +
                " with " + cheeseToppings.getDescription() +
                " costs $" + cheesePizza.getCost());
        System.out.println(pepperoniPizza.getDescription() +
                " with " + pepperoniToppings.getDescription() +
                " costs $" + pepperoniPizza.getCost());
    }
}

