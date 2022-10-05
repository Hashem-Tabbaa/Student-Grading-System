<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import ="java.util.*" %>
<%@ page import ="model.*" %>
<%@ page import ="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <title>Statistics Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </head>
    <body>
        <h1  class="text-center mt-5 pt-5">Course statistics page</h1>
        <div>
            <% List<Statistics> statistics = (List<Statistics>) request.getAttribute("statistics"); %>
                <table class = "table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Number</th>
                            <th scope="col" >Statistics Type</th>
                            <th scope="col" >Value</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (int i = 0; i < statistics.size(); i++) { %>
                            <tr>
                                <th scope="row"><%= i+1 %></th>
                                <td><%= statistics.get(i).getStatisticType() %></td>
                                <td><%= statistics.get(i).getValue() %></td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            <div style="text-align: center;" class="mt-5">
                <a href="logout" class="m-auto btn btn-warning">Logout</a>
            </div>
        </div>

    </body>

</html>