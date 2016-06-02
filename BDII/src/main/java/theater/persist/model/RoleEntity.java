package theater.persist.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "roles", schema = "theater")
public class RoleEntity {
    private Integer roleId;
    private String role;
    private Collection<UserEntity> users;

    @Id
    @Column(name = "role_id", columnDefinition = "serial")
    @SequenceGenerator(name = "roles_role_id_seq",
            sequenceName = "roles_role_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "roles_role_id_seq")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @ManyToMany(mappedBy = "roles", targetEntity = UserEntity.class)
    public Collection<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserEntity> user){
        this.users=user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
