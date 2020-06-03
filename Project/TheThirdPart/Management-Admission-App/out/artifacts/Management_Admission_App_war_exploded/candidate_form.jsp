<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="Model.Candidate" %>
<%@ page import="Service.CandidateService" %>

<%
    CandidateService candidateService = CandidateService.getInstance();
    String first_name = request.getParameter("first_name");
    String last_name = request.getParameter("last_name");
    String cnp = request.getParameter("cnp");
    String type = request.getParameter("type");

    double bac_result = 0.0;
    if(request.getParameter("bac_result") != null)
        bac_result = Double.parseDouble(request.getParameter("bac_result"));

    try
    {
        if(first_name !=  null && last_name != null && cnp != null
                && bac_result != 0.0 && type != null){

            Candidate c = new Candidate(cnp, type, first_name, last_name, bac_result);
            candidateService.addCandidate(c);
        }
    }
    catch(Exception e)
    {
        System.out.print(e);
        e.printStackTrace();
    }

    String cnp_update = request.getParameter("cnp_update");
    String new_name = request.getParameter("new_name");
    String cnp_delete = request.getParameter("cnp_delete");

    if(cnp_update != null) {
        candidateService.updateLastName(cnp_update, new_name);
    }

    if(cnp_delete != null){
        candidateService.deleteCandidate(cnp_delete);
    }
%>

<!DOCTYPE html>
    <head>
        <title>Candidate-form</title>
        <link href = "style.css" type = "text/css" rel = "stylesheet">
    </head>

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

            <li>
                <a  href="options.jsp">UNIVERSITY ADMINISTRATOR</a>
            </li>
        </ul>
    </div>

    <body>
        <h2>Candidate form</h2>
        <div class="row">
            <form method="post" class="formbox1">
                <div>
                    <h3>Add information from a candidate</h3>
                </div>

                <div class="continut">
                    <p>First name:</p>
                    <input type="text" name="first_name">
                </div>

                <div class="continut">
                    <p>Last name:</p>
                    <input type="text" name="last_name">
                </div>

                <div class="continut">
                    <p>CNP:</p>
                    <input type="text" name="cnp">
                </div>

                <div class="continut">
                    <p>Bac result: </p>
                    <input type="text" name="bac_result">
                </div>

                <div class="continut">
                    <p>Candidate type:</p>
                    <input type="text" name="type">
                </div>

                <div class="continut">
                    <input type="Submit" value="SEND" class="btn">
                </div>
                <br>
            </form>

            <hr> <br>

            <form method="post" class="formbox2">
                <div>
                    <h3>Update last name by cnp</h3>
                </div>

                <div class="continut">
                    <p>CNP:</p>
                    <input type="text" name="cnp_update">
                </div>

                <div class="continut">
                    <p>The new last name:</p>
                    <input type="text" name="new_name">
                </div>

                <div class="continut">
                    <input type="Submit" value="UPDATE" class="btn">
                </div>
                <br>
            </form>

            <hr> <br>

            <form method="post" class="formbox3">
                <div>
                    <h3>Delete a candidate by cnp</h3>
                </div>

                <div class="continut">
                    <p>CNP:</p>
                    <input type="text" name="cnp_delete">
                </div>

                <div class="continut">
                    <input type="Submit" value="DELETE" class="btn">
                </div>
            </form>
        </div>
    </body>
</html>

