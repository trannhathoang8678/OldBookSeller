package plusplus.OldBookSeller.reponsitory.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
}
