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
	<table width="1004" border="0" align="center" cellpadding="0" cellspacing="10" bgcolor="#FFFFFF">
		<tr>
			<td align="center" valign="top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#F5F5F5" class="bg_qc">
					<tr>
						<td width="25" height="20" align="center"><img src="themes/nzblue/images/nzcms.xinxin.gif" alt="标" width="9"
							height="9" /></td>
						<td align="left" class="p12">您的位置： <a href="index.jsp">首页</a>&nbsp;&gt;&nbsp;&nbsp;发布求职信息
						</td>
					</tr>
				</table>
				<table height="30" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td></td>
					</tr>
				</table>
				<form action="index/addWants.action" name="myform" method="post">
					<table width="66%" border="0" cellpadding="5" cellspacing="1" bgcolor="#E0EDB7">
						<tr>
							<td height="30" colspan="2" align="center" background="themes/nzblue/images/nzcms/list_bg.gif" class="white14B">发布求职信息</td>
						</tr>
						<tr>
							<td height="50" align="right" bgcolor="#FFFFFF">标题：</td>
							<td bgcolor="#FFFFFF"><input type="text" name="title" style="width: 260px; height: 30px" required="required"
								id="title" placeholder="请输入标题" /></td>
						</tr>
						<tr>
							<td height="50" align="right" bgcolor="#FFFFFF">求职类型：</td>
							<td bgcolor="#FFFFFF"><select name="cateid" style="width: 260px; height: 30px" id="cateid">
									<option value="">---请选择求职类型---</option>
									<c:forEach items="${cateList}" var="cate">
										<option value="${cate.cateid }">${cate.catename }</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td height="50" align="right" bgcolor="#FFFFFF">薪水预期：</td>
							<td bgcolor="#FFFFFF"><input type="text" name="salary" style="width: 260px; height: 30px"
								required="required" id="salary" placeholder="请输入薪水预期" /></td>
						</tr>
						<tr>
							<td height="50" align="right" bgcolor="#FFFFFF">内容：</td>
							<td bgcolor="#FFFFFF"><textarea style="width: 99%; height: 130px" name="contents" id="contents"
									placeholder="请输入内容" required="required"></textarea></td>
						</tr>
						<tr>
							<td bgcolor="#FFFFFF" colspan="2" align="center"><label> <input type="submit" name="Submit"
									value="提交" /> &nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" name="Submit2" value="重置" />
							</label></td>
						</tr>
					</table>
				</form>
				<table height="50" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
