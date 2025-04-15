// SuperStore Exercise: Access Modifiers & Object Modeling Focus

// TODO: Define a class called Product with:
class Product {
    // - A protected String field called name
    protected String name;
    // - A protected double field called price
    protected double price;
    // - A private final int productId
    private int productId;

    // - A public static int nextId to help generate unique IDs
    public static int nextId;

    // - A constructor that sets name, price, and assigns a unique ID
    /**
     * Making a constructor yeauh
     * @param name for the name of the product
     * @param price for the price of said thing to buy
     */
    public constructorForProduct(String name, double price, int nextId) {
        this.name = name;
        this.price = price;
        //THIS MIGHT BE WRONG... BUT it might work too cause it says ASSIGNS in the comment
        this.productId = nextId;
    }

    // - Public getters for all fields
    public string getName() {
        return name;
    }

    public string getPrice() {
        return price;
    }

    public string getProductId() {
        return nextId;
    }

    // - Override toString() to return formatted product details
    @Override
    public String toString() {
        return "Product name: " + name " Product price: " + price;
    }

    // - Override equals(Object o) to compare name and productId
    @Override
    public boolean equals(Object o) {
        if (o instanceof productId) {
            productId other = (productId) o;
            return this.name.equals(other.name);
        }
        return false;
    }
}

// TODO: Define a subclass Electronics that extends Product
class Electronics extends Product {
    // - Add a private String field called brand
    private String brand;
    // - Add a private boolean field called hasBattery
    private boolean hasBattery;

    // - Constructor takes all fields and uses super for shared ones
    /**
     * Making a constructor yeauh
     * @param name for name of product, super
     * @param price for price of product
     * @param nextId whats its specific id to find it idk
     * @param brand for brand type, has to be string
     * @param hasBattery a boolean t or f
     */
    public constructorForElectronics(String name, double price, int nextId, String brand, boolean hasBattery) {
       super(name, price, nextId);
       this.brand = brand;
       this.hasBattery = hasBattery;

    }

    // - Override toString() to include brand and battery status
    @Override
    public String toString() {
        return "Brand: " + brand " Has battery: " + hasBattery;
    }
}


// TODO: Define a subclass Grocery that extends Product
class Grocery extends Product {
    // - Add a private double field called weight (in kg)
    private double weight;
    // - Add a private boolean field called isPerishable
    private boolean isPerishable;


    // - Constructor takes all fields and uses super for shared ones
    /**
     * ANOTHER CONSTRUCTOR
     * @param name - super method for name
     * @param price - super method for cost
     * @param nextId - super method for nextId given
     * @param weight - double for how big in kg, so in double
     * @param isPerishable - t or f
     */
    public constructorForGrocery (String name, double price, int nextId, double weight, boolean isPerishable) {
        super(name, price, nextId);
        this.weight = weight;
        this.isPerishable = isPerishable;

    }
    // - Override toString() to include weight and perishability
    @Override
    public String toString() {
        return "Weight: " + weight + " Is perished: " + isPerishable;
    }

}



// TODO: Define a final class Toy that extends Product
final class Toy extends Product {
    // - Add a private int field called minAge
    private int minAge;

    // - Constructor takes all fields and uses super for shared ones
    /**
     * ANOTHER CONSTRUCTOR
     * @param name - super method for name
     * @param price - super method for cost
     * @param nextId - super method for nextId given
     * @param minAge - int for minimum age kid can play w toy
     */
    public constructorForGrocery(String name, double price, int nextId, int minAge) {
        super(name, price, nextId);
        this.minAge;

    // - Override toString() to include minAge
        @Override
        public String toString() {
            return "minAge: " + minAge;
        }

}


// TODO: Define class SuperStoreTest with a main method
class SuperStoreTest {
    public static void main(String[] args) {
        // - Create at least one instance of each subclass
        //product bookInstanceOne = new Book();

        Product product = new Product("Spoon",1.09,0879);
        Electronics gamingThing = Electronics("3DS", 199, 6910, "Nintendo", true);
        Grocery foods = new Grocery("Energy Drink",2.59,0459,1, true);
        Toy plastic = new Toy("Lego",849.99,75192,4); //hehe actual price of lego set btw


        // - Store them in a Product[] array
        Product[] products = {product, gamingThing, foods, plastic}
        // - Loop through and print each item
        for (int i = 0; i < products.length;i++) {
            System.out.println(products[i]);
        }

        // - Call equals() to compare two products with the same ID and name
        System.out.println("Comparison: " + .equals());
    }
}

// Additional TODOs:
// 1. Try to extend Toy — what happens and why?
// It cant extend. This is because for final, in classes, means its the final product of the class.
// You are restricted, and thus unable to extend that class

// 2. Make a class Coupon with a final discountRate and apply it to a Product

//class Coupon

// 3. Add a method to Electronics called warrantyInfo() and mark it final

// 4. Use access modifiers appropriately and explain your choices in comments
