package plusplus.OldBookSeller.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import plusplus.OldBookSeller.reponsitory.entity.BookEntity;

public interface BookReponsitory extends JpaRepository<BookEntity,Integer> {
    BookEntity findOneById(Integer id);
}
