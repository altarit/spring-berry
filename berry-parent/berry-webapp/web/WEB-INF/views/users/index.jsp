<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading"><span class="lead">List of Users </span></div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Username</th>
            <th>Email</th>
            <th width="100"></th>
            <th width="100"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td><a href="<c:url value='/registration/${user.username}' />" class="btn btn-success custom-width">edit</a></td>
                <td><a href="<c:url value='/deletion/${user.username}' />" class="btn btn-danger custom-width">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="well">
    <a href="<c:url value='/registration' />">Add New User</a>
</div>
