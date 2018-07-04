<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <meta name="description" content="">
     <meta name="author" content="">

<title>更新内容入力画面</title>

	<link href="css/mypage.css" rel="stylesheet" type="text/css"/>
	<link href="css/admincss.css" rel="stylesheet" type="text/css"/>
</head>

	<body class="userbody">
		<form action="userUpdateConfirm.html" method="post">
		<fieldset class="article">
			<p>１箇所以上の項目を変更してください<br>

				<div>
					<span class="adminspan">ID：</span><input class="admintext" type="text" value="101" >
				</div>
				<div>
					<span class="adminspan">name：</span><input class="admintext" type="text" value="alice">
				</div>
				<div>
					<span class="adminspan">PASS：</span><input class="admintext" type="password" value="alicesos">
				</div>

				<button class="adminbutton" type="submit" value="確認">確認</button>
 				<button class="adminbutton" type="submit" name="button" value="戻る" onclick="location.href='menu.html'; return false;">戻る</button>

			</fieldset>
		</form>
	</body>
</html>





