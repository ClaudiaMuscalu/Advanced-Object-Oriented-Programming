<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.CandidateApplication" %>
<%@ page import="Service.DistributionService" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Specialization" %>
<%@ page import="Service.SpecializationService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Distribution</title>
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
        <h1 style="text-align: center">Rejected candidates to the budget for all specializations</h1>
        <form>
            <div class="continut">
                <p>Fill with a faculty code:</p>
                <input type="text" name="faculty_code">
            </div>

            <div class="continut">
                <input type="Submit" value="GET RESULT" class="btn">
            </div>
        </form>
        <%

            SpecializationService specializationService = SpecializationService.getInstance();
            DistributionService distributionService = DistributionService.getInstance();
            ArrayList<Specialization> S = specializationService.getAllSpecializationsFromFaculty("F1");
            String code_f = request.getParameter("faculty_code");

            if(code_f != null)
            {
                for(Specialization s: S)
                {
                    List<CandidateApplication> L = null;
                    String code = s.getCodeSpec();
                    L = distributionService.getRejectedCandidatesSpecB(code_f, code);

        %>

        <h2><%=s.getNameSpec()%></h2>
        <br> <br>

        <table border="1" style="display: block;border-radius: 5px;margin-left: 15%;">
            <tr>
                <td>Id application</td>
                <td>Specialization code</td>
                <td>Faculty code</td>
                <td>CNP</td>
                <td>LastName</td>
                <td>FirstName</td>
                <td>Admission option</td>
                <td>Admission exam</td>
                <td>Bac result</td>
                <td>Final Result</td>
            </tr>
            <%
                for(CandidateApplication a: L)
                {
            %>

            <tr>
                <td><%=a.getApplicationCode() %></td>
                <td><%=a.getCodeSpec()%></td>
                <td><%=a.getFacultyCode()%></td>
                <td><%=a.getCandidate().getCnp() %></td>
                <td><%=a.getCandidate().getLastName() %></td>
                <td><%=a.getCandidate().getFirstName() %></td>
                <td><%=a.getAdmissionOption()%></td>
                <td><%=a.getAdmissionExam()%></td>
                <td><%=a.getCandidate().getBacResult()%></td>
                <td><%=a.getResult()%></td>
            </tr>
            <%
                }
            %>
        </table>
        <br>
        <%
                }
            }

        %>
    </body>
</html>

