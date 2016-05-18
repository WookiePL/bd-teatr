package theater.persist.dtos;

/**
 * Created by Wookie on 2016-05-16.
 */
public class GroupOfClientsDTO {
    private Integer groupOfClientsId;
    private String name;

    public Integer getGroupOfClientsId() {
        return groupOfClientsId;
    }

    public void setGroupOfClientsId(Integer groupOfClientsId) {
        this.groupOfClientsId = groupOfClientsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
