package sabina.aa.backendfordb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sabina.aa.backendfordb.model.DateSportive;
@Repository
public interface DateSportiveRepository extends JpaRepository<DateSportive, Integer> {
}
