package plusplus.OldBookSeller.reponsitory.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USER_BOOK")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserBookRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "BOOK_id",updatable = false)
    private Book book;
    @ManyToOne
    @JoinColumn(name = "USER_id",updatable = false)
    private User user;
    @Column(name = "relationship")
    private String relationship;

    public UserBookRelationship(Book book, User user, String relationship) {
        this.book = book;
        this.user = user;
        this.relationship = relationship;
    }
}
