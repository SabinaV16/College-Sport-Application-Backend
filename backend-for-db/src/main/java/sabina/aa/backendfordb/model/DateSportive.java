package sabina.aa.backendfordb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "date_sportive")
@AllArgsConstructor
@NoArgsConstructor
public class DateSportive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudent;
    private Integer idEchipa;
    private LocalDate dataInscriere;

}
