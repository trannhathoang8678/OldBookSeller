package plusplus.OldBookSeller.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plusplus.OldBookSeller.reponsitory.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findOneByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByEmailAndPassword(String email,String password);
}
