package sabina.aa.backendfordb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sabina.aa.backendfordb.model.Sport;
@Repository
public interface SportRepository extends JpaRepository<Sport, Integer> {

}
