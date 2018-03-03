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
        body{
            margin:0px;
            padding:0px;
            overflow:hidden;
        }
        #wrapper{
            position:absolute;
            width:100%;
            height:100%;
            min-width:1280px;
            min-height:680px;
            overflow-x:hidden;
            overflow-y:hidden;
            background-image: -moz-linear-gradient(top,#77D1F6, #2F368F);
            background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #77D1F6),color-stop(1, #2F368F));
        }
        #header{
            height:100px;
            width:100%;
        }
        #logo{
            position:absolute;
            float:left;
            margin-left:5%;
            margin-top:30px;
            height:40px;
            width:160px;
            text-align:center;
        }
        #heading{
            position:relative;
            float:left;
            margin-left:20%;
            margin-top:-18px;
            height:110px;
            width:60%;
            border-radius: 18px;
            background-color:#1C75BC;
            opacity:0.6;
        }
        #heading #title{
            margin-top:40px;
            text-align:center;
            font-family:微软雅黑;
            font-size:24px;
            font-weight:bold;
        }
        #heading #subTitle{
            margin-top:10px;
            text-align:center;
            font-family:Courier New;
        }
        #main{
            margin-top:20px;
            height:500px;
            width:100%;
        }
        #mainBg{
            position:relative;
            float:left;
            margin-left:20%;
            margin-top:0px;
            height:500px;
            width:60%;
            border-radius: 18px;
            background-color:#000000;
            opacity:0.5;
        }
        #mainPanel{
            position:relative;
            margin:25px;
            height:450px;
            border-radius: 18px;
            background-image: -moz-linear-gradient(top,#EBEBEB, #BFBFBF);
            background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),color-stop(1, #BFBFBF));
        }
        #mainPanel #left{
            float:left;
            border-right:2px solid #F6F6F6;
            position:relative;
            top:10%;
            height:80%;
            width:49%;
            border-right-style:groove;
        }
        #mainPanel #image{
            position:relative;
            height:256px;
            width:256px;
            left:15%;
            top:12%;
            background-image:url('../images/admin.png');
        }
        #mainPanel #right{
            float:left;
            position:relative;
            height:90%;
            width:49%;
            top:5%;
        }
        #welcome{
            margin-top:20px;
            height:60px;
            width:100%;
            vertical-align: middle;
            display: inline-block;
            line-height: 60px;
            text-align:center;
        }
        #welcome #welcome-text{
            font-size:38px;
            font-weight:bold;
            font-family:微软雅黑;
            text-shadow: 0 1px 1px #F6F6F6;
        }
        #user-name{
            height:20px;
            width:100%;
            margin-top:20px;
            vertical-align: middle;
            display: inline-block;
            line-height: 35px;
        }
        #user-password{
            margin-top:20px;
            height:20px;
            width:100%;
            vertical-align: middle;
            display: inline-block;
            line-height: 35px;
        }
        #user-checkcode{
            margin-top:20px;
            height:35px;
            width:100%;
            vertical-align: middle;
            display: inline-block;
            line-height: 35px;
        }
        #button-group{
            margin-top:10px;
            margin-left:200px;
            height:35px;
            width:100%;
            vertical-align: middle;
            display: inline-block;
            line-height: 35px;
        }
        #error-tip{
            margin-top:20px;
            margin-left:5%;
            height:40px;
            width:90%;
            vertical-align: middle;
            display: inline-block;
            line-height: 35px;
            text-align:center;
            border-bottom:2px solid #F6F6F6;
            border-bottom-style:groove;
        }
        #error-tip #tip-text{
            font-size:18px;
            font-weight:bold;
            font-family:微软雅黑;
            color:red;
        }
        .item{
            margin-left:20px;
            font-family:微软雅黑;
            font-size:20px;
            font-weight:bold;
            float: left;
            width:80px;
            margin-top: 3px;
            text-align: center;
            text-shadow: 0 1px 1px #F6F6F6;
        }
        .input{
            vertical-align: middle;
            display: inline-block;
        }
        #checkcode-img{
            margin-top:3px;
            height:20px;
            width:60px;
        }
        .form-input{
            height:20px;
        }
        .btn{
            border:1px solid #cccccc;
            cursor:pointer;
            margin:10px 5px;
            height:40px;
            width:80px;
            text-align:center;
            border-radius: 4px;
            border-color: #636263 #464647 #A1A3A5;
            text-shadow: 0 1px 1px #F6F6F6;
            background-image: -moz-linear-gradient(center top, #D9D9D9, #A6A6A6 49%, #A6A6A6 50%);
            background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #D9D9D9),color-stop(1, #A6A6A6));
        }
        #footer{
            margin-top:20px;
            width:100%;
        }
        #footer #text{
            text-align:center;
            font-size:14px;
            font-family:微软雅黑;
            font-weight:bold;
        }
    </style>
<body>
<script type="text/javascript" src="../js/Calendar3.js"></script>

<div id="navi">
	<div id='naviDiv'>
	</div>
</div>
<div id="tips">
</div>
<div id="mainContainer">

<br>
<br>
<table class="default" width="100%">
  <s:form name="modifyForm" action="updateaction" method="POST">
    <s:hidden name="id" value="%{#request.id}"></s:hidden>
      <s:hidden name="username" value="%{#session.username}"></s:hidden>
      <div id="user-name">
          <span class="item">学&nbsp;&nbsp;&nbsp;院:</span>
          <span><select name="college">
                                <option value="软件学院">软件学院</option>
                                <option value="艺术学院">艺术学院</option>
                                <option value="理学院">理学院</option>
                                <option value="化工学院">化工学院</option>
                                 <option value="人文学院">人文学院</option>
                                 <option value="经管学院">经管学院</option>
                                 <option value="体育学院">体育学院</option>
                            </select></span>
      </div>
      <div id="user-name">
          <span class="item">年&nbsp;&nbsp;&nbsp;级:</span>
          <span><select name="year">
                                <option value="大一">大一</option>
                                <option value="大二">大二</option>
                                <option value="大三">大三</option>
                                <option value="大四">大四</option>
                            </select></span>
      </div>
      <div id="user-name">
          <span class="item">专&nbsp;&nbsp;&nbsp;业:</span>
          <span><input type="text" name="major" ></span>
      </div>
      <div id="user-name">
          <span class="item">类&nbsp;&nbsp;&nbsp;型:</span>
          <span><select name="type">
                                <option vaule="教师">教师</option>
                                <option value="学生">学生</option>
                            </select></span>
      </div>
      <div id="user-name">
          <span class="item">用户名:</span>
          <span><input type="text" name="username" ></span>
      </div>
      <div id="user-password">
          <span class="item">密&nbsp;&nbsp;&nbsp;码:</span>
          <span class="input"><input type="password" name="password" ></span>
      </div>
      <div id="user-name">
          <span class="item">性&nbsp;&nbsp;&nbsp;别:</span>
          <span>
                                <select name="sex">
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </span>
      </div>
      <div id="button-group">
          <input type="submit" class="btn" value="提交">
      </div>
  </s:form>
</table>
</div>
</body>
</html>