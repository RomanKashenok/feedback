package info.freeit.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "abuser")
@Entity
@Data
@NoArgsConstructor
public class Abuser extends Person {

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public Abuser(String name, String username, String password) {
        this(null, name, username, password);
    }

    public Abuser(Long id, String name, String username, String password) {
        super(null, name);
        this.username = username;
        this.password = password;
    }
}
