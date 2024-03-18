package sabina.aa.backendfordb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sabina.aa.backendfordb.dto.*;
import sabina.aa.backendfordb.model.Antrenori;
import sabina.aa.backendfordb.model.DateStudenti;
import sabina.aa.backendfordb.model.EchipeAdverse;
import sabina.aa.backendfordb.repository.AntrenoriRepository;
import sabina.aa.backendfordb.repository.DateStudentiRepository;
import sabina.aa.backendfordb.repository.EchipeAdverseRepository;
import sabina.aa.backendfordb.repository.EchipeRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {

    private final DateStudentiRepository studentPRepository;
    private final AntrenoriRepository antrenorRepository;
    private final EchipeAdverseRepository echipeAdverseRepository;
    private final EchipeRepository echipeRepository;

    @Override
    public void deleteEchipeAdv(EchipeAdverse echipe) {
        echipeAdverseRepository.deleteEchipaAdversaByNume(echipe.getDenumire());
    }

    @Override
    public void deleteAntrenori(Antrenori antrenori) {
        antrenorRepository.deleteAntrenoriByNume(antrenori.getNume(), antrenori.getPrenume());
    }

    @Override
    public void adaugaDateStudenti(DateStudenti student) {
        studentPRepository.insertStudenti(student);
    }

    @Override
    public void updateSalariu(Antrenori antrenori) {
        antrenorRepository.updateSalariuByNumeAndPrenume(antrenori.getNume(), antrenori.getPrenume(), antrenori.getSalariu());
    }

    @Override
    public void updateNumeEchipa(EchipeDto nume) {
        echipeRepository.updateNumeEchipaByNume(nume.getDenumire(), nume.getNumeNou());
    }

    @Override
    public void adaugaEchipeAdverse(EchipeAdverse echipeAdverse) {
        echipeAdverseRepository.insertEchipeAdverse(echipeAdverse);
    }

    @Override
    public List<NumePrenumeDto> getNumePrenumeStudentibyEchipa(String denumireEchipa) {
        return studentPRepository.getStudentbyEchipa(denumireEchipa).stream().distinct()
                .map(objects -> NumePrenumeDto.builder()
                        .nume((String) objects[0])
                        .prenume((String) objects[1])
                        .build())
                .toList();
    }

    @Override
    public List<DetaliiEchipaDto> getAntrenoriAndEchipeBySport(String sport) {
        return antrenorRepository.getAntrenoriEchipeBySport(sport).stream()
                .map(objects -> DetaliiEchipaDto.builder()
                        .nume((String) objects[0])
                        .prenume((String) objects[1])
                        .numeEchipa((String) objects[2])
                        .build())
                .toList();
    }

    @Override
    public List<DetaliiEchipaDto> getStudentiAndEchipeByDataInscriere(LocalDate dataInscriere) {
        return studentPRepository.getStudentDataInscriere(dataInscriere).stream()
                .map(objects -> DetaliiEchipaDto.builder()
                        .nume((String) objects[0])
                        .prenume((String) objects[1])
                        .numeEchipa((String) objects[2])
                        .build())
                .toList();
    }

    @Override
    public List<DetaliiStudentiDto> getStudentibyAn() {
        return studentPRepository.getStudentbyAn().stream()
                .map(objects -> DetaliiStudentiDto.builder()
                        .nume((String) objects[0])
                        .prenume((String) objects[1])
                        .an((Integer) objects[2])
                        .build())
                .toList();
    }

    @Override
    public List<CastigatoriDto> getEchipeCastigatoare() {
        return echipeRepository.getEchipeCastigatoare().stream()
                .map(objects -> CastigatoriDto.builder()
                        .denumire((String) objects[0])
                        .puncte((Integer) objects[1])
                        .build())
                .toList();
    }

    @Override
    public List<NumePrenumeDto> getAntrenoriByStudenti() {
        return antrenorRepository.getAntrenoriBySerie().stream()
                .map(objects -> NumePrenumeDto.builder()
                        .nume((String) objects[0])
                        .prenume((String) objects[1])
                        .build())
                .toList();
    }

    @Override
    public List<NumePrenumeDto> getAntrenorByData() {
        return antrenorRepository.getAntrenorByDataInscriere().stream()
                .map(objects -> NumePrenumeDto.builder()
                        .nume((String) objects[0])
                        .prenume((String) objects[1])
                        .build())
                .toList();
    }

    @Override
    public List<NumePrenumeDto> getAntrenoriByLocaatie() {
        return antrenorRepository.getAntrenoriByLocatie().stream()
                .map(objects -> NumePrenumeDto.builder()
                        .nume((String) objects[0])
                        .prenume((String) objects[1])
                        .build())
                .toList();
    }

    @Override
    public List<AntrenoriDto> getAntrenoriSalariuStudenti() {
        return antrenorRepository.getAntrenoribySalariuStudenti().stream()
                .map(objects -> AntrenoriDto.builder()
                        .nume((String) objects[0])
                        .prenume((String) objects[1])
                        .salariu((Double) objects[2])
                        .nrStudenti((Integer) objects[3])
                        .build())
                .toList();
    }

    @Override
    public List<NumePrenumeDto> getStudentiCastigatoribyAn() {
        return studentPRepository.getStudentiCastigatoribyAn().stream()
                .map(objects -> NumePrenumeDto.builder()
                        .nume((String) objects[0])
                        .prenume((String) objects[1])
                        .build())
                .toList();
    }
}
