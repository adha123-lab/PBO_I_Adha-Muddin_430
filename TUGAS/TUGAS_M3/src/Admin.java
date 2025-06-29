
public class Admin extends User {
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }
    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }
    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil. Selamat datang, Admin " + getNama() + "!");
    }
}
