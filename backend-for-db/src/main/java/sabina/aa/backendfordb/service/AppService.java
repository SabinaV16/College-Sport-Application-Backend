package sabina.aa.backendfordb.service;

import sabina.aa.backendfordb.dto.*;
import sabina.aa.backendfordb.model.Antrenori;
import sabina.aa.backendfordb.model.DateStudenti;
import sabina.aa.backendfordb.model.EchipeAdverse;

import java.time.LocalDate;
import java.util.List;

public interface AppService {
    void adaugaDateStudenti (DateStudenti student);
    void updateSalariu (Antrenori antrenori);
    void updateNumeEchipa(EchipeDto nume);
    void deleteEchipeAdv (EchipeAdverse echipe);
    void deleteAntrenori (Antrenori antrenori);
    void adaugaEchipeAdverse (EchipeAdverse echipeAdverse);
    List<NumePrenumeDto> getNumePrenumeStudentibyEchipa(String echipa);

    List<DetaliiEchipaDto> getAntrenoriAndEchipeBySport(String Sport);
    List<DetaliiEchipaDto> getStudentiAndEchipeByDataInscriere(LocalDate dataInscriere);
    List<DetaliiStudentiDto> getStudentibyAn();
    List<CastigatoriDto> getEchipeCastigatoare();
    List<NumePrenumeDto> getAntrenoriByStudenti();
    List<NumePrenumeDto> getAntrenorByData();
    List<NumePrenumeDto> getAntrenoriByLocaatie();
    List<AntrenoriDto> getAntrenoriSalariuStudenti();
    List<NumePrenumeDto> getStudentiCastigatoribyAn();


}
