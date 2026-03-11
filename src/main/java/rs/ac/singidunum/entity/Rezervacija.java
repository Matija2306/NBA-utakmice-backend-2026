package rs.ac.singidunum.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Rezervacija {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rezervacija_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "gledalac_id", nullable = false)
    private Gledalac gledalac;

    @ManyToOne(optional = false)
    @JoinColumn(name = "termin_id", nullable = false)
    private Termin termin;

    @Column(nullable = false)
    private Integer brojKarata;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    @JsonIgnore
    private LocalDateTime deletedAt;

}
