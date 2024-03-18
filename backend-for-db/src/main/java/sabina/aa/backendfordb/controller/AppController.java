package sabina.aa.backendfordb.controller;

import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sabina.aa.backendfordb.dto.*;
import sabina.aa.backendfordb.model.Antrenori;
import sabina.aa.backendfordb.model.DateStudenti;
import sabina.aa.backendfordb.model.EchipeAdverse;
import sabina.aa.backendfordb.service.AppServiceImpl;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sport")
@CrossOriginÓ
@RequiredArgsConstructor
public class AppController {

    private final AppServiceImpl service;

    @PostMapping("/studentP/insert")
    private ResponseEntity insertStudenti(@RequestBody DateStudenti studentiP) {
        service.adaugaDateStudenti(studentiP);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/antrenori/salariu")
    private ResponseEntity updateAntrenori(@RequestBody Antrenori antrenori) {
        service.updateSalariu(antrenori);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/echipe/nume")
    private ResponseEntity updateEchipe(@RequestBody EchipeDto nume) {
        service.updateNumeEchipa(nume);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/echipeadverse/delete")
    private ResponseEntity deleteEchipe(@RequestBody EchipeAdverse echipe) {
        service.deleteEchipeAdv(echipe);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/antrenori/delete")
    private ResponseEntity deleteAntrenori(@RequestBody Antrenori antrenori) {
        service.deleteAntrenori(antrenori);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/echipe_adverse/insert")
    private ResponseEntity insertEchipeAdverse(@RequestBody EchipeAdverse echipeAdverse) throws ExecutionControl.InternalException {
        service.adaugaEchipeAdverse(echipeAdverse);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/studenti/dinechipa/{echipa}")
    private ResponseEntity<List<NumePrenumeDto>> getNumePrenumeStudentibyEchipa(@PathVariable String echipa) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getNumePrenumeStudentibyEchipa(echipa));
    }

    @GetMapping("/antrenori/sport/{sport}")
    private ResponseEntity<List<DetaliiEchipaDto>> getAntrenoriAndEchipeBySport(@PathVariable String sport) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAntrenoriAndEchipeBySport(sport));
    }

    @GetMapping("/studenti/echipe/{dataInscriere}")
    private ResponseEntity<List<DetaliiEchipaDto>> getStudentiAndEchipeByDataInscriere(@PathVariable LocalDate dataInscriere) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getStudentiAndEchipeByDataInscriere(dataInscriere));
    }

    @GetMapping("/studenti/an")
    private ResponseEntity<List<DetaliiStudentiDto>> getStudentibyAn() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getStudentibyAn());
    }

    @GetMapping("/clasament")
    private ResponseEntity<List<CastigatoriDto>> getEchipeCastigatoare() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getEchipeCastigatoare());
    }

    @GetMapping("/antrenori/AB")
    private ResponseEntity<List<NumePrenumeDto>> getAntrenoriByStudenti() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAntrenoriByStudenti());
    }

    @GetMapping("/antrenori/ultimaInscriere")
    private ResponseEntity<List<NumePrenumeDto>> getAntrenorByData() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAntrenorByData());
    }

    @GetMapping("/antrenori/locatie")
    private ResponseEntity<List<NumePrenumeDto>> getAntrenoriByLocaatie() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAntrenoriByLocaatie());
    }

    //    @GetMapping("/antrenori/studenti")
//    private ResponseEntity<List<GeneralDto>> getAntrenoribySalariuStudenti(){
//        return  ResponseEntity.status(HttpStatus.OK).body(service.getAntrenoriSalariuStudenti());
//    }
    @GetMapping("/studenti/final")
    private ResponseEntity<List<NumePrenumeDto>> getStudentiCastigatoribyAn() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getStudentiCastigatoribyAn());
    }
}