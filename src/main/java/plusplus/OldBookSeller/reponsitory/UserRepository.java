package plusplus.OldBookSeller.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plusplus.OldBookSeller.reponsitory.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findOneByEmail(String email);
    User findOneById(int id);
    boolean existsById(int id);
    boolean existsByEmailAndPassword(String email,String password);
}
