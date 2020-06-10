package bsac.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String login;
    @Column
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Statistic> statistics;

    private String nameRole;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password=" + password +
                ", role=" + role.getRoleId() +
                '}';
    }

    public User(String firstName, String lastName, String login, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(String firstName, String lastName, String login, String password, String nameRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.role = setRoleByNameRole(nameRole);
    }

    public User() {
    }

    public String getStringNameRole() {
        if (role.getAdmin() == 1) {
            return "ADMIN";
        } else if (role.getUser() == 1) {
            return "USER";
        } else {
            return "TUTOR";
        }
    }

    public String getFIO(User user) {
        String str = "";
        str += user.getFirstName() + "\n";
        str += user.getLastName() + "\n";
        return str;
    }

    public String getFIO() {
        String str = "";
        str += this.getFirstName() + "\n";
        str += this.getLastName() + "\n";
        return str;
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }

    public Role setRoleByNameRole(String nameRole) {
        Role roleByNameRole = new Role(0,0,0);

        if (nameRole.contains("admin") || nameRole.contains("ADMIN")) {
            roleByNameRole.setRoleId(3);
            roleByNameRole.setAdmin(1);
        } else if (nameRole.contains("user") || nameRole.contains("USER")) {
            roleByNameRole.setRoleId(1);
            roleByNameRole.setUser(1);
        } else {
            roleByNameRole.setRoleId(1);
            roleByNameRole.setTutor(1);
        }
        return roleByNameRole;
    }

    public void setStatistics(List<Statistic> statistics) {
        this.statistics = statistics;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String  getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole){
        this.nameRole = nameRole;
    }

}