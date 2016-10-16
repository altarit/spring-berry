<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="well lead">Авторизация</div>


<div class="blog-post">
    <div class="tab-content" col-lg-6>
        <br/>

        <form class="form-horizontal login-form" name="login-form" th:action="@{/login}" method="POST">
            <div class="form-group">
                <label for="input-username" class="col-lg-2 control-label">Никнейм</label>
                <div class="col-lg-10">
                    <input name="username" value="" type="text" class="form-control" id="input-username" placeholder="Имя">
                </div>
            </div>
            <div class="form-group">
                <label for="input-password" class="col-lg-2 control-label">Пароль</label>
                <div class="col-lg-10">
                    <input name="password" value="" type="password" class="form-control" id="input-password" placeholder="Пароль">
                </div>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <button type="submit" class="btn btn-primary" data-loading-text="Отправляю...">Отправить</button>
                </div>
            </div>
        </form>
    </div>
</div>

