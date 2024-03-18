package sabina.aa.backendfordb.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sabina.aa.backendfordb.model.DateStudenti;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DateStudentiRepository extends JpaRepository <DateStudenti, Integer>{
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO date_studenti ( nume, prenume, cnp, facultate, domeniu, grupa, serie, an, numar_telefon, data_nasterii, sex, judet_sector, oras, strada) VALUES (:#{#student.nume}, :#{#student.prenume}, :#{#student.cnp},:#{#student.facultate}, :#{#student.domeniu}, :#{#student.grupa}, :#{#student.serie}, :#{#student.an}, :#{#student.numarTelefon}, :#{#student.dataNasterii}, :#{#student.sex}, :#{#student.judetSector}, :#{#student.oras}, :#{#student.strada})" )
  void insertStudenti(@Param("student") DateStudenti student );

//toti studentii care sunt intr o anumita echipa introdusa de utilizator
    @Query("SELECT ds.nume, ds.prenume FROM DateStudenti ds " +
            "INNER JOIN DateSportive d ON ds.idStudent = d.idStudent " +
            "INNER JOIN Echipe e ON e.idEchipa = d.idEchipa " +
            "WHERE e.denumire = :denumireEchipa")
    List<Object[]> getStudentbyEchipa(@Param("denumireEchipa") String denumireEchipa);

//toti studentii care s au inscris dupa o anumita data
    @Query("SELECT ds.nume, ds.prenume, e.denumire FROM DateStudenti ds " +
            "INNER JOIN DateSportive d ON ds.idStudent = d.idStudent " +
            "INNER JOIN Echipe e ON d.idEchipa = e.idEchipa " +
            "WHERE d.dataInscriere > :dataInscriere")
    List<Object[]> getStudentDataInscriere(@Param("dataInscriere") LocalDate dataInscriere);

    //toti studentii care sunt an mai mare de 2 si antrenorii lor au salariul mai mare decat media
    @Query("SELECT ds.nume, ds.prenume, ds.an " +
            "FROM DateStudenti ds " +
            "JOIN DateSportive dsport ON ds.idStudent = dsport.idStudent " +
            "JOIN Echipe e ON dsport.idEchipa = e.idEchipa " +
            "JOIN Antrenori a ON e.idAntrenor = a.idAntrenor " +
            "WHERE ds.an > 2 " +
            "AND a.salariu > (SELECT AVG(salariu) FROM Antrenori)"
    )
    List<Object[]> getStudentbyAn();

    //toti studentii care sunt an maxim, antrenorul lor are salariul mai mare decat media si
    //au castigat macar un meci
    @Query("SELECT ds.nume, ds.prenume\n" +
            "FROM DateStudenti ds\n" +
            "JOIN DateSportive dss ON ds.idStudent = dss.idStudent\n" +
            "JOIN Echipe e ON dss.idEchipa = e.idEchipa\n" +
            "JOIN Antrenori a ON e.idAntrenor = a.idAntrenor\n" +
            "JOIN Meci m ON e.idEchipa = m.idEchipa AND m.puncteNoi > m.puncteAdv\n" +
            "WHERE ds.an = (\n" +
            "    SELECT MAX(an)\n" +
            "    FROM DateStudenti\n" +
            ")\n" +
            "AND a.salariu > (\n" +
            "    SELECT AVG(salariu)\n" +
            "    FROM Antrenori\n" +
            ")\n" +
            "GROUP BY ds.nume, ds.prenume\n" +
            "HAVING COUNT(DISTINCT m.id) > 0\n"
    )
    List<Object[]> getStudentiCastigatoribyAn();

}
