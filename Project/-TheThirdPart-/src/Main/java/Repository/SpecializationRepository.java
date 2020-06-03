package Repository;

import Model.Specialization;

import java.sql.*;
import java.util.ArrayList;

public class SpecializationRepository {

    private static final String url = "jdbc:mysql://localhost:3306/admission_database";
    private static final String user = "root";
    private static final String password = "";

    private static SpecializationRepository instance = null;

    public SpecializationRepository() {}

    public static SpecializationRepository getInstance() {

        if (instance == null) {
            instance = new SpecializationRepository();
        }
        return instance;
    }

    public Specialization getSpecialization(String SpecializationCode) {

        String selectSQL = "SELECT * FROM specializations WHERE code_spec = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        Specialization specialization = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(selectSQL);

            statement.setString(1, SpecializationCode);

            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                specialization = new Specialization(resultset.getString("code_spec"),
                        resultset.getString("faculty_code"), resultset.getString("name_spec"),
                        resultset.getInt("budget_number"), resultset.getInt("toll_number"));
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
        return specialization;
    }

    public ArrayList<Specialization> getAllSpecializations() {

        ArrayList<Specialization> ListOfSpec = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            resultset = statement.executeQuery("select * from specializations");

            while (resultset.next()) {
                ListOfSpec.add(new Specialization(resultset.getString("code_spec"),
                        resultset.getString("faculty_code"), resultset.getString("name_spec"),
                        resultset.getInt("budget_number"), resultset.getInt("toll_number")));
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
        return ListOfSpec;
    }

    public ArrayList<Specialization> getAllSpecializationsFromFaculty(String faculty_code) {

        String selectSQL = "select * from specializations where faculty_code = ?";
        ArrayList<Specialization> ListOfSpec = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(selectSQL);

            statement.setString(1, faculty_code);

            resultset = statement.executeQuery();

            while (resultset.next()) {
                ListOfSpec.add(new Specialization(resultset.getString("code_spec"),
                        resultset.getString("faculty_code"), resultset.getString("name_spec"),
                        resultset.getInt("budget_number"), resultset.getInt("toll_number")));
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
        return ListOfSpec;
    }

    public void addSpecialization(Specialization s) {

        String insertSQL = "INSERT INTO specializations (code_spec, faculty_code, name_spec, budget_number, toll_number) VALUES(?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        Statement sta = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(insertSQL);

            statement.setString(2, s.getFacultyCode());
            statement.setString(3, s.getNameSpec());
            statement.setInt(4, s.getNumberOfPositionsBudget());
            statement.setInt(5, s.getNumberOfPositionsToll());

            sta = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            ResultSet resultSet = sta.executeQuery("select * from specializations");

            if(resultSet.last())
            {
                String codeSpecialization = resultSet.getString("code_spec");
                String x = codeSpecialization.substring(1);
                int number = Integer.parseInt(x) + 1;
                codeSpecialization = "S" + String.valueOf(number);
                statement.setString(1, codeSpecialization);
            }
            else
                statement.setString(1, "S1");

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

    public void updateSpecializationName(String Specializationcode, String newName) {

        String updateSQL = "UPDATE specializations SET  name_spec = ? WHERE code_spec = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(updateSQL);

            statement.setString(1, newName);
            statement.setString(2, Specializationcode);

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

    public void deleteSpecialization(String SpecializationCode) {

        String deleteSQL = "DELETE FROM specializations WHERE code_spec = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(deleteSQL);

            statement.setString(1, SpecializationCode);

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
