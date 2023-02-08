package fr.epsi.springHalloween.springHalloween.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column (name = "prix_ht", nullable = false)
    private float total_ht_price;

    @Column (name = "prix_ttc", nullable = false)
    private float total_ttc_price;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(name = "baskets_services",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "services_id"))
    private Set<Service> services = new LinkedHashSet<>();

}
