package theater.persist.dtos;

/**
 * Created by Wookie on 2016-05-16.
 */
public class RolesDTO {
    private Integer roleId;
    private String name;
    private Integer code;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
