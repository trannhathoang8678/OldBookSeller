package plusplus.OldBookSeller.reponsitory;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import plusplus.OldBookSeller.reponsitory.entity.Book;

import java.util.List;
@Repository
public interface BookReponsitory extends JpaRepository<Book, Integer> {
    List<Book> findAllByTitleAndType(String title, Integer typeID, Pageable pageable);
    List<Book> findAllByType( Integer typeID, Pageable pageable);
    @Query(value = "SELECT * FROM BOOK WHERE title REGEXP '.*?1.*' ;",nativeQuery = true)
    List<Book> findByTitle( String title, Pageable pageable);
    Book findOneById(Integer id);
    boolean existsById(Integer id);
}
