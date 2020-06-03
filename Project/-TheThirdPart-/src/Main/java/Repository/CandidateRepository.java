package Repository;

import Model.*;

import java.sql.*;
import java.util.ArrayList;

public class CandidateRepository {

    private static final String url = "jdbc:mysql://localhost:3306/admission_database";
    private static final String user = "root";
    private static final String password = "";

    private static CandidateRepository instance = null;

    private CandidateRepository(){}

    public static CandidateRepository getInstance() {

        if (instance == null) {
            instance = new CandidateRepository();
        }
        return instance;
    }

    public Candidate getCandidate(String CNP) {

        String selectSQL = "SELECT * FROM candidates WHERE cnp = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        Candidate candidate = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(selectSQL);

            statement.setString(1, CNP);

            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                System.out.println("aaaa");
                candidate = new Candidate(resultset.getString("cnp"),
                        resultset.getString("candidate_type"), resultset.getString("firstname"),
                        resultset.getString("lastname"), resultset.getDouble("bac_result"));
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

        return candidate;
    }

    public ArrayList<Candidate> getAllCandidates() {

        ArrayList<Candidate> ListOfCandidates = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            resultset = statement.executeQuery("select * from candidates");

            while (resultset.next()) {
                ListOfCandidates.add(new Candidate(resultset.getString("cnp"),
                        resultset.getString("candidate_type"), resultset.getString("firstname"),
                        resultset.getString("lastname"), resultset.getDouble("bac_result")));
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
        return ListOfCandidates;
    }

    public ArrayList<BudgetCandidate> getAllBudgetCandidates() {

        ArrayList<BudgetCandidate> budgetCandidates = new ArrayList<>();

        String selectSQL = "SELECT * FROM candidates WHERE candidate_type = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(selectSQL);

            statement.setString(1, "budget");

            resultset = statement.executeQuery();

            while (resultset.next()) {
                budgetCandidates.add(new BudgetCandidate(resultset.getString("cnp"),
                        resultset.getString("candidate_type"), resultset.getString("firstname"),
                        resultset.getString("lastname"), resultset.getDouble("bac_result")));
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
        return budgetCandidates;
    }

    public ArrayList<TollCandidate> getAllTollCandidates() {
        ArrayList<TollCandidate> tollCandidates = new ArrayList<>();

        String selectSQL = "SELECT * FROM candidates WHERE candidate_type = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(selectSQL);

            statement.setString(1, "toll");

            resultset = statement.executeQuery();

            while (resultset.next()) {
                tollCandidates.add(new TollCandidate(resultset.getString("cnp"),
                        resultset.getString("candidate_type"), resultset.getString("firstname"),
                        resultset.getString("lastname"), resultset.getDouble("bac_result")));
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
        return tollCandidates;
    }

    public  void addCandidate(Candidate c) {

        Candidate candidate = getCandidate(c.getCnp());

        String insertSQL = "INSERT INTO candidates (cnp, candidate_type, firstname, lastname, bac_result) VALUES(?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        if (candidate == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
                statement = connection.prepareStatement(insertSQL);

                statement.setString(1, c.getCnp());
                statement.setString(2, c.getCandidateType());
                statement.setString(3, c.getFirstName());
                statement.setString(4, c.getLastName());
                statement.setDouble(5, c.getBacResult());

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
        else
        {
            System.out.println("This candidate exists in Database Candidate already!");
        }
    }

    public void updateLastName(String cnp, String newLastName) {

        String updateSQL = "UPDATE candidates SET lastname = ? WHERE cnp = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(updateSQL);

            statement.setString(1, newLastName);
            statement.setString(2, cnp);

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

    public void deleteCandidate(String cnp) {

        ApplicationRepository applicationRepository = ApplicationRepository.getInstance();

        String deleteSQL = "DELETE FROM candidates WHERE cnp = ?";


        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(deleteSQL);

            statement.setString(1, cnp);

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
