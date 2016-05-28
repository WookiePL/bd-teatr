package theater.persist.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "roles", schema = "theater")
public class RolesEntity {
    private Integer roleId;
    private String role;
    private Collection<UserEntity> users;

    @Id
    @Column(name = "role_id", columnDefinition = "serial")
    @SequenceGenerator(name = "roles_role_id_seq",
            sequenceName = "roles_role_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
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

    @ManyToMany(mappedBy = "roleEntities", targetEntity = UserEntity.class, fetch = FetchType.EAGER)
    public Collection<UserEntity> getUserEntity() {
        return users;
    }

    public void setUserEntity(Collection<UserEntity> user){
        this.users=user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesEntity that = (RolesEntity) o;

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
