package fr.epsi.springHalloween.springHalloween.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder @Entity(name = "Entreprise")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor

public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String siret;

    private String creation_date;

    @ManyToMany(mappedBy = "enterprises")
    private Set<Service> services = new LinkedHashSet<>();

    @OneToOne()
    //@JoinColumn(name = "owner_id")
    private User owner;

    @OneToOne
    @JoinColumn
    //@JoinColumn(name = "address_id")
    private Address address;
}
