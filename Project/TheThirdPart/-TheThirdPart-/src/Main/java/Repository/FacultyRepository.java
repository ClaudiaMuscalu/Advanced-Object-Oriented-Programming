package Repository;

import Model.Faculty;
import Model.Specialization;
import Service.SpecializationService;

import java.sql.*;
import java.util.ArrayList;

public class FacultyRepository {

    private static final String url = "jdbc:mysql://localhost:3306/admission_database";
    private static final String user = "root";
    private static final String password = "";
    
    private static FacultyRepository instance = null;

    public FacultyRepository() {}

    public static FacultyRepository getInstance() {

        if (instance == null) {
            instance = new FacultyRepository();
        }
        return instance;
    }

    public Faculty getFaculty(String facultyCode) {

        String selectSQL = "SELECT * FROM faculties WHERE faculty_code = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        Faculty faculty = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(selectSQL);

            statement.setString(1, facultyCode);

            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                faculty = new Faculty(resultset.getString("faculty_code"),
                        resultset.getString("name_faculty"), resultset.getInt("budget_number"),
                        resultset.getInt("toll_number"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // block final pentru inchiderea resurselor
            try {
                if (connection != null)
                    connection.close();

                if (statement != null)
                    statement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return faculty;
    }

    public ArrayList<Faculty> getAllFaculties() {

        ArrayList<Faculty> ListOfFaculties = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            resultset = statement.executeQuery("select * from faculties");

            while (resultset.next()) {
                ListOfFaculties.add(new Faculty(resultset.getString("faculty_code"),
                        resultset.getString("name_faculty"), resultset.getInt("budget_number"),
                        resultset.getInt("toll_number")));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // block final pentru inchiderea resurselor
            try {
                if (connection != null)
                    connection.close();

                if (statement != null)
                    statement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return ListOfFaculties;
    }

    public void addFaculty(Faculty f) {

        String insertSQL = "INSERT INTO faculties (faculty_code, name_faculty, budget_number, toll_number) VALUES(?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        Statement sta = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
                statement = connection.prepareStatement(insertSQL);

                statement.setString(2, f.getNameFaculty());
                statement.setInt(3, f.getBudgetNumberPositions());
                statement.setInt(4, f.getTollNumberPositions());

                sta = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

                ResultSet resultSet = sta.executeQuery("select * from faculties");

                if(resultSet.last())
                {
                    String codeFaculty = resultSet.getString("faculty_code");
                    String x = codeFaculty.substring(1);
                    int number = Integer.parseInt(x) + 1;
                    codeFaculty = "F" + String.valueOf(number);
                    statement.setString(1, codeFaculty);
                }
                else
                    statement.setString(1, "F1");

                statement.executeUpdate();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                // block final pentru inchiderea resurselor
                try {
                    if (connection != null)
                        connection.close();

                    if (statement != null)
                        statement.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
    }

    public void updateFacultyName(String facultycode, String newName) {

        String updateSQL = "UPDATE faculties SET  name_faculty = ? WHERE faculty_code = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(updateSQL);

            statement.setString(1, newName);
            statement.setString(2, facultycode);

            statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // block final pentru inchiderea resurselor
            try {
                if (connection != null)
                    connection.close();

                if (statement != null)
                    statement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void deleteFaculty(String facultyCode) {

        String deleteSQL = "DELETE FROM faculties WHERE faculty_code = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(deleteSQL);

            statement.setString(1, facultyCode);

            statement.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // block final pentru inchiderea resurselor
            try {
                if (connection != null)
                    connection.close();

                if (statement != null)
                    statement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
