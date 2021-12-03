<%-- 
    Document   : home
    Created on : 13/04/2020, 12:19:02
    Author     : RENAN.SOUSA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.User"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Distribuição de Tarefas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">


        <link href="./css/bootstrap-datetimepicker.css" rel="stylesheet">
        <link href="./css/bootstrap.css" rel="stylesheet">
        <link href="./css/bootstrap-datepicker3.css" rel="stylesheet">

        <style>
            
            .svg-icon {
                width: 1.5em;
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
        </style>

    </head>
    <body>    

        <%
            User user = (User) request.getAttribute("user");
            ArrayList<User> list_user = (ArrayList<User>) request.getAttribute("list_user");
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
                    

                    <ul class="navbar-nav mr-auto form-inline"> 
                        <li class="nav-item active">
                            <input class="form-control mr-sm-2" type="search" name="txt_ocorrencia" pattern="[0-9]+$" placeholder="Pesquisar" aria-label="Pesquisar">
                            <button class="btn btn-outline-info my-2 my-sm-0" name="btn_search"  type="submit"><svg class="svg-icon" viewBox="0 0 20 20">
                                <path fill="none" d="M19.129,18.164l-4.518-4.52c1.152-1.373,1.852-3.143,1.852-5.077c0-4.361-3.535-7.896-7.896-7.896
                                      c-4.361,0-7.896,3.535-7.896,7.896s3.535,7.896,7.896,7.896c1.934,0,3.705-0.698,5.078-1.853l4.52,4.519
                                      c0.266,0.268,0.699,0.268,0.965,0C19.396,18.863,19.396,18.431,19.129,18.164z M8.567,15.028c-3.568,0-6.461-2.893-6.461-6.461
                                      s2.893-6.461,6.461-6.461c3.568,0,6.46,2.893,6.46,6.461S12.135,15.028,8.567,15.028z"></path>
                                </svg>&nbsp;Pesquisar</button>
                    </ul>

                    <button class="btn my-2 my-sm-0" name="btn_logout"><svg class="svg-icon" viewBox="0 0 20 20">
                        <path fill="none" d="M13.864,6.136c-0.22-0.219-0.576-0.219-0.795,0L10,9.206l-3.07-3.07c-0.219-0.219-0.575-0.219-0.795,0
                              c-0.219,0.22-0.219,0.576,0,0.795L9.205,10l-3.07,3.07c-0.219,0.219-0.219,0.574,0,0.794c0.22,0.22,0.576,0.22,0.795,0L10,10.795
                              l3.069,3.069c0.219,0.22,0.575,0.22,0.795,0c0.219-0.22,0.219-0.575,0-0.794L10.794,10l3.07-3.07
                              C14.083,6.711,14.083,6.355,13.864,6.136z M10,0.792c-5.086,0-9.208,4.123-9.208,9.208c0,5.085,4.123,9.208,9.208,9.208
                              s9.208-4.122,9.208-9.208C19.208,4.915,15.086,0.792,10,0.792z M10,18.058c-4.451,0-8.057-3.607-8.057-8.057
                              c0-4.451,3.606-8.057,8.057-8.057c4.449,0,8.058,3.606,8.058,8.057C18.058,14.45,14.449,18.058,10,18.058z"></path>
                        </svg>&nbsp;Sair</button>


                </div>
            </nav>
            <div class="modal" id="myModal" role="dialog">
                <div class="modal-dialog">

                    <div class="modal-content">
                        <div class="modal-body">
                            Data Inicial <br/>
                            <input class="form-control" name="date_ini" placeholder="DD/MM/AAAA" type="text">
                            Data Final <br/>
                            <input  class="form-control" name="date_fim" placeholder="DD/MM/AAAA" type="text">
                        </div>
                        <div class="modal-footer">
                            <button type="submit" name="btn_prod" >OK</button><button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>    
                    </div>


                </div>
            </div>
            <br/>
            <main role="main" class="container">
                <div class="jumbotron"><p>
                    <h4>Atribuir a:</h4>
                    <select class="form-control" name="list_user">
                                <%
                                    for (User user_gas : list_user) {
                                %> 
                                <option>
                                    <%=user_gas.getNome()%>
                                </option>
                                <% } %>   
                    </select>
                </p>
                <p>
                    <h4>Nº da Tarefa:</h4> 
                    <input type="text" class="form-control" name="txt_oc_atribuida">
                    
                    <input type="hidden" name="txt_user" value="<%=user.getLogin()%>"/>
                </p>
                </div>
                
                <div>
                    <br/>
                    <button class="btn-lg btn-info" type="submit" name="btn_atribuir" onclick="validarStatus()">Atribuir Tarefa</button>  
                </div>
                <br/>
                
            </main>
        </form>

        <!-- Extra JavaScript/CSS added manually in "Settings" tab -->
        <!-- Include jQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

        <!-- Include Date Range Picker -->
        <script type="text/javascript" src="./js/bootstrap-datepicker.min.js.download"></script>
        <script>
                        $(document).ready(function () {
                            var date_input = $('input[name="date_ini"]'); //our date input has the name "date"
                            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                            date_input.datepicker({
                                format: 'dd/mm/yyyy',
                                container: container,
                                todayHighlight: true,
                                autoclose: true,
                            })
                            var date_input = $('input[name="date_fim"]'); //our date input has the name "date"
                            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                            date_input.datepicker({
                                format: 'dd/mm/yyyy',
                                container: container,
                                todayHighlight: true,
                                autoclose: true,
                            })
                        }
                        )
        </script>
    </body>
</html>
