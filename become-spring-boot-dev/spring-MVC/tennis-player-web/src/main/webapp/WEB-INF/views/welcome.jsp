<%@page import="java.time.LocalDate" %>

    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Tennis Player DB</title>
    </head>

    <body>
        <% LocalDate currentDate=LocalDate.now(); %>

            <h2>Welcome to the tennis player database!</h2>
            <h3>Player name: <i>${name}</i></h3>
            <p>Current date: <%=currentDate %>
            </p>
            <p>Today is: <%= currentDate.getDayOfWeek() %>
            </p>
            <form action="/player.do" method="POST">
                <b>Player name:</b> <input type="text" name="name" />
                <input type="submit" value="Enter" />
            </form>
    </body>

    </html>