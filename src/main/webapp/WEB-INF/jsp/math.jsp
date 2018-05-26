<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>
<div>
    <h1>Web-calculator</h1>
    <c:url var="calc_url" value="/calc"/>
    <sf:form action="${calc_url}" method="post" modelAttribute="mathOperForm">
        <sf:input path="number" />
        <sf:radiobutton path="function" value="+" label="+" />
        <sf:radiobutton path="function" value="-" label="-" />
        <sf:radiobutton path="function" value="*" label="*" />
        <sf:radiobutton path="function" value="/" label="/" />
        <sf:radiobutton path="function" value="=" label="=" />
        <button type="submit">Evaluate</button>
        <br>
        <sf:errors path="number" />
    </sf:form>


    <c:if test="${not empty result}" >
        <h1>Result: ${result}</h1>
    </c:if>


    <c:url var="logoutUrl" value="/logout"/>
    <form action="${logoutUrl}"
          method="post">
        <input type="submit"
               value="Log out <c:out value="${user_details.username}"/>" />
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
</div>