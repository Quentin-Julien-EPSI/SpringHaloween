package fr.epsi.springHalloween.springHalloween.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Reduction")
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @Column (name = "reduc_price", nullable = true)
    private Float reduc_price;

    @Column (name = "reduc_percent", nullable = true)
    private Float reduc_percent;

    @Column (name = "max_uses", nullable = false)
    private Integer max_uses;
}