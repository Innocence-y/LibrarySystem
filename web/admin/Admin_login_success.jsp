<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>

	<title>图书管理系统</title>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/index.css" />
	<script type="text/javascript">
        function screenAdapter(){
            document.getElementById('footer').style.top=document.documentElement.scrollTop+document.documentElement.clientHeight- document.getElementById('footer').offsetHeight+"px";
            document.getElementById('navigator').style.height=document.documentElement.clientHeight-100+"px";
            document.getElementById('main').style.height=document.documentElement.clientHeight-100+"px";
            document.getElementById('main').style.width=window.screen.width-230+"px";
        }

        window.onscroll=function(){screenAdapter();};
        window.onresize=function(){screenAdapter();};
        window.onload=function(){screenAdapter();};
	</script>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">LOGO</div>
		<div id="title">图书管理系统</div>
		<div id="user_info">
			<div id="welcome">欢迎<span id="red">${sessionScope.admin.username}</span>管理员</div>
			<div id="logout"><a href="adminlogoutaction">安全退出</a></div>
		</div>
	</div>
	<div id="navigator">
		<iframe src="../tree.jsp"></iframe>
        </div>
	<div id="main">
		<iframe name="MainFrame" src="../user/Users_login_main.jsp"></iframe>
	</div>
	<div id="footer"></div>
</div>
</body>
</html>