package saverio;

import saverio.entities.Customer;
import saverio.entities.Order;
import saverio.entities.Prodotti;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        // PRODOTTI
        List<Prodotti> libreria = new ArrayList<>();
        libreria.add(new Prodotti(1, "Il Signore degli Anelli", "Books", 120.0));
        libreria.add(new Prodotti(2, "Ant-man", "Action", 60.0));
        libreria.add(new Prodotti(3, "Hulk", "Action", 120.0));
        libreria.add(new Prodotti(4, "Spiderman", "Action", 150.0));
        libreria.add(new Prodotti(5, "HarryPotter", "Books", 110.0));

        // CLIENTI
        Customer cliente1 = new Customer(1, "Saverio Casabianca", 1);
        Customer cliente2 = new Customer(2, "Brandon Casabianca", 2);

        // ORDINI
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, cliente1, List.of(libreria.get(0), libreria.get(1))));
        orders.add(new Order(2, cliente1, List.of(libreria.get(2))));
        orders.add(new Order(3, cliente2, List.of(libreria.get(3))));
        orders.add(new Order(4, cliente2, List.of(libreria.get(4))));

        // ESERCIZIO 1
        System.out.println("\nORDINI RAGGRUPPATI\n");

        Map<Customer, List<Order>> ordersByCustomer =
                orders.stream()
                        .collect(Collectors.groupingBy(Order::getCustomer));

        ordersByCustomer.forEach((customer, ordini) -> {
            System.out.println("Cliente " + customer.getName());

            ordini.forEach(order ->
                    System.out.println("Order ID " + order.getId()));
        });

        // ESERCIZIO 3

        System.out.println("PIU COSTOSO");

        Prodotti maxProduct = libreria.stream()
                .max(java.util.Comparator.comparing(Prodotti::getPrice))
                .get();
        System.out.println(maxProduct);

        // ESERCIZIO 4
        System.out.println("MEDIA IMPORTI");

        double media = orders.stream()
                .flatMap(order -> order.getProdotti().stream())
                .mapToDouble(Prodotti::getPrice)
                .average()
                .getAsDouble();

        System.out.println("Media: " + media);
    }
}