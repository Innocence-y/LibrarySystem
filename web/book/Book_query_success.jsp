<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/default.css"/>
<style type="text/css">
    * {
        background: none repeat scroll 0 0 transparent;
        border: 0 none;
        margin: 0;
        padding: 0;
        vertical-align: baseline;
        font-family: 微软雅黑;
    }

    #navi {
        width: 100%;
        position: relative;
        word-wrap: break-word;
        border-bottom: 1px solid #065FB9;
        margin: 0;
        padding: 0;
        height: 40px;
        line-height: 40px;
        vertical-align: middle;
        background-image: -moz-linear-gradient(top, #EBEBEB, #BFBFBF);
        background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB), color-stop(1,
        #BFBFBF));
    }

    #naviDiv {
        font-size: 14px;
        color: #333;
        padding-left: 10px;
    }

    #tips {
        margin-top: 10px;
        width: 100%;
        height: 40px;
    }

    #buttonGroup {
        padding-left: 10px;
        float: left;
        height: 35px;
    }

    .button {
        float: left;
        margin-right: 10px;
        padding-left: 10px;
        padding-right: 10px;
        font-size: 14px;
        width: 70px;
        height: 30px;
        line-height: 30px;
        vertical-align: middle;
        text-align: center;
        cursor: pointer;
        border-color: #77D1F6;
        border-width: 1px;
        border-style: solid;
        border-radius: 6px 6px;
        -moz-box-shadow: 2px 2px 4px #282828;
        -webkit-box-shadow: 2px 2px 4px #282828;
        background-image: -moz-linear-gradient(top, #EBEBEB, #BFBFBF);
        background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB), color-stop(1, #BFBFBF));
    }

    #mainContainer {
        padding-left: 10px;
        padding-right: 10px;
        text-align: center;
        width: 98%;
        hight: 98%;
        font-size: 12px;
    }
</style>
<script type="text/javascript">
    function testDiv() {
        var divD = document.getElementById("testD");
        if (divD.style.display == "none") {
            divD.style.display = "block";
        } else {
            divD.style.display = "none";
        }
    }
</script>

<body>
<div id="navi">
    <div id='naviDiv'>
    </div>
</div>
<div id="mainContainer">
    <table class="default">
        <form action="TypeQueryaction" method="post">
            <tr>
                <td>类型 :</td>
                <td><select id="Query" name="Query">
                    <option style="color: black" value="ALL" >所有</option>
                    <option style="color: black" value="BookID" >图书ID</option>
                    <option style="color: black" value="bookname">书名</option>
                    <option style="color: black" value="author">作者</option>
                    <option style="color: black" value="status">状态</option>
                    <option style="color: black" value="sort">类别</option>
                </select></td>
                <td></td>
                <td>值 :</td>
                <td><input class="option" type="text" name="Option"
                           placeholder="ALL" value="ALL"></td>
                <td><input id="submit" type="submit" value="查询"
                           style="width: 100px;"></td>
            </tr>
        </form>
    </table>
    <table class="default" width="100%">
        <tr class="title">
            <td>图书ID</td>
            <td>书名</td>
            <td>作者</td>
            <td>分类</td>
            <td>评分</td>
            <td>状态</td>
            <td>操作</td>
        </tr>
        <s:iterator value="booklist" id="book" status="st">
            <tr>
                <td><s:property value="#book.BookID"/></td>
                <td><s:property value="#book.bookname"/></td>
                <td><s:property value="#book.author"/></td>
                <td><s:property value="#book.sort"/></td>
                <td><s:property value="#book.grade"/></td>
                <td><s:property value="#book.status"/></td>
                <s:if test="#session.user==null">
                    <td>
                        <a href="Book_add.jsp"/>添加</a>
                        <a href='transform?id=<s:property value='#book.id'/>'>修改</a>
                        <a href='DeleteBookAction?BookID=<s:property value='#book.BookID'/>'
                           onclick="javascript: return confirm('真的要删除吗？');"/>删除</a>
                    </td>
                </s:if>
                <s:else>
                    <td>
                        <s:if test="#book.status=='已借出'.toString()">
                            已借出
                        </s:if>
                        <s:else>
                            <a href='lendbookaction?BookID=<s:property value='#book.BookID'/>'>借阅</a>
                        </s:else>
                    </td>
                </s:else>
            </tr>
        </s:iterator>
    </table>

    <s:if test="#session.user!=null">
        <s:if test="#session.recommendBook!=null">
            <div id='testD'
                 style="border-radius: 20px; background-color: khaki; width:500px; height:250px; position: fixed; left:300px; top:420px;">
                <tr>
                    <td>
                        <h3>您可能喜欢以下书籍:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="button" class="btn" value="X" onclick="testDiv()"/>
                        </h3>
                    </td>
                </tr>
                <table class="default" width="100%">
                    <tr class="title">
                        <td>图书ID</td>
                        <td>书名</td>
                        <td>作者</td>
                        <td>分类</td>
                        <td>评分</td>
                        <td>状态</td>
                    </tr>
                    <td><s:property value="#session.recommendBook.BookID"/></td>
                    <td><s:property value="#session.recommendBook.bookname"/></td>
                    <td><s:property value="#session.recommendBook.author"/></td>
                    <td><s:property value="#session.recommendBook.sort"/></td>
                    <td><s:property value="#session.recommendBook.grade"/></td>
                    <td><s:property value="#session.recommendBook.status"/></td>
                </table>
            </div>
        </s:if>
    </s:if>

</div>
</body>
</html>