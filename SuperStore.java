// SuperStore Exercise: Access Modifiers & Object Modeling Focus

// TODO: Define a class called Product with:
class Product {
    // - A protected String field called name
    protected String name;
    // - A protected double field called price
    protected double price;
    // - A private final int productId
    private final int productId;
    // - A public static int nextId to help generate unique IDs
    public static int nextId = 0;

    // - A constructor that sets name, price, and assigns a unique ID
    /**
     * Making a constructor yeauh
     * @param name for the name of the product
     * @param price for the price of said thing to buy
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.productId = nextId++;
    }

    // - Public getters for all fields
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getProductId() {
        return productId;
    }

    // - Override toString() to return formatted product details
    @Override
    public String toString() {
        return "Product name: " + name + " Product price: " + price + " Product ID: " + productId;
    }

    // - Override equals(Object o) to compare name and productId
    @Override
    public boolean equals(Object o) {
        if (o instanceof Product) {
            Product other = (Product) o;
            return this.name.equals(other.name) && this.productId == other.productId;
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
     * @param brand for brand type, has to be string
     * @param hasBattery a boolean t or f
     */
    public Electronics(String name, double price, String brand, boolean hasBattery) {
        super(name, price);
        this.brand = brand;
        this.hasBattery = hasBattery;
    }

    // - Override toString() to include brand and battery status
    @Override
    public String toString() {
        return super.toString() + " Brand: " + brand + " Has battery: " + hasBattery;
    }

    public final void warrantyInfo() {
        System.out.println("1-year warranty included.");
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
     * @param weight - double for how big in kg, so in double
     * @param isPerishable - t or f
     */
    public Grocery(String name, double price, double weight, boolean isPerishable) {
        super(name, price);
        this.weight = weight;
        this.isPerishable = isPerishable;
    }

    // - Override toString() to include weight and perishability
    @Override
    public String toString() {
        return super.toString() + " Weight: " + weight + " Is perishable: " + isPerishable;
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
     * @param minAge - int for minimum age kid can play w toy
     */
    public Toy(String name, double price, int minAge) {
        super(name, price);
        this.minAge = minAge;
    }

    // - Override toString() to include minAge
    @Override
    public String toString() {
        return super.toString() + " Minimum Age: " + minAge;
    }
}

// TODO: Define class SuperStoreTest with a main method
class SuperStoreTest {
    public static void main(String[] args) {
        // - Create at least one instance of each subclass
        Product product = new Product("Spoon", 1.09);
        Electronics gamingThing = new Electronics("3DS", 199, "Nintendo", true);
        Grocery foods = new Grocery("Energy Drink", 2.59, 1, true);
        Toy plastic = new Toy("Lego", 849.99, 4);

        // - Store them in a Product[] array
        Product[] products = {product, gamingThing, foods, plastic};

        // - Loop through and print each item
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }

        // - Call equals() to compare two products with the same ID and name
        Product product2 = new Product("Spoon", 1.09);
        System.out.println("Comparison: " + product.equals(product2));
        System.out.println("Comparison: " + product.equals(product));
        
        //This is for coupoun class yuh (Q3 at bottom) to apply it
        //Making gamingThing on a discount here cause nintendo wont make that happen in real life :(
        //"At least I can cut the price in half in vs code" - What I said while typing this
        double discountVar = Coupon.discountRate;
        gamingThing.price -= gamingThing.price * discountVar;
        System.out.println(gamingThing);

        gamingThing.warrantyInfo();
    }
}

// Additional TODOs:
// 1. Try to extend Toy — what happens and why?
// It cant extend. This is because for final, in classes, means its the final product of the class.
// You are restricted, and thus unable to extend that class

// 2. Make a class Coupon with a final discountRate and apply it to a Product
class Coupon {
    final static double discountRate = .45;

    public static void applyDiscount(Product product) {
        product.price -= product.price * discountRate;
    }
}

// 3. Add a method to Electronics called warrantyInfo() and mark it final
//ok done in electronics class on line uhhh 83!

// 4. Use access modifiers appropriately and explain your choices in comments
//ok, I mainly used public cause it was the least restrictive,
// and in them I use a jumble of private and protected cause I dont want other classes outside the ones I made access my variables
//UNLESS i soecifically say in the initalization to access them
//For example, productId needed to be final cause it doesnt change
//But uhhhh something like price its protected, not changed by outside forces but by company (or when tariffs hit and the switch 2 is 450 dollars why)
//i think i answered this well huzzah!
