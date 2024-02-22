package dto;


public class Customer {
    private final String id;
    private final String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }



}
