<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<h1 class="blog-title">Delete ${username} ?</h1>

<form:form method="POST" class="form-horizontal" action="/deletion/${username}">
    <div class="row">
        <div class="form-actions floatRight">
            <input type="submit" value="Delete" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/users/' />">Cancel</a>
        </div>
    </div>
</form:form>

