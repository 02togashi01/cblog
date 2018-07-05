<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>ユーザー一覧</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="css/admincss.css" rel="stylesheet" type="text/css"/>
</head>
<body class="adminbody">
	<h1>アカウント管理</h1>
	<a href="masterMenu">メニュー</a>
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
					<tr>
						<td>${users.user_id}</td>
						<td>${users.name}</td>
						<td>
							<form action="deleteUserConfirm" method="post"><input type="submit"value="削除">
							</form>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
