<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<meta http-equiv="content-type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/default.css" />
<style type="text/css">
* {
    background: none repeat scroll 0 0 transparent;
    border: 0 none;
    margin: 0;
    padding: 0;
    vertical-align: baseline;
	font-family:微软雅黑;
	overflow:hidden;
}
#navi{
	width:100%;
	position:relative;
	word-wrap:break-word;
	border-bottom:1px solid #065FB9;
	margin:0;
	padding:0;
	height:40px;
	line-height:40px;
	vertical-align:middle;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, 
#BFBFBF));
}
#naviDiv{
	font-size:14px;
	color:#333;
	padding-left:10px;
}
#tips{
	margin-top:10px;
	width:100%;
	height:40px;
}
#buttonGroup{
	padding-left:10px;
	float:left;
	height:35px;
}
.button{
	float:left;
	margin-right:10px;
	padding-left:10px;
	padding-right:10px;
	font-size:14px;
	width:70px;
	height:30px;
	line-height:30px;
	vertical-align:middle;
	text-align:center;
	cursor:pointer;
    border-color: #77D1F6;
    border-width: 1px;
    border-style: solid;
    border-radius: 6px 6px;
    -moz-box-shadow: 2px 2px 4px #282828;
    -webkit-box-shadow: 2px 2px 4px #282828;
    background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
    background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, #BFBFBF));
}
#mainContainer{
	padding-left:10px;
	padding-right:10px;
	text-align:center;
	width:98%;
	font-size:12px;
}
</style>
<body>
<div id="navi">
	<div id='naviDiv'>
	</div>
</div>

<div id="mainContainer">
<table class="default" width="100%">
	<tr class="title">
		<td>学院</td>
		<td>年级</td>
		<td>专业</td>
		<td>类型</td>
		<td>账户</td>
		<td>密码</td>
		<td>姓别</td>
		<td>操作</td>
	</tr>
	<s:iterator value="userlist" id="user" status="st">
		<tr>
			<td><s:property value="#user.college" /></td>
			<td><s:property value="#user.year" /></td>
			<td><s:property value="#user.major" /></td>
			<td><s:property value="#user.type" /></td>
			<td><s:property value="#user.username" /></td>
			<td><s:property value="#user.password" /></td>
			<td><s:property value="#user.sex" /></td>
			<td>
				<a href='transformaction?id=<s:property value='#user.id'/>'>修改</a>
				<a href='deleteaction?username=<s:property value='#user.username'/>' onclick="javascript: return confirm('真的要删除吗？');" />删除</a>
			</td>
		</tr>
	</s:iterator>
</table>
</div>
</body>
</html>