package saverio.entities;
import java.util.List;

public class Order {
    private Integer id;
    private Customer customer;
    private List<Prodotti> prodotti;

    public Order(Integer id, Customer customer, List<Prodotti> prodotti) {
        this.id = id;
        this.customer = customer;
        this.prodotti = prodotti;
    }

    public Integer getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Prodotti> getProdotti() {
        return prodotti;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", prodotti=" + prodotti +
                '}';
    }
}