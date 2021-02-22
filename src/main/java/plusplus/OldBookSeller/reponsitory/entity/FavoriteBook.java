package plusplus.OldBookSeller.reponsitory.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "FAVORITE_BOOK")
@Getter
@Setter
public class FavoriteBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "BOOK_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "USER_id")
    private User user;
}
