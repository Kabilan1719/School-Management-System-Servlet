<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,schoolManagement.entity.student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5" style="max-width: 75%;">
    <h2 class="text-center text-primary mb-4">Student Details</h2>
    <%
        List<student> students = (List<student>) request.getAttribute("student");
        if (students != null && !students.isEmpty()) {
    %>
    <div class="table-responsive">
        <table class="table table-bordered table-hover text-center align-middle">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                </tr>
            </thead>
            <tbody>
            <% for (student st : students) { %>
                <tr>
                    <td><%= st.getId() %></td>
                    <td><%= st.getName() %></td>
                    <td><%= st.getAge() %></td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </div>
    <% } else { %>
        <div class="alert alert-warning text-center">
            No data found
        </div>
    <% } %>
</div>
</body>
</html>