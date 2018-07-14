<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <script src="Result.js"></script> --%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style >
.container{
display:flex;
justify-content: center;
}
table {
    width: 50%;
    border:1px;
    border-color:rgb(76, 175, 80);
}

th {
    height: 50px;
}

#heading{
background:rgb(76, 175, 80);
}

</style>
</head>


<body>
<div class="container">
<h1>REPORT CARD</h1>
</div>
<div class="container">

<table>
<tr id="heading">
<th >Question No.</th>
<th>User's Answer</th>
<th>Right Answer</th>
<th>Status</th>
</tr>
<s:iterator value="List">
<tr>
<th>Q:<s:property value="Qid" /></th>

 <th id="YAns"> <s:property value="YAns" /></th>
  <th id="RAns"> <s:property value="RAns" /></th>
 <th id="Status"><s:property value="Answered" /></th>
 </tr>
</s:iterator>
</table>

</div>
</body>
</html>