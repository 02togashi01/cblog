<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <meta name="description" content="">
     <meta name="author" content="">
<title>更新内容確認画面</title>
	<link href="css/mypage.css" rel="stylesheet" type="text/css"/>
	<link href="css/admincss.css" rel="stylesheet" type="text/css"/>
	<style>
		.col {
		  float: left;
		}
		.col-clear {
		  clear: both;
		}

		#arrow {
		  margin-top: 60px;
		}
	</style>
</head>

<body class="userbody">
	<p><h1>これでよろしいですか？</h1></p>
		<form action="userUpdateResult.html" method="post">

	 <fieldset class="article">
	    <h3>変更前</h3>
	    <div>
	      <span class="adminspan">ID</span><input type="text" class="admintext" value="${users.user_id}" disabled>
	    </div>
	    <div>
	      <span class="adminspan">name</span><input type="text" class="admintext" value="${users.name}" disabled>
	    </div>
	    <div>
	      <span class="adminspan">PASS</span><input type="password" class="admintext" value="${users.pass}" disabled>
	    </div>
	  </fieldset>

	 <fieldset class="article">
	    <h3>変更後</h3>
	    <p>PASSを再入力してください</p>

	    <div>
	      <span class="adminspan">ID</span><input type="text" class="admintext" name="newName" value="${newUser.userId}" readonly>
	    </div>
	    <div>
	       <span class="adminspan">name</span><input type="text" class="admintext" name="newTel" value="${newUser.userName}" readonly>
	    </div>
	    <div>
	       <span class="adminspan">PASS</span><input type="password" class="admintext" name="rePass">
	    </div>
	  </fieldset>

	  <div class="col-clear">
	    <input type="submit" name="button" class="adminbutton" value="更新">
	    <input type="submit" name="button" class="adminbutton" value="戻る" onclick="location.href='userUpdateInput'; return false;">
	  </div>

	</form>
		<div>
		  <a href="menu.html">メニューに戻る</a>
		</div>
	</body>
</html>
