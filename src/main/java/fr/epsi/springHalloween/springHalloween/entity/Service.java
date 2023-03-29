package fr.epsi.springHalloween.springHalloween.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Service")
@Table(name = "service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Float price;

    private String photo;

    private String description;

    private Float rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_type_id")
    @Fetch(FetchMode.SELECT)
    @JsonIgnore
    private ServiceType serviceType;

    @ManyToMany
    @JoinTable(name = "service_enterprises",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "enterprises_id"))
    private List<Enterprise> enterprises = new ArrayList<>();

}
