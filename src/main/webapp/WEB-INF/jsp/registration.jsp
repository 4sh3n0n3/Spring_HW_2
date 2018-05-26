
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:url value="/registration" var="regUrl" />
<sf:form action="${regUrl}" modelAttribute="userform" method="post">
    <sf:errors/>
    <spring:bind path="username">
        <div class="form-group">
            <label for="regUsername">Username:</label>
            <sf:input id="regUsername" type="text" path="username" cssClass="form-control" />
            <sf:errors path="username"/>
        </div>
    </spring:bind>

    <spring:bind path="email">
        <div class="form-group">
            <label for="regEmail">Email:</label>
            <sf:input id="regEmail" type="text" path="email" cssClass="form-control" />
            <sf:errors path="email"/>
        </div>
    </spring:bind>

    <spring:bind path="password">
        <div class="form-group">
            <label for="regPassword">Password:</label>
            <sf:input id="regPassword" type="text" path="password" cssClass="form-control password-field" />
            <sf:errors path="password"/>
        </div>
    </spring:bind>

    <spring:bind path="repassword">
        <div class="form-group">
            <label for="rePass">Repeat Password:</label>
            <sf:input id="rePass" type="text" path="repassword" cssClass="form-control password-field" />
            <sf:errors path="repassword" />
        </div>
    </spring:bind>

    <button type="submit" class="btn btn-lg btn-primary btn-block">Register</button>

</sf:form>
