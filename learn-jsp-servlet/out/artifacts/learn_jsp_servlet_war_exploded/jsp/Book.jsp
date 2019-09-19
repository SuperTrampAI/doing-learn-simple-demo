<%--
  Created by IntelliJ IDEA.
  User: lxh95
  Date: 2019/9/19
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!--    c标签要使用,那么就必须要有它 -->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

    <c:set scope="page" var="url"
       value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>新增book</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">


</head>

<body>
<div align="center"
     style="width: 400px; position: relative;left:450px">
    <form action="${url}/bookservlet?reqtype=insert" method="post">
        <%-- // bname,uid,publish,publishdate,page,price,content --%>
        <h4>新增book</h4>
            bname: <input type="text" name="bname"><br />
            uid: <input type="text" name="uid"><br />
            publish: <input type="text" name="publish"><br />
            publishdate: <input type="text" name="publishdate"><br />
            page: <input type="text" name="page"><br />
            price: <input type="text" name="price"><br />
            content: <input type="text" name="content"><br />
    </select><br />
        <input type="submit" value="新增"/>
        <hr />
    </form>
</div>
<div align="center"style="width: 400px; position: relative;left:450px;">
    <form action="${url}/bookservlet?reqtype=queryAll" method="post">
        <input type="submit" value="查询所有的数据"/> <br/>
        <table border="1"  cellspacing="0">
            <thead>
            <%-- // bname,uid,publish,publishdate,page,price,content --%>
            <tr><td>bid</td><td>bname</td><td>uid</td><td>publish</td><td>publishdate</td><td>page</td><td>price</td><td>content</td></tr>
            </thead>
            <tbody>
                <%-- // bname,uid,publish,publishdate,page,price,content --%>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.bid }</td>
                        <td>${book.bname }</td>
                        <td>${book.uid }</td>
                        <td>${book.publish }</td>
                        <td>${book.publishdate }</td>
                        <td>${book.page }</td>
                        <td>${book.price }</td>
                        <td>${book.content }</td>

                        <td><a  href= "${url}/bookservlet?reqtype=queryById&bid=${book.bid}"     style='text-decoration:none'    onclick='update(this)'   >修改&nbsp;</a>
                            <a    href= "${url}/bookservlet?reqtype=delete&bid=${book.bid}"   style='text-decoration:none'     >删除</a>  </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <hr />
    </form>
</div>
<div align="center"
     style="width: 400px; position: relative;left:450px">
    <form action="${url}/bookservlet?reqtype=update" method="post">
        <h4>修改用户</h4>
        <%-- // bname,uid,publish,publishdate,page,price,content --%>
        <input type="hidden"name="bid"  value="${book.bid }"/>
        bname: <input type="text" name="bname" value="${book.bname }"><br />
        uid: <input type="text" name="uid" value="${book.uid }"><br />
        publish: <input type="text" name="publish" value="${book.publish }"><br />
        publishdate: <input type="text" name="publishdate" value="${book.publishdate }"><br />
        page: <input type="text" name="page" value="${book.page }"><br />
        price: <input type="text" name="price" value="${book.price }"><br />
        content: <input type="text" name="content" value="${book.content }"><br />

        <input type="submit" value="保存修改"/>
        <hr />
    </form>
</div>
</body>
</html>
