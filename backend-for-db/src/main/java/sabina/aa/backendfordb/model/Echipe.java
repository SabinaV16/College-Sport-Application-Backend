package sabina.aa.backendfordb.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "echipe")
public class Echipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEchipa;
    private Integer idAntrenor;
    private String denumire;


}
