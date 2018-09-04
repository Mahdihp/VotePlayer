<%@ page import="com.mahdi.service.entity.VoteResultItem" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mahdi.service.entity.Item" %><%--
  Created by IntelliJ IDEA.
  User: mahdi
  Date: 9/4/18
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Vote </title>
</head>
<body>
<form action="/register" method="post">
    <%
        if (request.getAttribute("question") != null) {
            String question = (String) request.getAttribute("question");
            int questionId = (int) request.getAttribute("questionId");
            int userId = (int) request.getAttribute("userId");
            out.println(question + "</br></br>");
            List<Item> itemList = (List<Item>) request.getAttribute("items");

            for (Item item : itemList) {
                out.write(item.getItem() + " <input type='radio' name='item' value='" + item.getId() + "'/>" + "<br>");
            }
            out.write(" <input type='hidden' name='questionId' value='" + questionId + "'/>");
            out.write(" <input type='hidden' name='userId' value='" + userId + "'/>");
        }else{
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
    %>

    <br>
    <br>
    <input type="submit" value="Send Vote"/>

</form>
</body>
</html>
