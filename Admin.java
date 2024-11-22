public class Admin {
    private String admin_username;
    private int admin_pin;

    //default constructor that User will call
    public Admin() {
        this.admin_pin = 1234;
        this.admin_username = "admin";
    }

    public Admin(String admin_username, int admin_pin) {
        this.admin_username = admin_username;
        this.admin_pin = admin_pin;
    }

    public String getAdminUsername() {
        return admin_username;
    }
    public int getAdminPin() {
        return admin_pin;
    }

    public void setAdminUsername(String admin_username) {
        this.admin_username = admin_username;
    }

    public void setAdminPin(int admin_pin) {
        this.admin_pin = 1234;
    }
}
