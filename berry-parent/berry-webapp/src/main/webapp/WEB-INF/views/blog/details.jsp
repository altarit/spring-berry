<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="blog-title">${post.title}</h1>

<div class="blog-post">
        ${post.source}
</div>


<nav>
    <ul class="pager">
        <li><a href="<c:url value='/blog/posts/' />">Назад</a></li>
        <li><a href="<c:url value='/blog/editor/${post.id}' />">Править</a></li>
    </ul>
</nav>
