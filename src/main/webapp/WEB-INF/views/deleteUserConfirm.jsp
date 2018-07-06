<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <meta name="description" content="">
     <meta name="author" content="">
<link href="css/admincss.css" rel="stylesheet" type="text/css"/>

</head>
<body class="adminbody">
 <fieldset class="article">

<p>これでよろしいですか？</p>

<form:form action="deleteUserResult" method="post">
     <div>
<span class="adminspan">ID：</span><form:input class="admintext" path="user_id" value="${deleteUser.user_id}" readonly="true"></form:input>
    </div>
    <div>
<span class="adminspan">名前：</span><form:input class="admintext" value="${deleteUser.name}" path="name" readonly="true"></form:input>
    </div>
  <div class="col-clear">
    <button class="adminbutton" type="submit" name="button" value="確認">確認</button>
    <button class="adminbutton" type="submit" name="button" value="戻る" onclick="location.href='deleteuser'; return false;">戻る</button>
  </div>
</form:form>
<div class="link">
  <a href="masterMenu">メニューに戻る</a>
</div>
  </fieldset>
</body>
</html>
