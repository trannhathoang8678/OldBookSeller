package plusplus.OldBookSeller.reponsitory.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "`USER`")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "token")
    private String token;

    public User(Integer id) {
        this.id = id;
    }

    public User(String email, String password, String phonenumber, String token) {
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
        this.token = token;
    }

    public User(String email, String token) {
        this.email = email;
        this.token = token;
    }
}
