package sabina.aa.backendfordb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Getter
@Entity
@Table(name = "antrenori")
public class Antrenori {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAntrenor;


    private Integer idCoordonator;


    @NotBlank
    private String nume;
    @NotBlank
    private String prenume;

    @Column(length = 13)
    private String cnp;

    private String strada;

    private String judetSector;

    private String oras;

    @Column(length = 10)
    private String numarTelefon;

    private LocalDate dataNasterii;

    @Column(length = 1)
    private String sex;

    private LocalDate dataAngajarii;

    private Double salariu;
}
