<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>新規登録画面</title>
<link href="css/mypage.css" rel="stylesheet" type="text/css" />
</head>
<link href="css/admincss.css" rel="stylesheet" type="text/css" />
</head>

<body class="userbody">
	<form:form action="registerConfirm"  modelAttribute="command" method="post">
		<fieldset class="article">
			<p>
				必要項目を入力してください<br>
			</p>
			<p>※は必須です</p>

			<c:if test="${not empty msg}">
				<div class="message">
					<p class="required">${msg}</p>
				</div>
			</c:if>

			<div>
				<span class="adminspan">※ID：</span>
				<form:input path="registerid" class="admintext" type="text" />
			</div>
			<div>
				<span class="adminspan">※NAME：</span>
				<form:input path="registername" class="admintext" type="text" />
			</div>
			<div>
				<span class="adminspan">※PASS：</span>
				<form:input path="registerpass" class="admintext" type="password" />
			</div>
			<form:button class="adminbutton" type="submit" value="確認">確認</form:button>
			<button class="adminbutton" type="submit" name="button" value="戻る"
				onclick="location.href='index'; return false;">戻る</button>

		</fieldset>
	</form:form>
</body>
</html>





