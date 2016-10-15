<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="well lead">User Registration Form</div>

<form:form method="POST" modelAttribute="user" class="form-horizontal" action="/registration/${edit ? user.username : null}">
    <form:input type="hidden" path="id" id="id"/>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="username">Username</label>
            <div class="col-md-7">
                <c:choose>
                    <c:when test="${edit}">
                        <form:input type="text" path="username" id="username" class="form-control input-sm" disabled="false" />
                    </c:when>
                    <c:otherwise>
                        <form:input type="text" path="username" id="username" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="username" class="help-inline"/>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="password">Password</label>
            <div class="col-md-7">
                <form:input type="password" path="password" id="password" class="form-control input-sm" />
                <div class="has-error">
                    <form:errors path="password" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="email">Email</label>
            <div class="col-md-7">
                <form:input type="text" path="email" id="email" class="form-control input-sm" />
                <div class="has-error">
                    <form:errors path="email" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="userProfiles">Roles</label>
            <div class="col-md-7">
                <form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />
                <div class="has-error">
                    <form:errors path="userProfiles" class="help-inline"/>
                </div>
            </div>
        </div>
    </div>


    <div class="row">
        <div class="form-actions floatRight">
            <c:choose>
                <c:when test="${edit}">
                    <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/users/' />">Cancel</a>
                </c:when>
                <c:otherwise>
                    <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/users/' />">Cancel</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</form:form>

