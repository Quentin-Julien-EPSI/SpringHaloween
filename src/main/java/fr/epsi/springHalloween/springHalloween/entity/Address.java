package fr.epsi.springHalloween.springHalloween.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "id_addresses")
    private List<Order> orders = new ArrayList<>();

    private String name;

    private String address;

    private String city;

    private String zipcode;

    private  String country;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_adresse")
    private User user;

}