package plusplus.OldBookSeller.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import plusplus.OldBookSeller.reponsitory.entity.UserBookRelationship;

import java.util.List;

@Repository
public interface UserBookRelationshipRepository extends JpaRepository<UserBookRelationship, Integer> {
    @Query(value = "SELECT BOOK_id WHERE USER_id = ?1 AND relationship = ?2 ;",nativeQuery = true)
    List<Integer> findBookIdsWithRelationship (int userId,String relationship);
    boolean existsByBookAndUserAndRelationship(int bookID, int userID, String relationship);
    UserBookRelationship findOneByBookAndUserAndRelationship(int bookID, int userID, String relationship);
}
