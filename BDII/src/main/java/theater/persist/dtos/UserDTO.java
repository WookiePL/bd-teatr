package theater.persist.dtos;

/**
 * Created by Wookie on 2016-05-16.
 */
public class UserDTO {
    private Integer userId;
    private String name;
    private String surname;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
