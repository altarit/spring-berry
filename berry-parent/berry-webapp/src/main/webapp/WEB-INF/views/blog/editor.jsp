<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<h1 class="blog-title">Редактор</h1>

<form:form method="POST" modelAttribute="post" class="form-horizontal" action="/blog/editor/${edit ? post.id : null}">
    <form:input type="hidden" path="id" id="id"/>

    <div class="form-group">
        <label for="title" class="col-lg-12">Заголовок</label>
        <div class="col-lg-12">
            <form:input path="title" type="text" class="form-control" />
            <div class="has-error">
                <form:errors path="title" class="help-inline"/>
            </div>
        </div>
    </div>

    <div class="form-group">
        <label for="source" class="col-lg-12">Содержание статьи</label>
        <div class="col-lg-12">
            <form:textarea path="source" class="form-control" />
            <div class="has-error">
                <form:errors path="source" class="help-inline"/>
            </div>
        </div>
    </div>


    <div class="row">
        <div class="form-actions floatRight">
            <c:choose>
                <c:when test="${edit}">
                    <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/blog/posts/' />">Cancel</a>
                </c:when>
                <c:otherwise>
                    <input type="submit" value="Create" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/blog/posts/' />">Cancel</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</form:form>
