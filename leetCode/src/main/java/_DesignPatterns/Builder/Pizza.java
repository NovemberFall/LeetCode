package _DesignPatterns.Builder;

class Pizza {
    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;
    // add more toppings as needed

    public Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
        // set other toppings as needed
    }

    public String getSize() {
        return size;
    }

    public boolean hasCheese() {
        return cheese;
    }

    public boolean hasPepperoni() {
        return pepperoni;
    }

    public boolean hasMushrooms() {
        return mushrooms;
    }

    // add getters for other toppings as needed

    static class PizzaBuilder {
        private String size;
        private boolean cheese;
        private boolean pepperoni;
        private boolean mushrooms;
        // add more toppings as needed

        public PizzaBuilder(String size) {
            this.size = size;
        }

        public PizzaBuilder cheese(boolean value) {
            cheese = value;
            return this;
        }

        public PizzaBuilder pepperoni(boolean value) {
            pepperoni = value;
            return this;
        }

        public PizzaBuilder mushrooms(boolean value) {
            mushrooms = value;
            return this;
        }

        // add builder methods for other toppings as needed

        public Pizza build() {
            return new Pizza(this);
        }
    }

    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder("large")
                .cheese(true)
                .pepperoni(true)
                .mushrooms(true)
                .build();
    }
}

