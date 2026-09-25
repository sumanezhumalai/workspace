package Model;

public class User implements Comparable<User>{
    private Long id;
    private String name;
    private String phone;
    private String role;

    public String getName() {
        return name;
    }

    public User(Long id, String name, String phone, String role) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                '}' +
                "\n";
    }

    @Override
    public int compareTo(User other){
        return this.phone.compareTo(other.phone);
    }
}
