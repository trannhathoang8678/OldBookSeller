package plusplus.OldBookSeller.reponsitory.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "BOOK")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="TYPE_id")
    private Type type;

    public Book(Integer id) {
        this.id = id;
    }

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "published_year")
    private Integer publishYear;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "contact_info")
    private String contactInfo;
    @Column(name = "day_posted")
    private Timestamp postDay;
    @Column(name = "url_image")
    private String urlImage;
}
