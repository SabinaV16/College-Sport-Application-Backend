package sabina.aa.backendfordb.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CastigatoriDto {

    private String denumire;
    private int puncte;

}
