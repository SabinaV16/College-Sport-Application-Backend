package sabina.aa.backendfordb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sabina.aa.backendfordb.model.Meci;

@Repository
public interface MeciRepository extends JpaRepository<Meci, Integer> {

}
