<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
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
            <div class="row">
                <div class="continut">
                    <h2> Candidate options</h2>
                </div>

                <div class="continut">
                    <a href="only_for_candidate.jsp">
                        <input type="Submit" value="Faculty Registration Form">
                    </a>
                </div>

                <br> <br> <br> <br>

                <div class="continut">
                    <a href="only_for_candidate1.jsp">
                        <input type="Submit" value="Application Candidate">
                    </a>
                </div>
            </div>
        </body>
</html>
