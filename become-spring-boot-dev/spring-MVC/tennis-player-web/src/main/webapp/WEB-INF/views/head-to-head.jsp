<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <!DOCTYPE html>
    <html>

    <head>
        <title>Head-to-Head</title>
        <style>
            .error {
                color: red;
                font-style: italic;
            }
        </style>
    </head>

    <body>
        <h2>Head-to-Head Statistics</h2>
        <hr>
        <form:form action="processStatsForm" modelAttribute="playerStats">

            <br><br>
            Player 1:
            <form:input path="playerOne" /> &emsp; vs. &emsp;

            Player 2:
            <form:input path="playerTwo" />

            <br><br>
            Head-to-Head *:
            <form:input path="head2head" placeholder="##-##" />
            <form:errors path= "head2head" cssClass="error"/>

            <br><br>
            <input type="submit" value="Submit" />

        </form:form>

    </body>

    </html>