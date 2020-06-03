
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="Model.Specialization,Service.SpecializationService"%>


<%

    SpecializationService specializationService = SpecializationService.getInstance();
    String facultyCode = request.getParameter("faculty_code");
    String nameSpec = request.getParameter("name_spec");
    String budget = request.getParameter("budget");
    String toll = request.getParameter("toll");
    String code_up = request.getParameter("code_update");
    String new_name =  request.getParameter("new_name_spec");
    String code_del = request.getParameter("code_delete");

    if(code_up != null &&
            new_name != null){
        specializationService.updateSpecializationName(code_up, new_name);
    }

    if(code_del != null){
        specializationService.deleteSpecialization(code_del);
    }

    int nrbudget = 0;
    int nrtoll = 0;
    if(budget != null)
        nrbudget = Integer.parseInt(budget);

    if(toll != null)
        nrtoll = Integer.parseInt(toll);

    try
    {
        if(facultyCode != null && nameSpec != null &&
                nrbudget != 0 && nrtoll != 0){

            specializationService.addSpecialization(new Specialization(facultyCode, nameSpec, nrbudget, nrtoll));
            //out.println("The specialization was added successfully!");

        }

    }
    catch(Exception e)
    {
        System.out.print(e);
        e.printStackTrace();
    }

%>

<!DOCTYPE html>
    <head>
        <title>Specialization-form</title>
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
                <a class="active" href="index.jsp">HOME</a
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
        <h2>Specialization form</h2>
        <div class="row">
            <form method="post" class="formbox1">
                <h3>Add a new specialization</h3>
                <div class="continut">
                    <p>Specialization name:</p>
                    <input type="text" name="name_spec">
                </div>

                <div class="continut">
                    <p>Faculty code:</p>
                    <input type="text" name="faculty_code">
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

            <hr> <br>

            <form method="post" class="formbox2">
                <h3>Update specialization name</h3>
                <div class="continut">
                    <p>New specialization name:</p>
                    <input type="text" name="new_name_spec">
                </div>

                <div class="continut">
                    <p>Specialization code:</p>
                    <input type="text" name="code_update">
                </div>

                <div class="continut">
                    <input type="Submit" value="UPDATE" class="btn">
                </div>
                <br>
            </form>

            <hr> <br>

            <form method="post" class="formbox3">
                <h3>Delete a specialization </h3>

                <div class="continut">
                    <p>Specialization code:</p>
                    <input type="text" name="code_delete">
                </div>

                <div class="continut">
                    <input type="Submit" value="DELETE" class="btn">
                </div>
            </form>
        </div>
    </body>
</DOCTYPEhtml>

