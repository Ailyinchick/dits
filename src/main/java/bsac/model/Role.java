package bsac.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    @Column
    private int user;
    @Column
    private int tutor;
    @Column
    private int admin;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<User> users;


    @Override
    public String toString() {
        if ((this.admin == 1)) {
            return "admin";
        } else if (this.user == 1) {
            return "user";
        } else {
            return "tutor";
        }
    }

    public Role(int user, int tutor, int admin) {
        this.user = user;
        this.tutor = tutor;
        this.admin = admin;
    }

    public Role() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    //id=1
    public int getUser() {
        return user;
    }

    //id=1
    public void setUser(int user) {
        this.user = user;
    }

    //id=2
    public int getTutor() {
        return tutor;
    }

    //id=2
    public void setTutor(int tutor) {
        this.tutor = tutor;
    }

    //id=3
    public int getAdmin() {
        return admin;
    }

    //id=3
    public void setAdmin(int admin) {
        this.admin = admin;
    }

}
