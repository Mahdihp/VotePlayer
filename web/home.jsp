<%@ page import="java.util.List" %>
<%@ page import="com.mahdi.service.entity.Item" %>
<%@ page import="com.mahdi.service.entity.VoteResultItem" %><%--
  Created by IntelliJ IDEA.
  User: mahdi
  Date: 8/13/18
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Vote Player</title>
    <link rel="stylesheet" type="text/css" href="resource/Style.css">
</head>
<body>
<div>
    <a href="http://localhost:8080/">LogOut</a>
    <br>

    <div id="question">
        <%
            String question = (String) request.getAttribute("question");
            out.println(question + "</br></br>");
            List<VoteResultItem> itemList = (List<VoteResultItem>) request.getAttribute("items");

            for (VoteResultItem item : itemList) {
                out.write(item.getItem() + " => " + item.getCount() + "<br>");
            }

        %>
        <br>
        <br>
    </div>

</div>
</body>
</html>
