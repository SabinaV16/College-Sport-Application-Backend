package sabina.aa.backendfordb.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sport")
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSport;

    private Integer idCoordonator;

    private String denumire;
}
