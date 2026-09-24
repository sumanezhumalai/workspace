package Model;

public class Support extends User{

    private User user;
    private String expertise;
    private String salary;
    private String refferalCode;


    
    public Support (Long id, String name, String phone, String role, String expertise, String salary, String refferalCode) {
        super(id, name, phone, role);
        this.expertise = expertise;
        this.salary = salary;
        this.refferalCode = refferalCode;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getExpertise() {
        return expertise;
    }
    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public String getRefferalCode() {
        return refferalCode;
    }
    public void setRefferalCode(String refferalCode) {
        this.refferalCode = refferalCode;
    }
 
}
