package info.freeit.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "roles")
@Entity
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String rolename;

    public Role(Long id, String rolename) {
        this.id = id;
        this.rolename = rolename;
    }

    @OneToMany(mappedBy = "role")
    List<User> users = new ArrayList<>();
}
