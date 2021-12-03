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

        <script type="text/javascript">
            function validarStatus() {
                if (document.getElementById("txt_celula").value === "" || document.getElementById("txt_celula").value === null) {

                    document.getElementById("txt_celula").setAttribute("required", "");
                    return false;

                }
            }
        </script>

    </head>
    <body>    

        <%
            User user = (User) request.getAttribute("user");
        %>

        <form action="ControllerReport" method="post">
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
                            <button class="btn btn-outline-info" type="submit" name="btn_assignuser"><svg class="svg-icon" viewBox="0 0 20 20">
                                <path fill="none" d="M14.023,12.154c1.514-1.192,2.488-3.038,2.488-5.114c0-3.597-2.914-6.512-6.512-6.512
                                      c-3.597,0-6.512,2.916-6.512,6.512c0,2.076,0.975,3.922,2.489,5.114c-2.714,1.385-4.625,4.117-4.836,7.318h1.186
                                      c0.229-2.998,2.177-5.512,4.86-6.566c0.853,0.41,1.804,0.646,2.813,0.646c1.01,0,1.961-0.236,2.812-0.646
                                      c2.684,1.055,4.633,3.568,4.859,6.566h1.188C18.648,16.271,16.736,13.539,14.023,12.154z M10,12.367
                                      c-2.943,0-5.328-2.385-5.328-5.327c0-2.943,2.385-5.328,5.328-5.328c2.943,0,5.328,2.385,5.328,5.328
                                      C15.328,9.982,12.943,12.367,10,12.367z"></path>
                                </svg>&nbsp;Atribuir Ocorrência</button>
                            <button class="btn btn-outline-info" type="submit" name="btn_load"><svg class="svg-icon" viewBox="0 0 20 20">
                                <path fill="none" d="M19.305,9.61c-0.235-0.235-0.615-0.235-0.85,0l-1.339,1.339c0.045-0.311,0.073-0.626,0.073-0.949
                                      c0-3.812-3.09-6.901-6.901-6.901c-2.213,0-4.177,1.045-5.44,2.664l0.897,0.719c1.053-1.356,2.693-2.232,4.543-2.232
                                      c3.176,0,5.751,2.574,5.751,5.751c0,0.342-0.037,0.675-0.095,1l-1.746-1.39c-0.234-0.235-0.614-0.235-0.849,0
                                      c-0.235,0.235-0.235,0.615,0,0.85l2.823,2.25c0.122,0.121,0.282,0.177,0.441,0.172c0.159,0.005,0.32-0.051,0.44-0.172l2.25-2.25
                                      C19.539,10.225,19.539,9.845,19.305,9.61z M10.288,15.752c-3.177,0-5.751-2.575-5.751-5.752c0-0.276,0.025-0.547,0.062-0.813
                                      l1.203,1.203c0.235,0.234,0.615,0.234,0.85,0c0.234-0.235,0.234-0.615,0-0.85l-2.25-2.25C4.281,7.169,4.121,7.114,3.961,7.118
                                      C3.802,7.114,3.642,7.169,3.52,7.291l-2.824,2.25c-0.234,0.235-0.234,0.615,0,0.85c0.235,0.234,0.615,0.234,0.85,0l1.957-1.559
                                      C3.435,9.212,3.386,9.6,3.386,10c0,3.812,3.09,6.901,6.902,6.901c2.083,0,3.946-0.927,5.212-2.387l-0.898-0.719
                                      C13.547,14.992,12.008,15.752,10.288,15.752z"></path>
                                </svg>&nbsp;Carregar Base</button>
                        </li>
                    </ul>

                    <ul class="navbar-nav mr-auto form-inline"> 
                        <li class="nav-item active">
                            <input class="form-control mr-sm-2" type="search" name="txt_ocorrencia" pattern="[0-9]+$" placeholder="Pesquisar" aria-label="Pesquisar">
                            <button class="btn btn-outline-info my-2 my-sm-0" name="btn_search"  type="submit"><svg class="svg-icon" viewBox="0 0 20 20">
                                <path fill="none" d="M19.129,18.164l-4.518-4.52c1.152-1.373,1.852-3.143,1.852-5.077c0-4.361-3.535-7.896-7.896-7.896
                                      c-4.361,0-7.896,3.535-7.896,7.896s3.535,7.896,7.896,7.896c1.934,0,3.705-0.698,5.078-1.853l4.52,4.519
                                      c0.266,0.268,0.699,0.268,0.965,0C19.396,18.863,19.396,18.431,19.129,18.164z M8.567,15.028c-3.568,0-6.461-2.893-6.461-6.461
                                      s2.893-6.461,6.461-6.461c3.568,0,6.46,2.893,6.46,6.461S12.135,15.028,8.567,15.028z"></path>
                                </svg>&nbsp;Pesquisar</button>
                            <button class="btn btn-outline-info" data-toggle="modal" data-target="#myModal" name="btn_prod" type="button"><svg class="svg-icon" viewBox="0 0 20 20">
                                <path fill="none" d="M4.68,13.716v-0.169H4.554C4.592,13.605,4.639,13.658,4.68,13.716z M11.931,6.465
                                      c-0.307-0.087-0.623,0.106-0.706,0.432l-1.389,5.484c-0.901,0.084-1.609,0.833-1.609,1.757c0,0.979,0.793,1.773,1.773,1.773
                                      c0.979,0,1.773-0.794,1.773-1.773c0-0.624-0.324-1.171-0.812-1.486l1.377-5.439C12.422,6.887,12.239,6.552,11.931,6.465z
                                      M10.591,14.729H9.408v-1.182h1.183V14.729z M15.32,13.716c0.04-0.058,0.087-0.11,0.126-0.169H15.32V13.716z M10,3.497
                                      c-3.592,0-6.503,2.911-6.503,6.503H4.68c0-2.938,2.382-5.32,5.32-5.32s5.32,2.382,5.32,5.32h1.182
                                      C16.502,6.408,13.591,3.497,10,3.497z M10,0.542c-5.224,0-9.458,4.234-9.458,9.458c0,5.224,4.234,9.458,9.458,9.458
                                      c5.224,0,9.458-4.234,9.458-9.458C19.458,4.776,15.224,0.542,10,0.542z M15.32,16.335v0.167h-0.212
                                      c-1.407,1.107-3.179,1.773-5.108,1.773c-1.93,0-3.701-0.666-5.108-1.773H4.68v-0.167C2.874,14.816,1.724,12.543,1.724,10
                                      c0-4.571,3.706-8.276,8.276-8.276c4.57,0,8.275,3.706,8.275,8.276C18.275,12.543,17.126,14.816,15.32,16.335z"></path>
                                </svg>&nbsp;Produtividade</button>
                            <button class="btn btn-outline-info"  type="submit" name="btn_error">
                                <svg class="svg-icon" viewBox="0 0 20 20">
                                <path fill="none" d="M3.015,4.779h1.164V3.615H3.015V4.779z M18.73,1.869H1.269c-0.322,0-0.582,0.26-0.582,0.582v15.133
                                      c0,0.322,0.26,0.582,0.582,0.582H18.73c0.321,0,0.582-0.26,0.582-0.582V2.451C19.312,2.129,19.052,1.869,18.73,1.869z
                                      M18.148,16.42c0,0.322-0.261,0.582-0.582,0.582H2.433c-0.322,0-0.582-0.26-0.582-0.582V6.525h16.297V16.42z M18.148,5.361H1.851
                                      V3.615c0-0.322,0.26-0.582,0.582-0.582h15.133c0.321,0,0.582,0.26,0.582,0.582V5.361z M7.671,4.779h1.165V3.615H7.671V4.779z
                                      M5.344,4.779h1.164V3.615H5.344V4.779z"></path>
                                </svg>&nbsp;Report Erros</button>
                                
                                <% if (user.getLogin().equals("nadia.ferreira") || user.getLogin().equals("renan.sousa")) { %>
                            <button class="btn btn-outline-info " data-toggle="modal" data-target="#myModal" name="btn_contingencia" type="button"><svg class="svg-icon" viewBox="0 0 20 20">
                                <path fill="none" d="M3.015,4.779h1.164V3.615H3.015V4.779z M18.73,1.869H1.269c-0.322,0-0.582,0.26-0.582,0.582v15.133
                                      c0,0.322,0.26,0.582,0.582,0.582H18.73c0.321,0,0.582-0.26,0.582-0.582V2.451C19.312,2.129,19.052,1.869,18.73,1.869z
                                      M18.148,16.42c0,0.322-0.261,0.582-0.582,0.582H2.433c-0.322,0-0.582-0.26-0.582-0.582V6.525h16.297V16.42z M18.148,5.361H1.851
                                      V3.615c0-0.322,0.26-0.582,0.582-0.582h15.133c0.321,0,0.582,0.26,0.582,0.582V5.361z M7.671,4.779h1.165V3.615H7.671V4.779z
                                      M5.344,4.779h1.164V3.615H5.344V4.779z"></path>
                                </svg>&nbsp;Exportar Erros</button>
                                <% }%>   

                        </li>
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
                <div class="jumbotron">
                    <h5>Por favor, <%=user.getNome()%>, seguir as instruções abaixo para enviar os erros identificados:</h5>
                </div>
                    
                    <p>Salvar a planilha no formato .XLS (SALVAR COMO: Pasta de Trabalho do Excel (97-2003)</p>
                    <p>Diretório: B:\GERAL\APP CGAS\REPORT ERROS\</p>
                    <p>Por favor, se atente para não incluir caracteres especiais no nome da planilha</p>
                    <br>
                    <input type="hidden" name="txt_user" value="<%=user.getLogin()%>"/>
                <div>
                    <p>
                    <input type="file" class="btn-outline-info" name="txt_caminho"/>
                    <svg id="Flat" viewBox="0 0 512 512" width="20" xmlns="http://www.w3.org/2000/svg"><rect fill="#f7cc38" height="368" rx="32" width="400" x="88" y="112"/><path d="m456 480h-400a32 32 0 0 1 -32-32v-368a32 32 0 0 1 32-32h112a32 32 0 0 1 32 32v96h192a32 32 0 0 1 32 32v240a32 32 0 0 0 32 32z" fill="#fbe36a"/><path d="m440 32c-104.4 0-192 87.148-192 192h-48l80 80 88-80h-56c0-104.852 79.881-192 128-192z" fill="#f79539"/></svg>
                    <br>
                    <br><button type="submit" class="btn btn-outline-info" name="btn_enviarerros">Enviar</button>
                    </p>
                </div>
                
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
