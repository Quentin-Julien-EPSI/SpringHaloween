package fr.epsi.springHalloween.springHalloween.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

 @AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "commande")
public class Order extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Order.class)
    @JoinColumn(name = "users_id")
    private User users;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "order_id_adress",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_adress_id", referencedColumnName = "id"))
    private List<Address> id_addresses = new ArrayList<>();

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @Column (name = "valid", nullable = false)
    private Boolean valid;
}