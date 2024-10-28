<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>">
<title>${title}</title>
<link href="themes/nzblue/css/css.css" rel="stylesheet" type="text/css" />
<link href="themes/nzblue/css/css_2.css" rel="stylesheet" type="text/css" />
<link href="themes/nzblue/css/nzcms_top.css" rel="stylesheet" type="text/css">
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<table width="1004" border="0" align="center" cellpadding="1" cellspacing="10" bordercolor="#FFFFFF" bgcolor="#FFFFFF">
		<tr>
			<td align="center" valign="top" bgcolor="#FFFFFF" class="bg_qc">
				<table width="100%" height="27" border="0" cellpadding="8" cellspacing="0" bgcolor="#F6F6F6">
					<tr>
						<td align="left" class="p12">您的位置： <a href="index/index.action">首页</a>&nbsp;&gt;&gt;&nbsp; <a
							href="index/wants.action">求职信息</a>
						</td>
					</tr>
				</table>
				<table height="35" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td></td>
					</tr>
				</table>
				<table height="25" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td align="center" class="p28"><font class="p28">${wants.title }</font></td>
					</tr>
				</table>
				<table height="35" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td></td>
					</tr>
				</table>
				<table width="98%" border="0" cellpadding="0" cellspacing="0" bgcolor="#F6F6F6" class="dx">
					<tr>
						<td height="20" align="center">
						&nbsp;&nbsp;发布人：${wants.username } &nbsp;&nbsp;‖
						&nbsp;&nbsp;联系方式：${wants.contact } &nbsp;&nbsp;‖
						&nbsp;&nbsp;发布时间：${wants.addtime }&nbsp;&nbsp;‖
						&nbsp;&nbsp;查看${wants.hits }次&nbsp;&nbsp;
						</td>
					</tr>
				</table>

				<table height="15" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td></td>
					</tr>
				</table>

				<table height="15" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td></td>
					</tr>
				</table>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td align="left">
							<div class="z" id="z">${wants.contents }</div>
						</td>
					</tr>
				</table>
				<table width="95%" height="60" border="0" cellpadding="0" cellspacing="0" class="dx">
					<tr>
						<td align="center" valign="middle"><input name="button" type=button
							onClick="window.location='javascript:window.print()'" value="打印此页"> &nbsp;&nbsp;&nbsp;&nbsp; <input
							name="button2" type=button onClick="window.location='#'" value="返回顶部"> &nbsp;&nbsp;&nbsp;&nbsp; <input
							name="button2" type="button"
							onClick="jscript:window.external.AddFavorite(document.location.href,document.title);" value="收藏本页" />
							&nbsp;&nbsp;&nbsp;&nbsp; <input name="button2" type=button onClick="window.location='javascript:window.close();'"
							value="关闭窗口"></td>
					</tr>
				</table>

			</td>
		</tr>
	</table>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
