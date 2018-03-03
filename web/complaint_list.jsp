
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
</div>
<div id="mainContainer" align="center">
    <br><br>
    <h1><a href="html/barNum.html">图书借阅数量统计柱状图</a><br></h1><br><br>
    <h1><a href="html/BarXueyuan.html">学院分布分布柱状图</a><br></h1><br><br>
    <h1><a href="html/BingTuNum.html">借书情况统计饼状图</a><br></h1><br><br>
    <h1><a href="html/BingTuSex.html">性别比例统计饼图</a><br></h1><br><br>
    <h1><a href="html/BingTuYear.html">图书借阅年级统计饼图</a><br></h1><br><br>
    <h1><a href="html/SanDiantuNum.html">借书数量统计散点图</a><br></h1><br><br>
    <h1><a href="html/ZheXianMianJiTu.html">图书借阅统计折线面积图</a><br></h1><br><br>
    <h1><a href="html/ZheXianTime.html">按时间段统计折线图</a><br></h1><br>
</div>
</body>
</html>