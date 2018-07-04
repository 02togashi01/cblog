<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
<link href="css/mypage.css" rel="stylesheet" type="text/css"/>
<title>退会確認画面</title>
</head>

	<body class="userbody">
			<form action="userDeleteResult.html" method="post">

	 <fieldset class="article">

	<p>退会します。よろしいですか？</p>

	     <div>
	<span class="userspan">ID：</span><input class="admintext" type="text" value="101" readonly>
	    </div>
	    <div>
	<span class="userspan">名前：</span><input class="admintext" type="text" value="ほりほり" readonly>
	    </div>
			  <div class="col-clear">
			    <button class="mypagebutton" type="submit" name="button" value="削除">退会</button>
			    <button class="mypagebutton" type="submit" name="button" value="戻る" onclick="location.href='menu.html'; return false;">戻る</button>
			  </div>
			</form>
	  </fieldset>
	</body>
</html>
