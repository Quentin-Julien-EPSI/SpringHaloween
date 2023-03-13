package fr.epsi.springHalloween.springHalloween.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Produit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Long quantity;

    private Float price;

    private String photo;

    private String description;

    private Float rating;

    @ManyToOne
    @JoinColumn(name = "enterprises_id")
    private Enterprise enterprises;
}
