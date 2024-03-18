package sabina.aa.backendfordb.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "meci")
public class Meci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer idEchipa;

    private Integer idEchipaAdv;

    private Integer puncteNoi;

    private Integer puncteAdv;

    private String locatie;

}
