package sabina.aa.backendfordb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "date_studenti")
@AllArgsConstructor
@NoArgsConstructor
public class DateStudenti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudent;

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

    private String facultate;

    @Column(length = 3)
    private String grupa;

    @Column(length = 2)
    private String serie;

    private Integer an;

    private String domeniu;


}
