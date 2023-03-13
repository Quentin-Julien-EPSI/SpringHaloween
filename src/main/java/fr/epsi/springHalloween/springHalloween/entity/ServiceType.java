package fr.epsi.springHalloween.springHalloween.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Type_Service")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
