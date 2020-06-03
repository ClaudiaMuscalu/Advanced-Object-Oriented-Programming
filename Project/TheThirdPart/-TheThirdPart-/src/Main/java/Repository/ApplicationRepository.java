package Repository;

import Model.*;

import java.sql.*;
import java.util.ArrayList;

public class ApplicationRepository {

    private static final String url = "jdbc:mysql://localhost:3306/admission_database";
    private static final String user = "root";
    private static final String password = "";

    private CandidateRepository candidateRepository = CandidateRepository.getInstance();
    private static ApplicationRepository instance = null;

    public ApplicationRepository(){}

    public static ApplicationRepository getInstance() {

        if (instance == null) {
            instance = new ApplicationRepository();
        }
        return instance;
    }

    public CandidateApplication getApplication(String code_app){
        String selectSQL = "SELECT * FROM applications WHERE code_app = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        CandidateApplication a = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(selectSQL);

            statement.setString(1, code_app);

            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {

                a = new CandidateApplication(resultset.getString("code_app"),
                        resultset.getString("code_spec"),
                        resultset.getString("faculty_code"),
                        candidateRepository.getCandidate(resultset.getString("cnp")),
                        resultset.getString("admission_option"),
                        resultset.getDouble("admission_exam"));
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
        return a;
    }

    public ArrayList<CandidateApplication> getAllAplications() {

        ArrayList<CandidateApplication> ListOfApplications = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            resultset = statement.executeQuery("select * from applications");

            while (resultset.next()) {
                ListOfApplications.add(new CandidateApplication(resultset.getString("code_app"),
                        resultset.getString("code_spec"),
                        resultset.getString("faculty_code"),
                        candidateRepository.getCandidate(resultset.getString("cnp")),
                        resultset.getString("admission_option"),
                        resultset.getDouble("admission_exam")));
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
       return ListOfApplications;
    }

    public ArrayList<CandidateApplication> getAllAplicationsFaculty(String faculty_code) {

        String selectSQL = "select * from applications where faculty_code = ?";
        ArrayList<CandidateApplication> ListOfApplications = new ArrayList<>();

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
                ListOfApplications.add(new CandidateApplication(resultset.getString("code_app"),
                        resultset.getString("code_spec"),
                        resultset.getString("faculty_code"),
                        candidateRepository.getCandidate(resultset.getString("cnp")),
                        resultset.getString("admission_option"),
                        resultset.getDouble("admission_exam")));
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
        return ListOfApplications;
    }

    public ArrayList<CandidateApplication> getAllAplicationsFacultyBudget(String faculty_code,
                                                                    String code_spec)
    {
        String selectSQL = "select * from applications where faculty_code = ? and code_spec = ?";
        ArrayList<CandidateApplication> ListOfApplications = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(selectSQL);

            statement.setString(1, faculty_code);
            statement.setString(2, code_spec);

            resultset = statement.executeQuery();

            while (resultset.next()) {
                Candidate c = candidateRepository.getCandidate(resultset.getString("cnp"));

                if(c.getCandidateType().equals("budget")) {

                    ListOfApplications.add(new CandidateApplication(resultset.getString("code_app"),
                            resultset.getString("code_spec"),
                            resultset.getString("faculty_code"), c,
                            resultset.getString("admission_option"),
                            resultset.getDouble("admission_exam")));
                }
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
        return ListOfApplications;
    }

    public ArrayList<CandidateApplication> getAllAplicationsFacultyToll(String faculty_code,
                                                                          String code_spec)
    {
        String selectSQL = "select * from applications where faculty_code = ? and code_spec = ?";
        ArrayList<CandidateApplication> ListOfApplications = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(selectSQL);

            statement.setString(1, faculty_code);
            statement.setString(2, code_spec);

            resultset = statement.executeQuery();

            while (resultset.next()) {
                Candidate c = candidateRepository.getCandidate(resultset.getString("cnp"));

                if(c.getCandidateType().equals("toll")) {

                    ListOfApplications.add(new CandidateApplication(resultset.getString("code_app"),
                            resultset.getString("code_spec"),
                            resultset.getString("faculty_code"), c,
                            resultset.getString("admission_option"),
                            resultset.getDouble("admission_exam")));
                }
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
        return ListOfApplications;
    }

    public void addApplication(CandidateApplication a) {

        CandidateApplication app = getApplication(a.getApplicationCode());

        String insertSQL = "INSERT INTO applications (code_spec, faculty_code, cnp, admission_option, admission_exam) VALUES(?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        if (app == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
                statement = connection.prepareStatement(insertSQL);

                statement.setString(1, a.getCodeSpec());
                statement.setString(2, a.getFacultyCode());
                statement.setString(3, a.getCandidate().getCnp());
                statement.setString(4, a.getAdmissionOption());
                statement.setDouble(5, a.getAdmissionExam());

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
        } else
            System.out.println("This application exists in Database applications already!");
    }

    public void updateResult(String code_app) {

        CandidateApplication application = getApplication(code_app);
        String updateSQL = "UPDATE applications SET result = ? WHERE code_app = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(updateSQL);

            String admission_option = application.getAdmissionOption();
            double bac_result = application.getCandidate().getBacResult();
            double admission_result = application.getAdmissionExam();
            double final_result = (bac_result + admission_result) / 2.0;


            if(admission_option.equals("true"))
                statement.setDouble(1, final_result);
            else
                statement.setDouble(1, bac_result);

            statement.setString(2, code_app);

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

    public void addAdmissionResult(String code_app, double result) {

        CandidateApplication application = getApplication(code_app);
        String updateSQL = "UPDATE applications SET admission_exam = ? WHERE code_app = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(updateSQL);

            String admission_option = application.getAdmissionOption();


//            daca acea aplicatie nu are optiune de admitere atunci result este 0.0
            if(admission_option.equals("true"))
                statement.setDouble(1, result);
            else
                statement.setDouble(1, 0.0);

            statement.setString(2, code_app);

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


    public void deleteApplication(String code_app) {

        String deleteSQL = "DELETE FROM applications WHERE code_app = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.prepareStatement(deleteSQL);

            statement.setString(1, code_app);

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
