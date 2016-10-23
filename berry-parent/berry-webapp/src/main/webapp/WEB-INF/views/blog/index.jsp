<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="blog-title">Блог</h1>

<c:forEach items="${posts}" var="post">
    <div class="blog-post">
        <a href="<c:url value='/blog/posts/${post.id}' /> "><h2 class="blog-post-title">${post.title}</h2></a>
        <form method="POST" class="inline" action="/blog/posts/{{_id}}/deleter/">
            <button type="submit">Delete</button>
        </form>
        <form method="GET" class="inline" action="/blog/posts/{{_id}}/editor/">
            <button>Edit</button>
        </form>
    </div>
</c:forEach>

