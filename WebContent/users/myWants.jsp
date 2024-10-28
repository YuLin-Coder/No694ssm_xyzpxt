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
						<td align="left" class="p12">您的位置： <a href="<%=basePath%>">首页</a>&nbsp;&gt;&gt;&nbsp;我的求职信息
						</td>
					</tr>
				</table>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td align="left">
							<div class="z" id="z">
								<table width="99%" border="0" cellpadding="5" cellspacing="1" bgcolor="#E0EDB7">
									<tr>
										<td height="30" colspan="9" align="left" background="themes/nzblue/images/nzcms/list_bg.gif" class="white14B">我的求职信息</td>
									</tr>
									<tr>
										<td align="center" bgcolor="#FFFFFF">标题</td>
										<td align="center" bgcolor="#FFFFFF">职业类型</td>
										<td align="center" bgcolor="#FFFFFF">薪水预期</td>
										<td align="center" bgcolor="#FFFFFF">发布日期</td>
										<td align="center" bgcolor="#FFFFFF">点击数</td>
										<td align="center" bgcolor="#FFFFFF">状态</td>
									</tr>
									<c:forEach items="${wantsList}" var="wants">
										<tr align="center" bgcolor="#FFFFFF">
											<td class="center">${wants.title}</td>
											<td class="center">${wants.catename}</td>
											<td class="center">${wants.salary}</td>
											<td class="center">${wants.addtime}</td>
											<td class="center">${wants.hits}</td>
											<td class="center">${wants.status}</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</td>
					</tr>
				</table>
				<table height="20" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>${html }</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
