<%@page import="dao.ClienteDAO"%>
<%@page import="model.Cliente"%>
<%@page import="model.Cliente"%>
<%
    try {
        Integer idPessoa = Integer.parseInt(request.getParameter("idpessoa"));
        
        /*para realizar pesquisa por nome*/
        if ( idPessoa != null) {
            Cliente cliente = ClienteDAO.listById(idPessoa);
            pageContext.setAttribute("cliente", cliente);
/*lista todos*/
        } else {
            response.sendRedirect("../read");

        }

    } catch (Exception e) {
    }


%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body class="d-flex flex-column min-vh-100">
        <header><%@include file="../partials/header.jspf"%></header>
        <form action="" method="POST">
            <div class="card-body">
                <%@include file="../partials/update/dados.jspf" %>
                <hr class="mb-4 mt-4" name="enderecos">
                <%@include file="../partials/update/endereco.jspf" %>
                <hr class="mb-4 mt-4">
                <%@include file="../partials/update/contatos.jspf" %>
                <hr class="mb-4 mt-4">
            </div>
            <input type="submit" value="Salvar" class="btn btn-success" name="btnUpateData">
        </form>
        
        
        <footer class="mt-auto"><%@include file="../partials/footer.jspf" %></footer>
        
    </body>
</html>
