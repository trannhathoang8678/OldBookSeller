package plusplus.OldBookSeller.reponsitory.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Table(name = "FAVORITE_BOOK")
@Getter
@Setter
public class FavoriteBookEntity {
    @ManyToOne
    @JoinColumn(name = "BOOK_id")
    private BookEntity book;
    @ManyToOne
    @JoinColumn(name = "USER_id")
    private UserEntity user;
}
