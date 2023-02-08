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
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private String siret;

    @Column (nullable = true)
    private String creation_date;

    @ManyToMany(mappedBy = "enterprises")
    private Set<Service> services = new LinkedHashSet<>();

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;
}
