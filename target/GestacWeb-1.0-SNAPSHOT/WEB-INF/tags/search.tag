<%@tag description="Main Wrapper Tag" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="search" fragment="true" %>

<!--buscador-->
<form class="search-form" method="post" action="<c:url value='search'/>">
    <button type="submit"><i class="fa fa-search"></i></button>
    <div class="search__input">
        <input type="text" name="query" id="query" placeholder="Ingrese su búsqueda" value="${requestScope.SEARCH_QUERY}" autofocus>

        <select name="queryType" id="queryType" class="search__filter">
            <option selected value="ALL" <c:if test="${empty requestScope.SEARCH_QUERY_TYPE  or requestScope.SEARCH_QUERY_TYPE eq 'ALL' }"> selected </c:if> >Todos</option>
            <option value="PROBLEM" <c:if test="${requestScope.SEARCH_QUERY_TYPE eq 'PROBLEM' }"> selected </c:if>>Problemas</option>
            <option value="KNOWLEDGE" <c:if test="${requestScope.SEARCH_QUERY_TYPE eq 'KNOWLEDGE' }"> selected </c:if>>Conocimientos</option>
            <option value="SOURCE" <c:if test="${requestScope.SEARCH_QUERY_TYPE eq 'SOURCE' }"> selected </c:if>>Fuentes</option>
        </select>
    </div>
</form>