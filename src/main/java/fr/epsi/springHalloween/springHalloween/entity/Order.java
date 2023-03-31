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
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private Boolean valid;

     @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "address_id", unique = true)
     private Address address;

     @ManyToOne(optional = false)
     @JoinColumn(name = "product_id", nullable = false)
     private Product product;

 }