<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="nw" uri="nw_dict" %>
<% 
	String basePath =request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>初始化页面</title>
<link href="<%=basePath %>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath %>/css/tld.css" rel="stylesheet">
<script src="<%=basePath %>/js/jquery-1.5.1.min.js" type="text/javascript"></script>
<script src="<%=basePath %>/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function goPage(pageNo){
		//alert(pageNo);
		
		//var top = $("#top");
	
		var top = window.frames['top'];
		top.aa("sss");
	}

</script>
</head>
		
	<nw:text id="test1"  className="text"  placeholder="test1"/>
	
	<nw:select id="test2" options="abc,acd,aaa,ccc"  value="acd"/>
	
	<nw:page next="2" last="5" previous="1" first="1" className="pager"/>

	<iframe src="<%=basePath %>/yyy"  id="top" name="top"></iframe>
</html>
