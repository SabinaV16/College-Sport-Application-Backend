package sabina.aa.backendfordb.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetaliiEchipaDto {
    private String nume;
    private String prenume;
    private String numeEchipa;
}
