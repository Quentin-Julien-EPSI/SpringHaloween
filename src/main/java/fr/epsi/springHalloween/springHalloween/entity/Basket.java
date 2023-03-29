package fr.epsi.springHalloween.springHalloween.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Basket  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private float total_ht_price;

    private float total_ttc_price;

    @OneToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @ManyToMany
    @JoinTable(name = "basket_products",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    private List<Product> products;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Basket.class)
    @JoinColumn(name = "users_id", updatable = false)
    @Fetch(FetchMode.JOIN)
    private User user;

    @ManyToMany
    @JoinTable(name = "baskets_services",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "services_id"))
    private List<Service> services = new LinkedList<>();

}
