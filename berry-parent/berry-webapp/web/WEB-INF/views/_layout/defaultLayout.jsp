<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
    <title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" type="image/png" sizes="32x32" href="/public/icon/favicon-32x32.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
    <link rel="stylesheet" href="/public/css/style.css">
    <link rel="stylesheet" href="/public/css/project.css">

    <meta name="theme-color" content="#ffffff">
</head>
<body>
<div class="page">
    <tiles:insertAttribute name="header" />
        <div class="container">

            <div class="blog-header">
                <h1 class="blog-title">Title</h1>
                <p class="lead blog-description">Description</p>
            </div>

            <div class="row">

                <div class="col-sm-8 blog-main">
                    <tiles:insertAttribute name="body" />
                </div>
                <tiles:insertAttribute name="sidebar" />
            </div>

        </div>

    <tiles:insertAttribute name="footer" />
</div>
</body>
</html>
