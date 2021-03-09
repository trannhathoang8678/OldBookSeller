package plusplus.OldBookSeller.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plusplus.OldBookSeller.reponsitory.entity.Type;


@Repository
public interface TypeRepository extends JpaRepository<Type,Integer> {
    Type findOneById(Integer id);
    Type findOneByName(String name);
}
