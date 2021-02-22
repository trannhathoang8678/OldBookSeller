package plusplus.OldBookSeller.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plusplus.OldBookSeller.reponsitory.entity.Type;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type,Integer> {
    Type findOneById(Integer id);
}
