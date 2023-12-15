package Lab5;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBExecuter {
    private String url;
    private String user;
    private String password;

    public DBExecuter(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void executeQueryWithNoResult(String query) throws SQLException {
        Connection connection = DBConnection.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        statement.execute(query);

        statement.close();
        connection.close();
    }
}
