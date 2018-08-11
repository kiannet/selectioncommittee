package by.kiryanova.selectioncommittee.entity;

public class User {
    private int userId;
    private String email;
    private String username;
    private String password;
    private String role;
    private String ban;

    public User(){

    }

    public User(int userId, String email, String username, String password, String role, String ban){
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.ban = ban;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getBan(){
        return ban;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBan(String ban){
        this.ban = ban;
    }
}
