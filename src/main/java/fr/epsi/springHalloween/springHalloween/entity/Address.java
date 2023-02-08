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

@Table(name = "adress")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToMany(mappedBy = "id_addresses")
    private List<Order> orders = new ArrayList<>();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "adress", nullable = false)
    private String adress;

    @Column (name = "city", nullable = false)
    private String city;

    @Column (name = "zipcode", nullable = false)
    private String zipcode;

    @Column (name = "country", nullable = false)
    private  String country;
}