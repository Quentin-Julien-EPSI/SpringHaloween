package fr.epsi.springHalloween.springHalloween.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Entity(name = "adresse")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "address_id")
    @Fetch(FetchMode.SELECT)
    private List<Order> orders = new ArrayList<>();

    private String name;

    private String address;

    private String city;

    private String zipcode;

    private  String country;


    @ManyToMany
    @JoinTable(name = "address_users",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private Set<User> users = new LinkedHashSet<>();

}