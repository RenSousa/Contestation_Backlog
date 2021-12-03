<%-- 
    Document   : contestacao
    Created on : 15/04/2020, 15:10:33
    Author     : RENAN.SOUSA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.User"%>
<%@page import="MODEL.Conveniado"%>
<%@page import="MODEL.Contestacao"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet">
        <link href="./css/album.css" rel="stylesheet">
        <script src="./js/concessionaria.js"></script>

        <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

        <style>

            #multa {
                display: none;
            }

            .svg-icon {
                width: 2em;
                height: 2em;
            }

            .svg-icon path,
            .svg-icon polygon,
            .svg-icon rect {
                fill: #4691f6;
            }

            .svg-icon circle {
                stroke: #4691f6;
                stroke-width: 1;            
            }          

            div.ex1 {
                display: none;
            }            
        </style>

        <script>
            function openFormEmail() {
                document.getElementById("controle_email").style.display = "block";
            }
            function closeFormEmail() {
                document.getElementById("controle_email").style.display = "none";
            }
            function openFormConveniado() {
                document.getElementById("conveniado").style.display = "block";
            }
            function closeFormConveniado() {
                document.getElementById("conveniado").style.display = "none";
            }
            function openFormLoja() {
                document.getElementById("loja").style.display = "block";
            }
            function closeFormLoja() {
                document.getElementById("loja").style.display = "none";
                return false;
            }

            function validarStatus() {
                if (document.getElementById("list_resultado").value === "" || document.getElementById("list_resultado").value === null) {
                    document.getElementById("list_resultado").setAttribute("required", "");
                    return false;
                }
            }
            function validarStatusImp() {
                if (document.getElementById("front_s").checked !== true || document.getElementById("front_n").checked  !== true ) {
                    document.getElementById("front_s").setAttribute("required", "");
                    return false;
                }
            }
        </script>

        <title>Contestação</title>
    </head>

    <body>

            <%
                String celula = (String) request.getAttribute("celula");
                String natureza = (String) request.getAttribute("natureza");
                User user = (User) request.getAttribute("user");
                Contestacao ct_search = (Contestacao) request.getAttribute("ct_search");
            %>
            
            <form action="ControllerContestation" method="post">
                <nav class="navbar navbar-expand-lg navbar-light sticky-bottom bg-light">

                    <a class="navbar-brand">
                        <svg height="40" viewBox="0 0 58 58" width="40" xmlns="http://www.w3.org/2000/svg"><g id="023---Sign-Form" fill="none"><path id="Shape" d="m58 6v48c0 2.209139-1.790861 4-4 4h-50c-2.209139 0-4-1.790861-4-4v-48z" fill="#ecf0f1"/><path id="Shape" d="m58 6v48c0 2.209139-1.790861 4-4 4h-50c-2.209139 0-4-1.790861-4-4v-48z" fill="#b0d3f0"/><path id="Shape" d="m58 4v4h-58v-4c0-2.209139 1.790861-4 4-4h50c2.209139 0 4 1.790861 4 4z" fill="#56595e"/><path id="Shape" d="m4.02 5c-.55228475 0-1-.44771525-1-1s.44771525-1 1-1 1 .44771525 1 1-.44771525 1-1 1z" fill="#e64c3c"/><path id="Shape" d="m8.02 5c-.55228475 0-1-.44771525-1-1s.44771525-1 1-1 1 .44771525 1 1-.44771525 1-1 1z" fill="#f0c419"/><path id="Shape" d="m12.02 5c-.5522847 0-1-.44771525-1-1s.4477153-1 1-1 1 .44771525 1 1-.4477153 1-1 1z" fill="#24ae5f"/><path id="Shape" d="m53 6c-.5522847 0-1-.44771525-1-1v-2c0-.55228475.4477153-1 1-1s1 .44771525 1 1v2c0 .55228475-.4477153 1-1 1z" fill="#bdc3c7"/><path id="Shape" d="m52 4h2" fill="#bdc3c7"/><path id="Shape" d="m54 5h-2c-.5522847 0-1-.44771525-1-1s.4477153-1 1-1h2c.5522847 0 1 .44771525 1 1s-.4477153 1-1 1z" fill="#bdc3c7"/><path id="Shape" d="m46 4h2" fill="#bdc3c7"/><path id="Shape" d="m48 5h-2c-.5522847 0-1-.44771525-1-1s.4477153-1 1-1h2c.5522847 0 1 .44771525 1 1s-.4477153 1-1 1z" fill="#bdc3c7"/><rect id="Rectangle-path" fill="#2980ba" height="6" rx="1" width="30" x="5" y="13"/><path id="Shape" d="m35 24h-29c-.55228475 0-1-.4477153-1-1s.44771525-1 1-1h29c.5522847 0 1 .4477153 1 1s-.4477153 1-1 1z" fill="#3b97d3"/><path id="Shape" d="m32 28h-26c-.55228475 0-1-.4477153-1-1s.44771525-1 1-1h26c.5522847 0 1 .4477153 1 1s-.4477153 1-1 1z" fill="#3b97d3"/><path id="Shape" d="m30 32h-24c-.55228475 0-1-.4477153-1-1s.44771525-1 1-1h24c.5522847 0 1 .4477153 1 1s-.4477153 1-1 1z" fill="#3b97d3"/><path id="Shape" d="m28 36h-22c-.55228475 0-1-.4477153-1-1s.44771525-1 1-1h22c.5522847 0 1 .4477153 1 1s-.4477153 1-1 1z" fill="#3b97d3"/><path id="Shape" d="m32.13 40h-26.13c-.55228475 0-1 .4477153-1 1v12c0 .5522847.44771525 1 1 1h46c.5522847 0 1-.4477153 1-1v-12c0-.5522847-.4477153-1-1-1h-10.82" fill="#3b97d3"/><path id="Shape" d="m38.61 44.85-6.3 5.35c-.3120653.2638681-.7532885.3112975-1.1143053.1197825-.3610169-.1915151-.5691723-.5834318-.5256947-.9897825l.87-8.22c4.036.679 3.96.49 7.07 3.74z" fill="#f9eab0"/><path id="Shape" d="m45.84 22.66-10.29 19.44c-1.126-.592-1.911-.637-4.01-.99l10.77-20.33z" fill="#f3d55b"/><path id="Shape" d="m49.37 24.53-10.76 20.32c-.8565865-1.0836416-1.8913619-2.0135868-3.06-2.75l10.29-19.44z" fill="#f0c419"/><path id="Shape" d="m52.65 18.34-1.4 2.65-7.07-3.74 1.4-2.65c.3718732-.7049033 1.0089506-1.2328641 1.7706476-1.4673767.7616969-.2345126 1.5854038-.1563007 2.2893524.2173767l1.76.93c.7049033.3718732 1.2328641 1.0089506 1.4673767 1.7706476.2345126.7616969.1563007 1.5854038-.2173767 2.2893524z" fill="#d75e72"/><path id="Shape" d="m51.25 20.99-1.88 3.54c-4.237-2.245-2.615-1.383-7.06-3.75l1.87-3.53z" fill="#bdc3c7"/><g fill="#9fc9d3"><path id="Shape" d="m10 51h-2c-.55228475 0-1-.4477153-1-1s.44771525-1 1-1h2c.5522847 0 1 .4477153 1 1s-.4477153 1-1 1z"/><path id="Shape" d="m16 51h-2c-.5522847 0-1-.4477153-1-1s.4477153-1 1-1h2c.5522847 0 1 .4477153 1 1s-.4477153 1-1 1z"/><path id="Shape" d="m22 51h-2c-.5522847 0-1-.4477153-1-1s.4477153-1 1-1h2c.5522847 0 1 .4477153 1 1s-.4477153 1-1 1z"/><path id="Shape" d="m27 51h-1c-.5522847 0-1-.4477153-1-1s.4477153-1 1-1h1c.5522847 0 1 .4477153 1 1s-.4477153 1-1 1z"/><path id="Shape" d="m38 51h-1c-.5522847 0-1-.4477153-1-1s.4477153-1 1-1h1c.5522847 0 1 .4477153 1 1s-.4477153 1-1 1z"/><path id="Shape" d="m44 51h-2c-.5522847 0-1-.4477153-1-1s.4477153-1 1-1h2c.5522847 0 1 .4477153 1 1s-.4477153 1-1 1z"/><path id="Shape" d="m50 51h-2c-.5522847 0-1-.4477153-1-1s.4477153-1 1-1h2c.5522847 0 1 .4477153 1 1s-.4477153 1-1 1z"/></g></g></svg>
                    </a>
                    <a class="navbar-brand ">
                        <h6>Grupo Avançado de Solução</h6>
                        <h3>Distribuição de Tarefas</h3></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    
                    <div class="collapse navbar-collapse" id="navbarCollapse">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <button class="btn btn-outline-info" type="submit" name="btn_assignuser"><svg class="svg-icon" viewBox="0 0 20 20" width="30" >
                                    <path fill="none" d="M14.023,12.154c1.514-1.192,2.488-3.038,2.488-5.114c0-3.597-2.914-6.512-6.512-6.512
                                          c-3.597,0-6.512,2.916-6.512,6.512c0,2.076,0.975,3.922,2.489,5.114c-2.714,1.385-4.625,4.117-4.836,7.318h1.186
                                          c0.229-2.998,2.177-5.512,4.86-6.566c0.853,0.41,1.804,0.646,2.813,0.646c1.01,0,1.961-0.236,2.812-0.646
                                          c2.684,1.055,4.633,3.568,4.859,6.566h1.188C18.648,16.271,16.736,13.539,14.023,12.154z M10,12.367
                                          c-2.943,0-5.328-2.385-5.328-5.327c0-2.943,2.385-5.328,5.328-5.328c2.943,0,5.328,2.385,5.328,5.328
                                          C15.328,9.982,12.943,12.367,10,12.367z"></path>
                                    </svg>Atribuir Ocorrência</button>
                            </li>
                        </ul>
                        <button class="btn my-2 my-sm-0" name="">
                            <h6>Usuário Conectado:</h6> <%=user.getLogin()%></button>
                        <input type="hidden" name="txt_user" value="<%=user.getLogin()%>">    
                        <button class="btn my-2 my-sm-0" name="btn_logout"><svg class="svg-icon" viewBox="0 0 20 20">
                            <path fill="none" d="M13.864,6.136c-0.22-0.219-0.576-0.219-0.795,0L10,9.206l-3.07-3.07c-0.219-0.219-0.575-0.219-0.795,0
                                  c-0.219,0.22-0.219,0.576,0,0.795L9.205,10l-3.07,3.07c-0.219,0.219-0.219,0.574,0,0.794c0.22,0.22,0.576,0.22,0.795,0L10,10.795
                                  l3.069,3.069c0.219,0.22,0.575,0.22,0.795,0c0.219-0.22,0.219-0.575,0-0.794L10.794,10l3.07-3.07
                                  C14.083,6.711,14.083,6.355,13.864,6.136z M10,0.792c-5.086,0-9.208,4.123-9.208,9.208c0,5.085,4.123,9.208,9.208,9.208
                                  s9.208-4.122,9.208-9.208C19.208,4.915,15.086,0.792,10,0.792z M10,18.058c-4.451,0-8.057-3.607-8.057-8.057
                                  c0-4.451,3.606-8.057,8.057-8.057c4.449,0,8.058,3.606,8.058,8.057C18.058,14.45,14.449,18.058,10,18.058z"></path>
                            </svg>Sair</button>
                    </div>
                </nav>

            <main role="main">

	      
                
                <input type="hidden" value="<%=celula%>" name="txt_celula">
                <input type="hidden" value="<%=natureza%>" name="txt_natureza">
                
                <section class="jumbotron text-center">
                    <div class="mx-auto border rounded" style="width: 1200px;">

                        <h1 class="jumbotron-heading">
                            <svg id="color" enable-background="new 0 0 24 24" height="30" viewBox="0 0 24 24" width="30" xmlns="http://www.w3.org/2000/svg"><path d="m21 1h-18c-1.654 0-3 1.346-3 3v16c0 1.654 1.346 3 3 3h18c1.654 0 3-1.346 3-3v-16c0-1.654-1.346-3-3-3z" fill="#607d8b"/><path d="m21 21h-18c-.551 0-1-.448-1-1v-14h20v14c0 .552-.449 1-1 1z" fill="#fff"/><path d="m17 15h-2v-2h2c.553 0 1-.447 1-1s-.447-1-1-1h-2v-2c0-.553-.447-1-1-1s-1 .447-1 1v2h-2v-2c0-.553-.447-1-1-1s-1 .447-1 1v2h-2c-.553 0-1 .447-1 1s.447 1 1 1h2v2h-2c-.553 0-1 .447-1 1s.447 1 1 1h2v2c0 .553.447 1 1 1s1-.447 1-1v-2h2v2c0 .553.447 1 1 1s1-.447 1-1v-2h2c.553 0 1-.447 1-1s-.447-1-1-1zm-6 0v-2h2v2z" fill="#2196f3"/><path d="m12 1h-9c-1.654 0-3 1.346-3 3v16c0 1.654 1.346 3 3 3h9v-2h-9c-.551 0-1-.448-1-1v-14h10z" fill="#546d79"/><path d="m12 13h-1v2h1zm0-7h-10v14c0 .552.449 1 1 1h9v-4h-1v2c0 .553-.447 1-1 1s-1-.447-1-1v-2h-2c-.553 0-1-.447-1-1s.447-1 1-1h2v-2h-2c-.553 0-1-.447-1-1s.447-1 1-1h2v-2c0-.553.447-1 1-1s1 .447 1 1v2h1z" fill="#dedede"/><path d="m10 8c-.553 0-1 .447-1 1v2h-2c-.553 0-1 .447-1 1s.447 1 1 1h2v2h-2c-.553 0-1 .447-1 1s.447 1 1 1h2v2c0 .553.447 1 1 1s1-.447 1-1v-2h1v-2h-1v-2h1v-2h-1v-2c0-.553-.447-1-1-1z" fill="#1d83d4"/></svg> 
                            
                            Nº:<fmt:formatNumber value ="<%=ct_search.getNum_ocorrencia()%>" 
                                              type = "number" pattern="#############"/></h1>
                            <input type="hidden" name="txt_ocorrencia" value = "<fmt:formatNumber value = "<%=ct_search.getNum_ocorrencia()%>" 
                                                      type = "number" pattern="#############"/>"/>
                            <%
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            %>
                            
                        Data de Abertura: <%=dateFormat.format(ct_search.getData_abertura())%>
                        
                        <p class="lead text-muted border">Descrição: <%=ct_search.getDescricao()%></p>
                        <div class="form-row">
                            <div class="col">
                                <h5>Código do Cliente:</h5>
                            </div>
                            <div class="col-3">
                                <h5>Nome do Cliente:</h5>
                            </div>
                            <div class="col">
                                <h5>Tipo Cliente:</h5>
                            </div>
                            <div class="col-3">
                                <h5>Informações no Front?</h5>
                            </div>

                        </div>
                        <div class="form-row">
                            <div class="col">
                                <%=ct_search.getNrc()%>
                            </div>
                            <div class="col-3">
                                <%=ct_search.getNome_cliente()%>
                            </div>
                            <div class="col">
                                <%=ct_search.getTipo_pessoa()%>
                            </div>
                            <div class="col-3">
                                <input type="radio" value="0" name="txt_front" id="front_s"> SIM
                                <input type="radio" value="1" name="txt_front" id="front_n"> NÃO
                            </div>
                        </div>    
                        <div class="form-row">
                            <div class="col">
                                <h5>Tipo:</h5>
                            </div>
                            <div class="col-3">
                                <h5>Natureza:</h5>
                            </div>
                            <div class="col-3">
                                <h5>Login Abertura</h5>
                            </div>
                            <div class="col">
                                <h5>Status:</h5>
                            </div>
                        </div>    
                        <div class="form-row">
                            <div class="col">
                                <%=ct_search.getTipo()%>
                            </div>
                            <div class="col-3">
                                <%=ct_search.getNatureza()%>
                            </div>
                            <div class="col">
                                <%=ct_search.getLogin_abertura()%>
                            </div>
                            <div class="col">
                                <select class="custom-select-sm" name="list_resultado" id="list_resultado">
                                    <option disabled="" selected=""></option>
                                    <option>Contingencia</option>
                                    <option>Aguardando Comprovante</option>
                                    <option>Aguardando Outra Área</option>
                                    <option>Finalizado por outro colaborador</option>
                                </select>
                            </div>
                        </div>  

                        <div class="form-row">
                            <div class="col"><h5>Mensagem:</h5></div>
                        </div>
                        <div class="form-row">
                            
                            <div class="col"><textarea name="txt_msg" rows=6 cols=100 value="<%=ct_search.getMsg()%>">
                                <% if (ct_search.getMsg() != null) { %>
                                    <%=ct_search.getMsg()%>
                                <% } %> 
                                </textarea>   
                            </div>
                        </div>

                        <div class="row ex1" id="controle_email">
                            Data Envio:
                            <% if (ct_search.getEmail().getData_envio() != null) { %>
                            <input type="date" name="txt_dataenvio" value="<%=ct_search.getEmail().getData_envio()%>">
                            <% } else { %>
                            <input type="date" name="txt_dataenvio" value="">
                            <% } %>
                            Data Recebimento:
                            <% if (ct_search.getEmail().getData_recebimento() != null) { %>
                            <input type="date" name="txt_datareceb" value="<%=ct_search.getEmail().getData_recebimento()%>">
                            <% } else { %>
                            <input type="date" name="txt_datareceb" value="">
                            <% } %>
                            <button type="button" onclick="closeFormEmail()">Fechar</button>
                        </div>  
                        <div class="row ex1" id="conveniado">
                            Conveniados:
                            <select id="list_motivo" name="list_conveniado" onchange="multaporevasao();">
                                <%
                                    ArrayList<Conveniado> list_conveniado = (ArrayList<Conveniado>) request.getAttribute("list_conveniado");
                                    for (Conveniado conveniado : list_conveniado) {
                                %> 
                                <option>
                                    <%=conveniado.getNome()%>
                                </option>
                                <% } %>   
                            </select>
                            <div id="multa" name="multa">
                                <select id="mySelect" name="praca">
                                </select>
                            </div>
                            <button type="button" onclick="closeFormConveniado()">Fechar</button>
                        </div>
                        <div class="row ex1" id="loja">
                            Lojas:
                            <select id="list_loja" name="list_loja">
                                <%
                                    ArrayList<String> list_loja = (ArrayList<String>) request.getAttribute("list_loja");
                                    for (String loja : list_loja) {
                                %> 
                                <option name="loja">
                                    <%=loja%>
                                </option>
                                <% } %>   
                            </select>
                            <button type="button" onclick="closeFormLoja()">Fechar</button>
                        </div>    

                        <p>
                            <button type="submit" name="btn_procedente_sc" class="btn btn-primary my-2">
                                <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                     viewBox="0 0 504.12 504.12" width="20" style="enable-background:new 0 0 504.12 504.12;" xml:space="preserve">
                                <circle style="fill:#3DB39E;" cx="252.06" cy="252.06" r="252.06"/>
                                <path style="fill:#37A18E;" d="M463.163,114.609L240.246,345.403l0.394,24.812h10.24l241.428-194.56
                                      C485.218,153.994,475.372,133.12,463.163,114.609z"/>
                                <path style="fill:#F2F1EF;" d="M499.397,103.582l-44.505-44.111c-5.908-5.908-15.754-5.908-22.055,0L242.609,256l-82.314-81.132
                                      c-5.908-5.908-15.754-5.908-22.055,0l-39.385,38.991c-5.908,5.908-5.908,15.754,0,21.662L230.4,365.883
                                      c3.545,3.545,8.271,4.726,12.997,4.332c4.726,0.394,9.452-0.788,12.997-4.332l243.003-240.246
                                      C505.305,119.335,505.305,109.489,499.397,103.582z"/>
                                <path style="fill:#E6E5E3;" d="M256.394,365.883l243.003-240.246c5.908-5.908,5.908-15.754,0-21.662l-7.089-6.695L243.003,342.252
                                      L105.157,207.951l-5.908,5.908c-5.908,5.908-5.908,15.754,0,21.662l131.545,130.363c3.545,3.545,8.271,4.726,12.997,4.332
                                      C248.123,370.609,252.849,369.428,256.394,365.883z"/> 
                                </svg> 
                                PROCEDENTE
                            </button>
                            <button type="submit" name="btn_improcedente_sc" class="btn btn-primary my-2" onclick="validarStatusImp()">
                                <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                     viewBox="0 0 512 512" width="20" style="enable-background:new 0 0 512 512;" xml:space="preserve">
                                <ellipse style="fill:#E04F5F;" cx="256" cy="256" rx="256" ry="255.832"/>
                                <g transform="matrix(-0.7071 0.7071 -0.7071 -0.7071 77.26 32)">
                                <rect x="3.98" y="-427.615" style="fill:#FFFFFF;" width="55.992" height="285.672"/>
                                <rect x="-110.828" y="-312.815" style="fill:#FFFFFF;" width="285.672" height="55.992"/>
                                </svg>
                                IMPROCEDENTE
                            </button>
                            <button type="submit" name="btn_enviar_sc" class="btn btn-primary my-2" onclick="validarStatus()">
                                <svg height="20" viewBox="0 0 512 512" width="20" xmlns="http://www.w3.org/2000/svg"><path d="m274.234375 357.917969-10.507813-96.359375c-.765624-6.996094-6.289062-12.519532-13.285156-13.285156l-96.359375-10.503907c-6.667969-.730469-13.011719 3.0625-15.527343 9.28125l-54.195313 133.820313c-.117187.292968-.226563.585937-.324219.886718-4.777344 14.332032-3.714844 27.351563 2.992188 36.660157 5.820312 8.074219 15.171875 12.523437 26.332031 12.523437h.003906c5.289063 0 10.96875-1 16.882813-2.972656.296875-.097656.59375-.207031.886718-.324219l133.820313-54.195312c6.21875-2.519531 10.007813-8.859375 9.28125-15.53125zm0 0" fill="#00d8e0"/><path d="m263.726562 261.558594c-.382812-3.496094-1.953124-6.625-4.304687-8.976563l-169.375 169.375c5.804687 5.816407 13.910156 8.980469 23.3125 8.984375h.003906c5.285157 0 10.96875-1 16.882813-2.972656.296875-.101562.59375-.210938.886718-.328125l133.820313-54.191406c6.21875-2.519531 10.011719-8.859375 9.28125-15.53125zm0 0" fill="#00acb3"/><path d="m506.035156 12.519531c-5.816406-8.074219-15.167968-12.519531-26.332031-12.519531-5.289063 0-10.972656 1-16.886719 2.972656l-435.101562 145.03125c-23.019532 7.675782-27.214844 21.074219-27.667969 28.375-.453125 7.304688 2.058594 21.117188 23.949219 31.570313l155.457031 74.242187c18.152344 8.671875 41.683594 32.203125 50.351563 50.355469l74.242187 155.453125c9.972656 20.882812 23.117187 24 30.066406 24 6.207031 0 21.542969-2.699219 29.882813-27.714844l145.035156-435.105468c4.777344-14.332032 3.714844-27.351563-2.996094-36.660157zm0 0" fill="#fef4f5"/><path d="m503.015625 8.984375-294.828125 294.832031c9.234375 9.234375 17.285156 19.652344 21.621094 28.730469l74.238281 155.453125c9.972656 20.882812 23.121094 24 30.066406 24 6.207031 0 21.546875-2.699219 29.882813-27.714844l145.035156-435.105468c4.777344-14.332032 3.714844-27.351563-2.996094-36.660157-.917968-1.273437-1.933594-2.445312-3.019531-3.535156zm0 0" fill="#d5eded"/><path d="m218.8125 308.1875c-3.835938 0-7.675781-1.464844-10.605469-4.394531-5.855469-5.859375-5.855469-15.355469 0-21.214844l273.601563-273.601563c5.859375-5.859374 15.355468-5.859374 21.214844 0 5.855468 5.859376 5.855468 15.355469 0 21.210938l-273.605469 273.605469c-2.925781 2.929687-6.765625 4.394531-10.605469 4.394531zm0 0" fill="#a8ebfa"/><path d="m208.207031 303.792969c2.929688 2.929687 6.769531 4.394531 10.605469 4.394531 3.839844 0 7.679688-1.464844 10.605469-4.394531l273.605469-273.605469c5.855468-5.855469 5.855468-15.351562 0-21.210938zm0 0" fill="#76e2f8"/></svg>
                                ENVIAR
                            </button>
                            <button type="button" name="btn_email" class="btn btn-primary my-2" onclick="openFormEmail()">
                                <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                     viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve" width="20">
                                <path style="fill:#FEDB41;" d="M476.499,186.499l-13.202,43.2L316,377H196L47.501,228.5L35.5,186.499l60-60
                                      C98.2,123.5,102.1,122,106,122h300c3.9,0,7.8,1.5,10.499,4.499L476.499,186.499z"/>
                                <path style="fill:#FFCC33;" d="M476.499,186.499l-13.202,43.2L316,377h-60V122h150c3.9,0,7.8,1.5,10.499,4.499L476.499,186.499z"/>
                                <path style="fill:#CAE8F9;" d="M406,0H106c-8.401,0-15,6.599-15,15v392c0,8.399,6.599,15,15,15h300c8.401,0,15-6.601,15-15V15
                                      C421,6.599,414.401,0,406,0z"/>
                                <path style="fill:#B7E0F6;" d="M421,15v392c0,8.399-6.599,15-15,15H256V0h150C414.401,0,421,6.599,421,15z"/>
                                <path style="fill:#17ACE8;" d="M301,167c0-24.901-20.098-45-45-45s-45,20.099-45,45c0,24.899,20.098,45,45,45
                                      c11.7,0,21.899-4.501,30-11.7c29.099,26.4,75,5.4,75-33.3c0-57.9-47.102-105-105-105s-105,47.1-105,105c0,36,17.999,69,48.6,88.5
                                      c17.399,11.1,36.603,16.5,56.4,16.5c16.201,0,32.402-3.6,47.999-10.8c7.5-3.602,10.8-12.301,7.203-19.801
                                      c-3.303-7.8-12.305-10.8-19.805-7.5C279.701,239.299,267.7,242,256,242c-14.099,0-27.898-3.9-40.203-11.7
                                      C193.898,216.2,181,192.8,181,167c0-41.4,33.6-75,75-75s75,33.6,75,75C331,186.799,301,186.799,301,167z M270.7,168.8
                                      c-0.901,7.5-7.2,13.2-14.7,13.2c-8.401,0-15-6.601-15-15c0-8.401,6.599-15,15-15c7.8,0,14.099,6.299,14.7,14.099V168.8z"/>
                                <g>
                                <path style="fill:#1689FC;" d="M311.203,241.399c3.596,7.5,0.297,16.199-7.203,19.801c-15.598,7.2-31.799,10.8-48,10.8v-30
                                      c11.7,0,23.701-2.701,35.398-8.101C298.898,230.6,307.899,233.599,311.203,241.399z"/>
                                <path style="fill:#1689FC;" d="M361,167c0,38.699-45.901,59.7-75,33.3c-8.101,7.2-18.3,11.7-30,11.7v-30
                                      c7.5,0,13.799-5.7,14.7-13.2v-2.701c-0.601-7.8-6.9-14.099-14.7-14.099v-30c24.902,0,45,20.099,45,45c0,19.799,30,19.799,30,0
                                      c0-41.4-33.6-75-75-75V62C313.898,62,361,109.1,361,167z"/>
                                </g>
                                <path style="fill:#FEA832;" d="M35.395,186.395C32.582,189.207,31,193.016,31,197v270c0,11.684,4.398,22.473,13.154,31.844
                                      l43.799-13.798L206.781,366.22L196,347L35.395,186.395z"/>
                                <path style="fill:#FE9923;" d="M481,467V197c0-3.984-1.582-7.793-4.395-10.605L316,347l-12.877,17.123L424.061,485.06l43.785,13.784
                                      c0.11-0.103,0.242-0.128,0.352-0.233C476.576,489.749,481,478.821,481,467z"/>
                                <path style="fill:#FEDB41;" d="M467.802,498.8C458.5,507.499,447.7,512,436,512H76c-11.7,0-22.8-4.501-31.501-12.9
                                      c-0.3,0-0.3,0-0.3-0.3L196,347h120L467.802,498.8z"/>
                                <path style="fill:#FFCC33;" d="M467.802,498.8C458.5,507.499,447.7,512,436,512H256V347h60L467.802,498.8z"/>
                                </svg>
                                CONTROLE DE E-MAIL
                            </button>
                            <button type="button" name="btn_conveniado" class="btn btn-primary my-2" onclick="openFormConveniado()">
                                <svg height="20" viewBox="0 0 58 58" width="20" xmlns="http://www.w3.org/2000/svg"><g id="Page-1" fill="none" fill-rule="evenodd"><g id="027---Toll-Booth" fill-rule="nonzero" transform="translate(0 -1)"><path id="Shape" d="m37 25h15.6c.8420602.0003583 1.5936996.5281051 1.88 1.32l3.52 9.68v8c0 1.1045695-.8954305 2-2 2h-22c-1.1045695 0-2-.8954305-2-2v-8l2.72-7.48z" fill="#e64c3c"/><path id="Shape" d="m51.12 34h-12.24c-.2744343.0102798-.5365639-.1142406-.701977-.3334628s-.213219-.5054596-.128023-.7665372l1.16-3.33c.124561-.3317209.4359257-.5563764.79-.57h10c.3687706-.0026827.7000985.2248558.83.57l1.17 3.33c.0893916.2699364.0361508.5667714-.141483.7888136-.1776338.2220423-.4555418.3391434-.738517.3111864z" fill="#2fa8cc"/><path id="Shape" d="m36 42v-2c0-1.1045695-.8954305-2-2-2h-2v4z" fill="#f0c419"/><path id="Shape" d="m54 42v-2c0-1.1045695.8954305-2 2-2h2v4z" fill="#f0c419"/><path id="Shape" d="m35 46h6v2c0 1.1045695-.8954305 2-2 2h-2c-1.1045695 0-2-.8954305-2-2z" fill="#35495e"/><path id="Shape" d="m49 46h6v2c0 1.1045695-.8954305 2-2 2h-2c-1.1045695 0-2-.8954305-2-2z" fill="#35495e"/><path id="Shape" d="m46 39h-2c-.5522847 0-1-.4477153-1-1s.4477153-1 1-1h2c.5522847 0 1 .4477153 1 1s-.4477153 1-1 1z" fill="#ecf0f1"/><path id="Shape" d="m58 42v2c0 1.1045695-.8954305 2-2 2h-22c-1.1045695 0-2-.8954305-2-2v-2z" fill="#3f5c6c"/><path id="Shape" d="m20 34.78 32.9-32.9c.7478823-.80261271 1.8742222-1.13299673 2.9371556-.86154217 1.0629335.27145456 1.892932 1.10145307 2.1643866 2.16438654.2714545 1.06293346-.0589295 2.18927331-.8615422 2.93715563l-32.14 32.12z" fill="#bdc3c7"/><path id="Shape" d="m37 26.24v-8.48l-6 6v8.48z" fill="#2fa8cc"/><path id="Shape" d="m49 5.76v8.48l-6 6v-8.48z" fill="#2fa8cc"/><rect id="Rectangle-path" fill="#95a5a5" height="9" rx="1" width="58" y="50"/><path id="Shape" d="m3 44h16v6h-18v-4c0-1.1045695.8954305-2 2-2z" fill="#e57e25"/><path id="Shape" d="m22 34c1.6568542 0 3 1.3431458 3 3v13h-6v-13c0-1.6568542 1.3431458-3 3-3z" fill="#547580"/><path id="Rectangle-path" d="m3 18h16v26h-16z" fill="#f0c419"/><rect id="Rectangle-path" fill="#e57e25" height="4" rx="2" width="20" x="1" y="14"/><rect id="Rectangle-path" fill="#35495e" height="8" rx="1" width="8" x="7" y="22"/><path id="Shape" d="m12 27v3h-2v-3c0-.5522847.4477153-1 1-1s1 .4477153 1 1z" fill="#95a5a5"/><path id="Shape" d="m13 35h-4c-.55228475 0-1-.4477153-1-1s.44771525-1 1-1h4c.5522847 0 1 .4477153 1 1s-.4477153 1-1 1z" fill="#f29c1f"/><path id="Shape" d="m13 39h-4c-.55228475 0-1-.4477153-1-1s.44771525-1 1-1h4c.5522847 0 1 .4477153 1 1s-.4477153 1-1 1z" fill="#f29c1f"/><path id="Shape" d="m58 55v3c0 .5522847-.4477153 1-1 1h-56c-.55228475 0-1-.4477153-1-1v-3z" fill="#7f8c8d"/></g></g></svg>
                                CONVENIADO
                            </button>
                            <button type="button" name="btn_loja" class="btn btn-primary my-2" onclick="openFormLoja()">
                                <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                     viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve" width="20">
                                <rect x="33.067" y="136.533" style="fill:#FFD15C;" width="444.8" height="330.667"/>
                                <rect x="283.733" y="228.267" style="fill:#415A6B;" width="162.133" height="238.933"/>
                                <rect x="299.733" y="244.267" style="fill:#8AD7F8;" width="130.133" height="206.933"/>
                                <path style="fill:#F05540;" d="M0,102.4v48c0,28.8,22.4,51.2,51.2,51.2s51.2-22.4,51.2-51.2v-48H0z"/>
                                <path style="fill:#E8EAE9;" d="M102.4,102.4v48c0,28.8,22.4,51.2,51.2,51.2s51.2-22.4,51.2-51.2v-48H102.4z"/>
                                <path style="fill:#F05540;" d="M204.8,102.4v48c0,28.8,22.4,51.2,51.2,51.2c28.8,0,51.2-22.4,51.2-51.2v-48H204.8z"/>
                                <path style="fill:#E8EAE9;" d="M307.2,102.4v48c0,28.8,22.4,51.2,51.2,51.2c28.8,0,51.2-22.4,51.2-51.2v-48H307.2z"/>
                                <path style="fill:#F05540;" d="M409.6,102.4v48c0,28.8,22.4,51.2,51.2,51.2s51.2-22.4,51.2-51.2v-48H409.6z"/>
                                <polygon style="fill:#F3705A;" points="124.8,0 37.333,0 0,102.4 102.4,102.4 "/>
                                <polygon style="fill:#F3F3F3;" points="212.267,0 124.8,0 102.4,102.4 204.8,102.4 "/>
                                <polygon style="fill:#F3705A;" points="299.733,0 212.267,0 204.8,102.4 307.2,102.4 "/>
                                <polygon style="fill:#F3F3F3;" points="387.2,0 299.733,0 307.2,102.4 409.6,102.4 "/>
                                <polygon style="fill:#F3705A;" points="474.667,0 387.2,0 409.6,102.4 512,102.4 "/>
                                <rect y="467.2" style="fill:#CED6E0;" width="512" height="44.8"/>
                                <g>
                                <circle style="fill:#415A6B;" cx="320" cy="347.733" r="13.867"/>
                                <rect x="65.067" y="228.267" style="fill:#415A6B;" width="180.267" height="162.133"/>
                                </g>
                                <rect x="81.067" y="244.267" style="fill:#8AD7F8;" width="148.267" height="130.133"/>
                                <g>
                                <path style="fill:#55C0EB;" d="M158.933,264.533c-2.133-2.133-7.467-2.133-9.6,0L97.067,316.8c-2.133,2.133-2.133,7.467,0,9.6
                                      s7.467,2.133,9.6,0l52.267-52.267C162.133,270.933,162.133,266.667,158.933,264.533z"/>
                                <path style="fill:#55C0EB;" d="M170.667,295.467c-2.133-2.133-7.467-2.133-9.6,0L128,328.533c-2.133,2.133-2.133,7.467,0,9.6
                                      s7.467,2.133,9.6,0l33.067-33.067C173.867,301.867,173.867,297.6,170.667,295.467z"/>
                                </svg>
                                LOJA
                            </button>
                        </p>
                    </div>
                </section>
            </main>
  
        </form>
    </body>
</html>
