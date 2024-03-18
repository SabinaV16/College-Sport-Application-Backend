package sabina.aa.backendfordb.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AntrenoriDto {
    private String nume;
    private String prenume;
    private double salariu;
    private Integer nrStudenti;
}
