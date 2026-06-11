package saverio.entities;

public class Customer {
    private Integer id;
    private String name;
    private Integer tier;

    public Customer(Integer id, String name, Integer tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        Customer c = (Customer) o;
        return id.equals(c.id);
    }

    @Override
    public int hashCode() {
        return id;
    }
}