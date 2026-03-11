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
public class Termin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "termin_id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime datum;

    @Column(nullable = false)
    private String utakmica;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    @JsonIgnore
    private LocalDateTime deletedAt;
}
