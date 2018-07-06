<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>ヘッダー文字変更画面</title>
<link href="css/admin.css" rel="stylesheet" type="text/css" />
</head>
<link href="css/admincss.css" rel="stylesheet" type="text/css" />
</head>
<body class="adminbody">
	<form:form action="headerResult" method="post">
		<fieldset class="article">
			<p>
				ヘッダーの文字を変更します<br>
			</p>

			<div>
				<span class="adminspan">タイトル：&nbsp;</span>
				<form:input placeholder="${headerText}" path="header"></form:input>
			</div>
			<div>
				<span class="adminspan">サブタイトル：&nbsp;</span>
				<form:input placeholder="${subHeaderText}" path="subHeader"></form:input>
			</div>

			<button class="adminbutton" type="submit" value="確認">確認</button>
			<button class="adminbutton" type="submit" name="button" value="戻る"
				onclick="location.href='masterMenu'; return false;">戻る</button>

		</fieldset>
	</form:form>
</body>
</html>
