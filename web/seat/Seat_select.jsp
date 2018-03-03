<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
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
#mainContainer{
	padding-left:10px;
	padding-right:10px;
	text-align:center;
	width:98%;
	font-size:12px;
}
</style>
<style type="text/css">
		.front{width: 300px;margin: 5px 32px 45px 32px;background-color: #f0f0f0;	color: #666;text-align: center;padding: 3px;border-radius: 5px;}
		.booking_area {float: left;position: relative;width:200px;height: 400px; }
		.booking_area h3 {margin: 5px 5px 0 0;font-size: 16px;}
		.booking_area p{line-height:26px; font-size:16px; color:#999}
		.booking_area p span{color:#666}
		div.seatCharts-cell {color: #182C4E;height: 25px;width: 25px;line-height: 25px;margin: 3px;float: left;text-align: center;outline: none;font-size: 13px;}
		div.seatCharts-seat {color: #fff;cursor: pointer;-webkit-border-radius: 5px;-moz-border-radius: 5px;border-radius: 2px;}
		div.seatCharts-row {height: 35px;}
		div.seatCharts-seat.available {background-color: #99CC99;}
		div.seatCharts-seat.focused {background-color: #76B474;border: none;}
		div.seatCharts-seat.selected {background-color: #E6CAC4;}
		div.seatCharts-seat.unavailable {background-color: #FF5500;cursor: not-allowed;}
		div.seatCharts-container {border-right: 1px dotted #adadad;width: 400px;padding: 20px;float: left;}
		div.seatCharts-legend {padding-left: 0px;position: absolute;bottom: 16px;}
		ul.seatCharts-legendList {padding-left: 0px;}
		.seatCharts-legendItem{float:left; width:90px;margin-top: 10px;line-height: 2;}
		span.seatCharts-legendDescription {margin-left: 5px;line-height: 30px;}
		.checkout-button {display: block;width:80px; height:24px; line-height:20px;margin: 10px auto;border:1px solid #999;font-size: 14px; cursor:pointer}
		#seats_chose {max-height: 150px;width: 200px;}
		#seats_chose li{float:left; width:72px; height:26px; line-height:26px; border:1px solid #d3d3d3; background:#f7f7f7; margin:6px; font-size:14px; font-weight:bold; text-align:center}
	</style>
<body>
<div id="navi">
	<!-- 导航空白 -->
	<div id='naviDiv'>
	</div>
</div>
<div id="tips">
	<!-- 导航空白 -->
</div>
<div id="mainContainer">
	<div class="container">
		<div class="demo clearfix">
			<!---左边座位列表----->
			<div id="seat_area">
			</div>
			<!---右边选座信息----->
			<div class="booking_area">
				<p>已选座位：</p>
				<ul id="seats_chose"></ul>
                    <input type="button" class="btn" value="确定" onclick="selectseat()"/>
				<div id="legend"></div>
			</div>
		</div>
	</div>
	<script src="../js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../js/jquery.seat-charts.min.js"></script>
	<script type="text/javascript" src="../js/seat.js"/>
</div>
</body>
</html>