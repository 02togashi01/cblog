<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>ユーザー一覧</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="css/admincss.css" rel="stylesheet" type="text/css" />
</head>
<body class="adminbody">
	<h1>アカウント管理</h1>
	<a href="masterMenu">メニューに戻る</a>
	<div class="article">
		<div class="link">
			<table>
				<thead>
					<tr>
						<th>ユーザーID</th>
						<th>ユーザー名</th>
						<th>削除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${user}">
						<tr>
						<form:form action="deleteUserConfirm">
							<form:hidden path="user_id" value="${fn:escapeXml(list.user_id)}"></form:hidden>
							<td>${fn:escapeXml(list.user_id)}</td>
							<td>${fn:escapeXml(list.name)}</td>
							<td><input type="submit" value="削除"></td>
								</form:form>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
