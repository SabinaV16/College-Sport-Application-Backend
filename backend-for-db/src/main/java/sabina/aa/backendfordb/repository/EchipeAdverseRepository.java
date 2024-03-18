package sabina.aa.backendfordb.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sabina.aa.backendfordb.model.EchipeAdverse;

@Repository
public interface EchipeAdverseRepository extends JpaRepository<EchipeAdverse, Integer> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM echipe_adverse WHERE denumire = :denumire", nativeQuery = true)
    void deleteEchipaAdversaByNume(@Param("denumire") String denumire);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO echipe_adverse (denumire, universitate, prenume_antrenor, nume_antrenor, sport, judet_sector, oras, strada) VALUES ( :#{#echipe_adverse.denumire}, :#{#echipe_adverse.universitate}, :#{#echipe_adverse.prenumeAntrenor},:#{#echipe_adverse.numeAntrenor}, :#{#echipe_adverse.sport}, :#{#echipe_adverse.judetSector}, :#{#echipe_adverse.oras}, :#{#echipe_adverse.strada})")
    void insertEchipeAdverse(@Param("echipe_adverse") EchipeAdverse echipe_adverse);

}
