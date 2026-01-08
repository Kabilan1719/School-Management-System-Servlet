<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>School Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    .header {
        background: #e44c5b;
        color: white;
        padding: 20px;
    }
    .module {
        text-align: center;
        padding: 30px 20px;
        border: 1px solid #e0e0e0;
        border-radius: 8px;
        background: white;
        transition: 0.3s;
        cursor: pointer;
    }
    .module img {
        width: 60px;
        height: 60px;
        margin-bottom: 15px;
    }
    .module button {
        border: none;
        background: none;
        font-weight: 600;
    }
</style>
</head>
<body class="bg-light">
<div class="header d-flex align-items-center">
    <h4 class="mx-auto mb-0">School Management System</h4>
    <form action="logout" class="position-absolute end-0 me-4">
        <button type="submit" class="btn btn-outline-light">Logout</button>
    </form>
</div>
<div class="container mt-5" style="max-width:75%;">
    <div class="row g-4">
        <div class="col-md-3">
            <form action="register.jsp">
                <div class="module">
                    <img src="https://cdn-icons-png.flaticon.com/512/167/167707.png">
                    <button type="submit">Add User</button>
                </div>
            </form>
        </div>
        <div class="col-md-3">
            <form action="getall">
                <div class="module">
                    <img src="https://cdn-icons-png.flaticon.com/512/747/747376.png">
                    <button type="submit">Get All</button>
                </div>
            </form>
        </div>
        <div class="col-md-3">
            <form action="sortbyname">
                <div class="module">
                    <img src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png">
                    <button type="submit">Sort by Name</button>
                </div>
            </form>
        </div>
        <div class="col-md-3">
            <form action="sortbyage">
                <div class="module">
                    <img src="https://cdn-icons-png.flaticon.com/512/3209/3209265.png">
                    <button type="submit">Sort by Age</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
