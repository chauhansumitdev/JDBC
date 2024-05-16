import java.sql.*;

class jdbctest {
    public static void main(String args[]) {
        String query = "SELECT * FROM public.your_table_name\r\n" +
                "ORDER BY id ASC ";

        String url = "jdbc:postgresql://localhost:5432/JDBC_LEARN";
        String username = "postgres";
        String password = "1234";

        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email);
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
