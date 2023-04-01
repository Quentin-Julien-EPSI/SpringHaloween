package fr.epsi.springHalloween.springHalloween.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "address_id")
    @Fetch(FetchMode.SELECT)
    private List<Order> orders = new ArrayList<>();

    private String name;

    private String address;

    private String city;

    private String zipcode;

    private String country;
}