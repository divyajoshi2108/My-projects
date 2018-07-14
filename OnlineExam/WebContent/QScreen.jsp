<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 
<style>
#container{
      display:flex;
      margin:50px 150px 0px;
    justify-content: center;
    background:rgb(76, 175, 80); 
   }
   
.container{
display:flex;
    justify-content: center;
    height:400px;
margin:0px 150px ;
	border:solid rgb(76, 175, 80);
}

h4{
position :relative;
left:500px;
}

 #q{
    margin: 25px;
}

#question{
    padding: 10px 15px;
    border: solid #ccc;
    border-radius: 30px;
    font-weight: bold;
    font-family:Helvetica;
    font-size: 20px;

}

#Submit_submit{
	position:relative;
	 background:rgb(76, 175, 80); 
	top:20px;
	right:300px;
}

#previous{
  position:relative;
top: 230px;
 right:300px 
}
#next{
  position:relative;
top: 230px;
left:670px
}
#finish{
  position:relative;
top: 165px;
left:370px
}

.button{
 background:rgb(76, 175, 80); 
    border: solid #ccc;
    border-radius: 25px;
    font-weight: bold;
    font-family:Helvetica;
    font-size: 20px;
    margin: 20px;
    padding: 10px;
    text-decoration: none;
    color: black;

}
 </style>
 
</head>
<body>
<div id="container">
<h1>QUIZ</h1>
</div>
<div class="container">
<s:form action="Submit" method="post" namespace="/">


<h4>TOTAL QUESTIONS:<span id="TotalQ"><s:property value="TotalQ"/></span></h4>
   
    <div id="q">
        <span  id="question">
       Q:<span id="Qno"><s:property value="i"/></span> <s:property value="ques"/></span>
    </div>
    <div id="answer">
    <s:radio  name="yourAns" list="Ans" value="Uans"  ></s:radio> 
   </div>
   <div id="operation">
     
   <a class="button"  id="next" href="/OnlineExam/QNext.action">NEXT</a>
        <a  class="button" id="previous"  href="/OnlineExam/QPre.action">PREVIOUS</a>
         <a  class="button" id="finish" href="/OnlineExam/finish.action">FINISH</a>
        <s:submit  class="button"  value="submit" name="submit" />
    </div>
 </s:form>
</div>
  </body>
</html>