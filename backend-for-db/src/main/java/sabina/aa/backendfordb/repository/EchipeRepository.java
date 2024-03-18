package sabina.aa.backendfordb.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sabina.aa.backendfordb.model.Echipe;

import java.util.List;

@Repository
public interface EchipeRepository extends JpaRepository<Echipe, Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE echipe SET denumire = :numeNou WHERE denumire = :denumire", nativeQuery = true)
    void updateNumeEchipaByNume(@Param("denumire") String denumire, @Param("numeNou") String numeNou);
// echipele care au cel putin un pct castigat impreuna cu totalul punctelor de la toate meciurile
    @Query("SELECT e.denumire AS numeEchipa, SUM(m.puncteNoi) AS totalPuncteObtinute " +
            "FROM Echipe e " +
            "JOIN Meci m ON e.idEchipa = m.idEchipa " +
            "WHERE m.puncteNoi > m.puncteAdv " +
            "GROUP BY e.denumire " +
            "HAVING COUNT(m.id) > 0 "
    )
    List<Object[]> getEchipeCastigatoare();
}
