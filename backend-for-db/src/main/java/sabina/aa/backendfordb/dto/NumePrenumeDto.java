package sabina.aa.backendfordb.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NumePrenumeDto {
    private String nume;
    private String prenume;
}
