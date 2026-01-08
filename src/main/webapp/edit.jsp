<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="schoolManagement.entity.student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
    <div class="card shadow p-4" style="width: 420px;">
        <h3 class="text-center mb-4 text-primary">Edit Student</h3>
        <%
            student st = (student) request.getAttribute("student");
        %>
        <form action="update" method="post">
            <div class="mb-3">
                <label class="form-label">User ID</label>
                <input type="text" name="id" class="form-control"
                       value="<%= st.getId() %>" readonly>
            </div>
            <div class="mb-3">
                <label class="form-label">Username</label>
                <input type="text" name="name" class="form-control"
                       value="<%= st.getName() %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Age</label>
                <input type="number" name="age" class="form-control"
                       value="<%= st.getAge() %>" required>
            </div>
            <button type="submit" class="btn btn-warning w-100">Update</button>
        </form>
    </div>
</div>
</body>
</html>
