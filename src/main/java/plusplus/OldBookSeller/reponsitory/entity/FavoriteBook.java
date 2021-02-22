package plusplus.OldBookSeller.reponsitory.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "FAVORITE_BOOK")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
