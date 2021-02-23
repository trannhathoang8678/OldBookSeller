package plusplus.OldBookSeller.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plusplus.OldBookSeller.reponsitory.entity.UserBookRelationship;

import java.util.List;

@Repository
public interface UserBookRelationshipRepository extends JpaRepository<UserBookRelationship, Integer> {
    List<UserBookRelationship> findAllByUser(Integer userID);

    boolean existsByBookAndUserAndRelationship(int bookID, int userID, String relationship);
}
