
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="Model.Faculty" %>
<%@ page import="Service.FacultyService" %>

<%
    FacultyService facultyService = FacultyService.getInstance();
    String name_faculty = request.getParameter("faculty_name");
    String budget = request.getParameter("budget");
    String toll = request.getParameter("toll");

    int nrbudget = 0;
    int nrtoll = 0;
    if(budget != null)
        nrbudget = Integer.parseInt(budget);

    if(toll != null)
        nrtoll = Integer.parseInt(toll);

    try
    {
        if(name_faculty != null &&
                nrbudget != 0 && nrtoll != 0){

            facultyService.addFaculty(new Faculty(name_faculty, nrbudget, nrtoll));
            //out.println("The faculty was added successfully!");

        }

    }
    catch(Exception e)
    {
        System.out.print(e);
        e.printStackTrace();
    }

    String faculty_code_update = request.getParameter("faculty_code");
    String new_faculty_name = request.getParameter("new_faculty_name");
    String faculty_code_delete = request.getParameter("faculty_code_delete");

    if(faculty_code_update != null && new_faculty_name != null){
        facultyService.updateFacultyName(faculty_code_update, new_faculty_name);
    }

    if(faculty_code_delete != null){
        facultyService.deleteFaculty(faculty_code_delete);
    }
%>

<!DOCTYPE html>
    <head>
        <title>Faculty-form</title>
        <link href = "style.css" type = "text/css" rel = "stylesheet">
    </head>

    <header>
        <div class="text1">
            <h2>University Admission</h2>
        </div>
    </header>

    <div class="topnav">
        <ul>
            <li><a class="active" href="index.jsp">HOME</a></li>

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
        <div class="row">
            <h2>Faculty form</h2>

            <form method="post" class="formbox1">
                <h3>Add a new faculty</h3>

                <div class="continut">
                    <p>Faculty name:</p>
                    <input type="text" name="faculty_name">
                </div>

                <div class="continut">
                    <p>Budget number positions:</p>
                    <input type="text" name="budget">
                </div>

                <div class="continut">
                    <p>Toll number positions:</p>
                    <input type="text" name="toll">
                </div>

                <div class="continut">
                    <input type="Submit" value="ADD" class="btn">
                </div>
                <br>
            </form>

            <hr><br>

            <form method="post" class="formbox2">
                <h3>Update the name of a faculty by faculty code:</h3>

                <div class="continut">
                    <p>Faculty code:</p>
                    <input type="text" name="faculty_code">
                </div>

                <div class="continut">
                    <p>New faculty name:</p>
                    <input type="text" name="new_faculty_name">
                </div>

                <div class="continut">
                    <input type="Submit" value="UPDATE" class="btn">
                </div>
                <br>
            </form>

            <hr> <br>

            <form method="post" class="formbox3">
                <h3>Delete a faculty by faculty code:</h3>

                <div class="continut">
                    <p>Faculty code:</p>
                    <input type="text" name="faculty_code_delete">
                </div>

                <div class="continut">
                    <input type="Submit" value="DELETE" class="btn">
                </div>
                <br>
            </form>
        </div>
    </body>
</DOCTYPEhtml>

