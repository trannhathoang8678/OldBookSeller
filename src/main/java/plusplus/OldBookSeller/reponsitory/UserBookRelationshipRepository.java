package plusplus.OldBookSeller.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import plusplus.OldBookSeller.reponsitory.entity.Book;
import plusplus.OldBookSeller.reponsitory.entity.User;
import plusplus.OldBookSeller.reponsitory.entity.UserBookRelationship;

import java.util.List;

@Repository
public interface UserBookRelationshipRepository extends JpaRepository<UserBookRelationship, Integer> {
    @Query(value = "SELECT BOOK_id WHERE USER_id = ?1 AND relationship = ?2 ;",nativeQuery = true)
    List<Integer> findBookIdsWithRelationship (int userId,String relationship);
    boolean existsByBookAndUser(Book book, User user);
    boolean existsByBookAndUserAndRelationship(Book book, User user, String relationship);
    UserBookRelationship findOneByBookAndUserAndRelationship(Book book, User user, String relationship);
}
