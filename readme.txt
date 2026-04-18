This Java Application is a command line based interface for a mySQL database.

How to run application:

    Ensure you have a mySQL server running.
    In mySQL Workshop, import the project.sql file (found in this repo) into its own new database called "auto_company_db_v2".
    In DBConnector.java, change NAME, ROUTE, USER, and PASSWORD to match your personal server.
    This is found on line 8 within the parentheses for getConnection as seen below:

    %.getConnection("jdbc:mysql://[NAME]:[ROUTE]/auto_company_db_v2", "[USER]", "[PASSWORD]")

    Now, run Main.java and view the terminal for outputs.