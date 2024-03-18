package sabina.aa.backendfordb.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sabina.aa.backendfordb.model.Antrenori;

import java.util.List;

@Repository
public interface AntrenoriRepository extends JpaRepository<Antrenori, Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE antrenori SET salariu = :salariu WHERE nume = :nume AND prenume = :prenume", nativeQuery = true)
    void updateSalariuByNumeAndPrenume(@Param("nume") String nume, @Param("prenume") String prenume, @Param("salariu") Double salariu);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM antrenori WHERE nume = :nume AND prenume = :prenume", nativeQuery = true)
    void deleteAntrenoriByNume(@Param("nume") String nume, @Param("prenume") String prenume);
//antrenori si numele echipelor de la un anumit sport ales
    @Query("SELECT a.nume, a.prenume, e.denumire FROM Antrenori a " +
            "INNER JOIN Echipe e ON a.idAntrenor = e.idAntrenor " +
            "LEFT JOIN Sport s ON a.idCoordonator = s.idCoordonator OR a.idAntrenor= s.idCoordonator " +
            "WHERE s.denumire = :denumireSport ")
    List<Object[]> getAntrenoriEchipeBySport(@Param("denumireSport") String denumireSport);
//nume prenume antrenori care antreneaza studenti de la seria ab
    @Query("SELECT DISTINCT a.nume, a.prenume " +
            "FROM Antrenori a " +
            "JOIN Echipe e ON a.idAntrenor = e.idAntrenor " +
            "JOIN DateSportive ds ON e.idEchipa = ds.idEchipa " +
            "JOIN DateStudenti ds2 ON ds.idStudent = ds2.idStudent " +
            "WHERE ds2.serie = 'AB' "
    )
    List<Object[]> getAntrenoriBySerie();
//antrenorul care antreneaza echipa cu cel mai longeviv student
    @Query("SELECT a.nume AS numeAntrenor, a.prenume AS prenumeAntrenor " +
            "FROM Antrenori a " +
            "JOIN Echipe e ON a.idAntrenor = e.idAntrenor " +
            "JOIN DateSportive ds ON e.idEchipa = ds.idEchipa " +
            "JOIN DateStudenti ds2 ON ds.idStudent = ds2.idStudent " +
            "ORDER BY ds.dataInscriere ASC " +
            "LIMIT 1"
    )
    List<Object[]> getAntrenorByDataInscriere();

    //2.	Nume si prenume pentru antrenorii care au in echipa lor
    // studenti inscrisi in 2023 si a caror echipa a jucat macar un meci in deplasare.
    @Query("SELECT DISTINCT a.nume, a.prenume\n" +
            "FROM Antrenori a\n" +
            "JOIN Echipe e ON a.idAntrenor = e.idAntrenor\n" +
            "JOIN DateSportive ds ON e.idEchipa = ds.idEchipa\n" +
            "WHERE EXTRACT(YEAR FROM ds.dataInscriere) = 2023\n" +
            "   AND a.idAntrenor IN (\n" +
            "      SELECT a2.idAntrenor\n" +
            "      FROM Antrenori a2\n" +
            "      JOIN Echipe e2 ON a2.idAntrenor = e2.idAntrenor\n" +
            "      JOIN Meci m ON e2.idEchipa = m.idEchipa AND m.locatie = 'Deplasare'\n" +
            "   )\n" +
            "GROUP BY a.nume, a.prenume\n" +
            "HAVING COUNT(DISTINCT ds.idStudent) > 0\n"
    )
    List<Object[]> getAntrenoriByLocatie();

    //3.	Antrenorul care are salariul cel mai mare si
    //numarul de studenti din echipa cel mai mare impreuna cu salariul acestuia și
    //cu numărul de studenți din echipă.
    @Query("SELECT a.nume, a.prenume, a.salariu, COUNT(DISTINCT ds.idStudent) AS numar_studenti\n" +
            "FROM Antrenori a\n" +
            "JOIN Echipe e ON a.idAntrenor = e.idAntrenor\n" +
            "JOIN DateSportive ds ON e.idEchipa = ds.idEchipa\n" +
            "WHERE a.salariu = (\n" +
            "    SELECT MAX(a2.salariu)\n" +
            "    FROM Antrenori a2\n" +
            "    WHERE a2.idAntrenor IN (\n" +
            "        SELECT idAntrenor\n" +
            "        FROM Echipe\n" +
            "        WHERE idAntrenor IN (\n" +
            "            SELECT idCoordonator\n" +
            "            FROM Sport\n" +
            "        )\n" +
            "    )\n" +
            ")\n" +
            "GROUP BY a.nume, a.prenume, a.salariu\n" +
            "ORDER BY numar_studenti DESC\n" +
            "LIMIT 1"
    )
    List<Object[]> getAntrenoribySalariuStudenti();
}
