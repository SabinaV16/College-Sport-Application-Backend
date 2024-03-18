package sabina.aa.backendfordb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Getter
@Table(name = "echipe_adverse")
public class EchipeAdverse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEchipaAdv;
    @NotBlank
    private String denumire;

    private String numeAntrenor;

    private String prenumeAntrenor;

    private String universitate;

    private String strada;

    private String judetSector;

    private String oras;

    private String sport;

}
