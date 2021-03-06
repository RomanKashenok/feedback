package info.freeit.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "users")
@Entity
@NoArgsConstructor
public class User extends Person {

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public User(String name, String username, String password) {
        this(null, name, username, password);
    }

    public User(Long id, String name, String username, String password) {
        super(null, name);
        this.username = username;
        this.password = password;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="role_id")
    private Role role;
}
