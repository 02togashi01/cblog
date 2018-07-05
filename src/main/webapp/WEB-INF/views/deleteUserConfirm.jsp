<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<form action="deleteUserResult" method="post">
     <div>
<span class="adminspan">ID：</span><input class="admintext" type="text" value="${users.user_id} "readonly>
    </div>
    <div>
<span class="adminspan">名前：</span><input class="admintext" type="text" value="${users.name}" readonly>
    </div>
  <div class="col-clear">
    <button class="adminbutton" type="submit" name="button" value="確認">確認</button>
    <button class="adminbutton" type="submit" name="button" value="戻る" onclick="location.href='deleteUser'; return false;">戻る</button>
  </div>
</form>
<divclass="link">
  <a href="masterMenu">メニューに戻る</a>
</div>
  </fieldset>
</body>
</html>
