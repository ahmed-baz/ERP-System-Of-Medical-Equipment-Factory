package oracle.medical.app.model.classes;

import oracle.jbo.domain.Number;

public class Users {
    public Users(Number userId, Number roleId, String firstName, String lastName, String userName, String role,
                 String militeryRank) {
        super();
        this.userId = userId;
        this.roleId = roleId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.role = role;
        this.militeryRank = militeryRank;
    }

    private Number userId;
    private Number roleId;
    private String firstName;
    private String lastName;
    private String userName;
    private String role;

    public void setUserId(Number userId) {
        this.userId = userId;
    }

    public void setRoleId(Number roleId) {
        this.roleId = roleId;
    }

    public Number getRoleId() {
        return roleId;
    }

    public Number getUserId() {
        return userId;
    }
    private String militeryRank;


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setMiliteryRank(String militeryRank) {
        this.militeryRank = militeryRank;
    }

    public String getMiliteryRank() {
        return militeryRank;
    }
}
