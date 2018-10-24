package packDB;

public class User {
    private int id;
    private String login;
    private String password;
    private int role;
    private String phone;
    private String email;
    public User(int id,String login, String password, int role, String number, String email){
        this.id=id;
        this.login=login;
        this.password=password;
        this.role=role;
        this.phone=number;
        this.email=email;
    }

    public void Information(User user) {
        System.out.println(" id = "+this.id);
        System.out.println(" login = "+this.login);
        System.out.println(" password = "+this.password);
        System.out.println(" role = "+this.role);
        System.out.println(" number = "+this.phone);
        System.out.println(" email = "+this.email);
        System.out.println(" ------------");

    }
}
