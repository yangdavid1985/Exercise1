package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<User> getAllUsers() {

        logger.info("getting all users");
        logger.error("demo error level logging..");

        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;

        String sql = "SELECT * FROM users";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);

            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.error("SQL Exception..", e);
            logger.error("SearchUser.getAllUsers()...SQL Exception: " + e);
        } catch (Exception e) {
            System.out.println("SearchUser.getAllUsers()...Exception: " + e);
        }
        return users;
    }

    public List<User> searchByLastname(String lastName){
        List<User> searchByLastname = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        ResultSet results;

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();

               String sql = "SELECT * FROM users WHERE last_name = '" +  lastName + "'";

               results = selectStatement.executeQuery(sql);

               while(results.next()){
                   User userLastname = createUserFromResults(results);
                    searchByLastname.add(userLastname);
               }

               database.disconnect();
            } catch (SQLException e){
                logger.error("SearchUser.lastNameSearch().. SQL Exception: " + e);
            } catch (Exception e) {
                logger.error("SearchUser.lastNameSearch().. SQL Exception: " + e);
            }

        return searchByLastname;
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setUserid(results.getString("id"));
        user.setBirthDate(results.getString("date_of_birth"));

        return user;
    }

}