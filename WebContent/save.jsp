<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<a href="query.jsp">query.jsp</a>
	<form action="${pageContext.request.contextPath}/ProductServlet" method="post">
		商品名：<input type="text" name="name" /><br /> 价格： <input type="text"
			name="price" /><br /> 备注： <input type="text" name="remark" /><br />
		<input type="submit" value="提交" />
		<input type="hidden" name="type" value="save" />
	</form>
</body>
</html>