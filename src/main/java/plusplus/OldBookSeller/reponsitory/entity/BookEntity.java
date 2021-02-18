package plusplus.OldBookSeller.reponsitory.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "BOOK")
@Getter
@Setter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="TYPE_id")
    private TypeEntity type;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "published_year")
    private Integer publishYear;
    @Column(name = "author")
    private String author;
    @Column(name = "prize")
    private BigDecimal prize;
    @Column(name = "contact_info")
    private String contactInfo;
    @Column(name = "day_posted")
    private Date postDay;
}
