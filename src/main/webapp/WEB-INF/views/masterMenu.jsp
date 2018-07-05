<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>管理者メニュー</title>

<!-- Bootstrap core CSS -->
<link href="clean/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="clean/css/clean-blog.min.css" rel="stylesheet">

</head>
<body>


	<!-- Page Header -->
	<header class="masthead"
		style="background-image: url('clean/img/home-bg.jpg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="site-heading">
						<h1>管理者メニュー</h1>
						<span class="subheading">C-blog </span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="post-preview">
					<a href="articleList">
						<h2 class="post-title">記事一覧</h2>
					</a>
					<p class="post-meta">記事の閲覧ができます。</p>
				</div>
				<hr>
				<div class="post-preview">
					<a href="contribution">
						<h2 class="post-title">記事投稿</h2>
					</a>
					<p class="post-meta">新しく記事を投稿できます。</p>
				</div>
				<hr>
				<div class="post-preview">
					<a href="articleEdit">
						<h2 class="post-title">記事編集</h2>
					</a>
					<p class="post-meta">既存の記事を編集します。</p>
				</div>

				<hr>
				<div class="post-preview">
					<a href="bgc">
						<h2 class="post-title">記事背景変更</h2>
					</a>
					<p class="post-meta">記事の背景を変更します。</p>
				</div>

				<hr>
				<div class="post-preview">
					<a href="layout">
						<h2 class="post-title">レイアウト変更</h2>
					</a>
					<p class="post-meta">記事一覧画面のレイアウトを変更できます。</p>
				</div>

				<hr>
				<div class="post-preview">
					<a href="headerImput">
						<h2 class="post-title">ヘッダー文字変更</h2>
					</a>
					<p class="post-meta">ヘッダーの文字を変更できます。</p>
				</div>

				<hr>
				<div class="post-preview">
					<a href="deleteUser">
						<h2 class="post-title">アカウント管理</h2>
					</a>
					<p class="post-meta">アカウント情報の変更を行います。</p>
				</div>

				<!-- Pager -->
				<div class="clearfix">
					<a class="btn btn-primary float-right" href="logout">ログアウト</a>
				</div>
			</div>
		</div>
	</div>

	<hr>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<ul class="list-inline text-center">
						<li class="list-inline-item"><a href="#"> <span
								class="fa-stack fa-lg"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-twitter fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
						<li class="list-inline-item"><a href="#"> <span
								class="fa-stack fa-lg"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-facebook fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
						<li class="list-inline-item"><a href="#"> <span
								class="fa-stack fa-lg"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-github fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
					</ul>
					<p class="copyright text-muted">Copyright &copy; Your Website
						2018</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="clean/vendor/jquery/jquery.min.js"></script>
	<script src="clean/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="clean/js/clean-blog.min.js"></script>

</body>
</html>
