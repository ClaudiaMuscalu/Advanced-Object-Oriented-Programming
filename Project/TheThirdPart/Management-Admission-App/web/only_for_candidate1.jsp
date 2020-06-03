<%@ page import="Model.CandidateApplication" %>
<%@ page import="Service.ApplicationService" %>
<%@ page import="Service.CandidateService" %>
<%
    ApplicationService applicationService = ApplicationService.getInstance();
    CandidateService candidateService = CandidateService.getInstance();

    String cnp = request.getParameter("cnp");
    String facultyCode = request.getParameter("faculty_code");
    String specCode = request.getParameter("code_spec");
    String admission_option = request.getParameter("admission_option");

    // daca o aplicatie nu are admitere atunci examenul va fi 0.0
    double a_exam = 0.0;

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


%>
<html>
    <head>
        <title>Application candidate</title>
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
        <h2>Application form</h2>
        <div class="row">
            <form method="post" class="formbox1">
                <div class="continut">
                    <h3>Faculty Application Form</h3>
                </div>

                <div class="continut">
                    <p>Candidate CNP:</p>
                    <input type="text" name="cnp">
                </div>

                <div class="continut">
                    <p>Faculty code:</p>
                    <input type="text" name="faculty_code">
                </div>

                <div class="continut">
                    <p>Specialization code:</p>
                    <input type="text" name="code_spec">
                </div>

                <div class="continut">
                    <p>Admission option:</p>
                    <input type="text" name="admission_option">
                </div>

                <div class="continut">
                    <input type="Submit" value="SEND" class="btn">
                </div>
            </form>
        </div>
    </body>
</html>
