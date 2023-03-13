package fr.epsi.springHalloween.springHalloween.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "Panier")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Basket extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private float total_ht_price;

    private float total_ttc_price;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Basket.class)
    @JoinColumn(name = "user_id", updatable = false)
    @Fetch(FetchMode.JOIN)
    private User user;

    @ManyToMany
    @JoinTable(name = "baskets_services",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "services_id"))
    private Set<Service> services = new LinkedHashSet<>();

}
