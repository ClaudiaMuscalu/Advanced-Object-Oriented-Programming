<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="Service.CandidateService" %>
<%@ page import="Service.ApplicationService" %>
<%@ page import="Model.CandidateApplication" %>
<%
    ApplicationService applicationService = ApplicationService.getInstance();
    CandidateService candidateService = CandidateService.getInstance();

    String cnp = request.getParameter("cnp");
    String facultyCode = request.getParameter("faculty_code");
    String specCode = request.getParameter("code_spec");
    String admission_option = request.getParameter("admission_option");
    String admission_exam = request.getParameter("admission_exam");

    // daca o aplicatie nu are admitere atunci examenul va fi 0.0
    double a_exam = 0.0;
    if(admission_option != null && admission_option.equals("true"))
        a_exam = Double.parseDouble(admission_exam);

    try
    {
        if(cnp != null && facultyCode != null && specCode != null
                && admission_option != null){

            applicationService.addApplication(new CandidateApplication(specCode, facultyCode,
                    candidateService.getCandidate(cnp), admission_option, a_exam));
            //out.println("The application was added successfully!");

        }
    }
    catch(Exception e)
    {
        System.out.print(e);
        e.printStackTrace();
    }

    String code_app_update = request.getParameter("code_app_update");

    if(code_app_update != null) {
        applicationService.updateResult(code_app_update);
        //out.println("The result was calculated");
    }

    String code_app_delete = request.getParameter("code_app_delete");

    if(code_app_delete != null){
        applicationService.deleteApplication(code_app_delete);
        //out.println("The application was deleted successfully!");
    }
%>

<!DOCTYPE html>
    <head>
        <title>Application-form</title>
        <link href = "style.css" type = "text/css" rel = "stylesheet">
    </head>

    <header>
        <div class="text1">
            <h2>University Admission</h2>
        </div>
    </header>

    <div class="topnav">
        <ul>
            <li>
                <a class="active" href="index.jsp">HOME</a>
            </li>

            <li class="dropdown">
                <button class="dropbtn">FUTURE STUDENTS</button>

                <div class="dropdown-content">
                    <a class="drop" href="only_for_candidate.jsp">CANDIDATE FORM</a>
                    <a class="drop" href="only_for_candidate1.jsp">APPLICATION FORM</a>
                </div>
            </li>

            <li>
                <a class="list" href="all_applications.jsp">ALL APPLICATIONS</a>
            </li>

            <li class="dropdown">
                <button class="dropbtn">ADMITTED CANDIDATES</button>

                <div class="dropdown-content">
                    <a class="drop" href="budget.jsp">BUDGET</a>
                    <a class="drop" href="toll.jsp">TOLL</a>
                </div>
            </li>

            <li class="dropdown">
                <button class="dropbtn">REJECTED CANDIDATES</button>

                <div class="dropdown-content">
                    <a class="drop" href="rejected_budget.jsp">BUDGET</a>
                    <a class="drop" href="toll_rejected.jsp">TOLL</a>
                </div>
            </li>

            <div class="admin">
                <a  href="options.jsp">UNIVERSITY ADMINISTRATOR</a>
            </div>
        </ul>
    </div>

    <body>
        <h1 style="text-align: center">MENU</h1>
        <div class="row" style="margin-top: 5%">
            <div class="continut">
                <a href="candidate_form.jsp">
                    <input type="Submit" value="Candidate form">
                </a>
            </div>

            <br> <br> <br> <br>

            <div class="continut">
                <a href="application-form.jsp">
                    <input type="Submit" value="Application form">
                </a>
            </div>

            <br> <br> <br> <br>

            <div class="continut">
                <a href="specialization-form.jsp">
                    <input type="Submit" value="Specialization form">
                </a>
            </div>

            <br> <br> <br> <br>

            <div class="continut">
                <a href="faculty-form.jsp">
                    <input type="Submit" value="Faculty form">
                </a>
            </div>

            <br> <br> <br> <br>
        </div>
    </body>
</DOCTYPEhtml>

