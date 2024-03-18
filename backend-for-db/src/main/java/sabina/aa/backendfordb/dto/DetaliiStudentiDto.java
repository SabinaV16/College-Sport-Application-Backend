package sabina.aa.backendfordb.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetaliiStudentiDto {
    private String nume;
    private String prenume;
    private int an;


}
