package plusplus.OldBookSeller.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plusplus.OldBookSeller.reponsitory.entity.FavoriteBook;

import java.util.List;

@Repository
public interface FavoriteBookRepository extends JpaRepository<FavoriteBook, Integer> {
    List<Integer> findAllByUser(Integer userID);
}
