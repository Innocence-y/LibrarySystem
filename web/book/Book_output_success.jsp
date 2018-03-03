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
        border: 1px none;
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
        margin-top:20px;
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
        text-align:left;
        width:98%;
        font-size:16px;
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
    <h1 align="center"> 数据库导出成功 ！已成功导出数据到本地</h1>
</div>
</body>
</html>