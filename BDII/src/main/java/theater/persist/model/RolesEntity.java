package theater.persist.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles", schema = "theater")
public class RolesEntity {
    private Integer roleId;
    private String name;
    private Integer code;
    private List<JoinUsersToRolesEntity> joinUsersToRolesEntities;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "code")
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @OneToMany(mappedBy = "rolesEntity", fetch = FetchType.LAZY)
    public List<JoinUsersToRolesEntity> getJoinUsersToRolesEntities() {
        return joinUsersToRolesEntities;
    }

    public void setJoinUsersToRolesEntities(List<JoinUsersToRolesEntity> joinUsersToRolesEntities) {
        this.joinUsersToRolesEntities = joinUsersToRolesEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesEntity that = (RolesEntity) o;

        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }
}
