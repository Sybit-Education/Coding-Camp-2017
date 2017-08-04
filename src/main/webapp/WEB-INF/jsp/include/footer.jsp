<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="<c:url value="/" />">
    <img src="<c:url value="/resources/images/icon.svg" />" id="logo"/>
</a>
<img src="" id="badge">

<footer>      
    <c:import url="include/navigation.jsp"/>   
</footer>

<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/script.js" />"></script>