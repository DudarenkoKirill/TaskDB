package packDB;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static Connection connection;

    public static void main(String[] args) {
        try{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project" + "?verifyServerCertificate=false" + "&useSSL=false" + "&requireSSL=false" + "&useLegacyDatetimeCode=false" + "&amp" + "&serverTimezone=UTC", "root", "D7749692k");
        //insert("DUDA", "12345", 1, "+375297749692", "duda@mail.ru");
            for(User user:select("+375297749692"))
                user.Information(user);
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
            try {
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    static void insert(String login, String password, int role, String number, String email) {
        try {
            String query = "INSERT INTO users ( user_login , user_password, user_role , user_number, user_email ) values(?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, login);
            statement.setString(2, password);
            statement.setInt(3, role);
            statement.setString(4, number);
            statement.setString(5, email);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<User> select(String phone){
        ResultSet resultSet=null;
        ArrayList<User> list=new ArrayList<User>();
        try{
            PreparedStatement findUser=connection.prepareStatement("SELECT user_id,user_login , user_password, user_role , user_number, user_email FROM users WHERE user_number=?");
            findUser.setString(1,phone);
            resultSet=findUser.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("user_id");
                String login=resultSet.getString("user_login");
                String password=resultSet.getString("user_password");
                int role=resultSet.getInt("user_role");
                String number=resultSet.getString("user_number");
                String email=resultSet.getString("user_email");
                list.add(new User(id,login,password,role,number,email));
            }
            resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;

    }

}
