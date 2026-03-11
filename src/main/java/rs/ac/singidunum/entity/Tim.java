package rs.ac.singidunum.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Tim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tim_id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String naziv;

    @Column(nullable = false)
    private String skracenica;

    @Column(name = "logo_url", nullable = false)
    private String logoUrl;

}
