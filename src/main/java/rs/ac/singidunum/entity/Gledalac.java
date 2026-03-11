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
public class Gledalac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gledalac_id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    @JsonIgnore
    private LocalDateTime deletedAt;

}
