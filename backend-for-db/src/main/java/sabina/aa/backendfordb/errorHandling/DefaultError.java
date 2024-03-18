package sabina.aa.backendfordb.errorHandling;

import lombok.AllArgsConstructor;

public record DefaultError(int status, String statusCode) {
}
