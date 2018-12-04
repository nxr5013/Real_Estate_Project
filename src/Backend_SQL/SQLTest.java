package Backend_SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class SQLTest{
    public static void main(String args[]) {
        Connection con;
        ResultSet rs = null;
        List<String> list;
        try {
            con = SQLConnection.getConnection("real_estate");
            rs = Query_Execution.executeQuery(con, "SELECT * FROM address;");
            while (rs.next()) {

                // creating a list to add all the column values at that column.
                // string, column header names or column position number, starting from 1, can be used in order to
                // get the required columns.
                list = new ArrayList<>();
                list.add(rs.getString("streetaddress"));
                list.add(rs.getString("city"));
                list.add(rs.getString("state"));
                list.add(rs.getString(4));
                list.add(rs.getString(5));

                System.out.println(list);
            }
            con.close();
        } catch (SQLException e) {
            System.err.println("Something went wrong.");
        } finally {
            try {
                if (rs != null) { rs.close(); }
            } catch (SQLException e) {
                System.err.println("Something went REALLY wrong.");
            }
        }
    }
}