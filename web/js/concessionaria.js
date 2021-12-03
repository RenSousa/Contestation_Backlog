    
function multaporevasao() {

    var x = document.getElementById("multa");
    if (x.style.display === "none") {
        x.style.display = "none";
    } else {
        x.style.display = "block";
    }

    if (document.getElementById("list_motivo").value === "APASI") {

        var array = ["IPIRANGA - NORTE", "SORRISO - SUL"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");

        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }
    }

    if (document.getElementById("list_motivo").value === "AUTOPISTA FERNÃO DIA") {

        var array = ["BR381, KM902+630, NORTE, CAMBUÍ - MG",
            "BR381, KM902+630, SUL, CAMBUÍ - MG",
            "BR381, KM733+740, NORTE, CARMO DA CACHOEIRA - MG",
            "BR381, KM733+740, SUL, CARMO DA CACHOEIRA - MG",
            "BR381, KM596+935, NORTE, CARMÓPOLIS DE MINAS - MG",
            "BR381, KM596+935, SUL, CARMÓPOLIS DE MINAS - MG",
            "BR381, KM546+000, NORTE, ITATIAIUÇU - MG",
            "BR381, KM546+000, SUL, ITATIAIUÇU - MG",
            "MAIRIPORÃ - KM 67+680 - NORTE",
            "MAIRIPORÃ - KM 65+700 - NORTE",
            "MAIRIPORÃ - KM 66+680 - SUL",
            "BR381, KM659+000, NORTE, SANTO ANTÔNIO DO AMPARO - MG",
            "BR381, KM659+000, SUL, SANTO ANTÔNIO DO AMPARO - MG",
            "BR381, KM804+880, NORTE, SÃO GONÇALO DO SAPUCAÍ - MG",
            "BR381, KM804+880, SUL, SÃO GONÇALO DO SAPUCAÍ - MG",
            "BR381, KM007+300, NORTE, VARGEM - SP",
            "BR381, KM007+300, SUL, VARGEM - SP"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "AUTOPISTA FLUMINENSE") {

        var array = ["BR101, KM040+520, SUL, CONSELHEIRO JOSINO - RJ",
            "BR101, KM040+520, NORTE, CONSELHEIRO JOSINO - RJ",
            "BR101, KM192+900, NORTE, CASIMIRO DE ABREU - RJ",
            "BR101, KM192+900, SUL, CASIMIRO DE ABREU - RJ",
            "BR101, KM123+050, SUL, SERRINHA - RJ",
            "BR101, KM123+050, NORTE, SERRINHA - RJ",
            "BR101, KM252+860, NORTE, RIO BONITO - RJ",
            "BR101, KM252+860, SUL, RIO BONITO - RJ",
            "BR101, KM299+640, SUL, SÃO GONÇALO - RJ"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "AUTOPISTA PLANALTO") {

        var array = ["BR116, KM233+100, SUL, CORREIA PINTO - S",
            "BR116, KM233+100, NORTE, CORREIA PINTO -",
            "BR116, KM134+400, SUL, FAZENDA RIO GRAND",
            "BR116, KM134+400, NORTE, FAZENDA RIO GRA",
            "BR116, KM081+600, SUL, MONTE CASTELO - S",
            "BR116, KM081+600, NORTE, MONTE CASTELO -",
            "BR116, KM204+100, SUL, RIO NEGRO - PR",
            "BR116, KM204+100, NORTE, RIO NEGRO - PR",
            "BR116, KM152+000, SUL, SANTA CECÍLIA - S",
            "BR116, KM152+000, NORTE, SANTA CECÍLIA -"

        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "AUTOVIAS") {

        var array = ["SP 330, KM281, NORTE, SÃO SIMÃO",
            "SP 330, KM281, SUL, SÃO SIMÃO",
            "SP255, KM45+500, NORTE, GUATAPARÁ",
            "SP255, KM45+500, NORTE, GUATAPARÁ - VIRTUAL",
            "SP255, KM45+500, SUL, GUATAPARÁ - VIRTUAL",
            "SP255, KM45+500, SUL, GUATAPARÁ",
            "SP330, KM253, NORTE, S.R.PASSA QUATRO",
            "SP330, KM253, SUL, S.R.PASSA QUATRO - VIRTUAL",
            "SP330, KM253, SUL, S.R.PASSA QUATRO",
            "SP334, KM344, NORTE, BATATAIS",
            "SP334, KM344, NORTE, BATATAIS - VIRTUAL",
            "SP334, KM344, SUL, BATATAIS - VIRTUAL",
            "SP334, KM344, SUL, BATATAIS",
            "SP344, KM374+500, NORTE, RESTINGA",
            "SP344, KM374+500, NORTE, RESTINGA - VIRTUAL",
            "SP344, KM374+500, SUL, RESTINGA - VIRTUAL",
            "SP344, KM374+500, SUL, RESTINGA"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "BAHIA NORTE") {

        var array = ["CANAL DE TRAFEGO 011+100 - LESTE",
            "CANAL DE TRAFEGO 011+100 - OESTE",
            "CIA AEROPORTO 015+400 - LESTE",
            "CIA AEROPORTO 015+400 - OESTE",
            "MATA DE SÃO JOÃO 044+100 - NORTE",
            "MATA DE SÃO JOÃO 044+100 - SUL",
            "SIMOES FILHO 008+000 - NORTE",
            "SIMOES FILHO 008+000 - SUL",
            "VIA PARAFUSO 016+000 - NORTE",
            "VIA PARAFUSO 016+000 - SUL",
            "CAMAÇARI 002+640 - NORTE"

        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "CAMINHOS") {

        var array = ["IMBITUVA KM 217 LESTE",
            "IMBITUVA KM 217 OESTE",
            "IRATI KM 249 LESTE",
            "IRATI KM 249 OESTE",
            "LAPA KM 191 LESTE",
            "LAPA KM 191 OESTE",
            "PORTO AMAZONAS KM 158 LESTE",
            "PORTO AMAZONAS KM 158 OESTE",
            "RELOGIO KM 302 LESTE",
            "RELOGIO KM 302 OESTE"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "CART") {

        var array = ["SP225, KM251+900, LESTE, PIRATININGA",
            "SP225, KM251+900, OESTE PIRATININGA",
            "SP225, KM300+730, LESTE, RIO PARDO",
            "SP225, KM300+730, OESTE, RIO PARDO",
            "SP270, KM413+400, LESTE, PALMITAL",
            "SP270, KM413+400, OESTE, PALMITAL",
            "SP270, KM453+590, LESTE, ASSIS",
            "SP270, KM453+590, OESTE, ASSIS",
            "SP270, KM513+560, LESTE, RANCHARIA",
            "SP270, KM513+560, OESTE, RANCHARIA",
            "SP270, KM541+540, LESTE, REGENTE FEIJÓ",
            "SP270, KM541+540, OESTE, REGENTE FEIJÓ",
            "SP270, KM590+700, LESTE, PRES. BERNARDES",
            "SP270, KM590+700, OESTE, PRES. BERNARDES",
            "SP270, KM639, LESTE, CAIUÁ",
            "SP270, KM639, OESTE, CAIUÁ",
            "SP327, KM14+500, LESTE, OURINHOS",
            "SP327, KM14+500, OESTE, OURINHOS"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "CCR AUTOBAN") {

        var array = ["SP348, KM77+430, NORTE, ITUPEVA",
            "SP348, KM77+430, SUL, ITUPEVA",
            "SP330, KM117+710, NORTE, NOVA ODESSA",
            "SP330, KM117+710, SUL, NOVA ODESSA",
            "SP330, KM152, NORTE, LIMEIRA",
            "SP330, KM152, SUL, LIMEIRA",
            "SP330, KM26+495, NORTE, SÃO PAULO",
            "SP330, KM26+495, SUL, SÃO PAULO",
            "SP330, KM82, NORTE, VALINHOS",
            "SP330, KM82, SUL, VALINHOS",
            "SP348, KM115+520, NORTE, SUMARÉ",
            "SP348, KM115+520, SUL, SUMARÉ",
            "SP348, KM159+550, NORTE, LIMEIRA",
            "SP348, KM159+550, SUL, LIMEIRA",
            "SP348, KM36+200, SUL, CAIEIRAS",
            "SP348, KM39+047, NORTE, FRANCO DA ROCHA"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "CCR NOVA DUTRA") {

        var array = ["ARUJA NORTE",
            "ARUJA SUL",
            "JACAREÍ NORTE",
            "JACAREÍ SUL",
            "JACAREÍ AVANÇADA NORTE",
            "JACAREÍ AVANÇADA SUL",
            "MOREIRA CESAR NORTE",
            "MOREIRA CESAR SUL",
            "ITATIAIA NORTE",
            "ITATIAIA SUL",
            "VIÚVA GRAÇA NORTE",
            "VIÚVA GRAÇA SUL",
            "VIUVINHA NORTE",
            "VIUVINHA SUL",
            "GUARAREMA SUL",
            "GUARAREMA KM 182,5 - NORTE",
            "ARUJA RODOANEL KM 205 NORTE"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "CCR RODOANEL") {

        var array = ["SP021, KM00+360, NORTE, SÃO PAULO",
            "SP021, KM03+050, OESTE, SÃO PAULO",
            "SP021, KM03+630, LESTE, SÃO PAULO",
            "SP021, KM06+210, NORTE, SÃO PAULO",
            "SP021, KM06+790, OESTE, SÃO PAULO",
            "SP021, KM14+290, OESTE, OSASCO",
            "SP021, KM15+610, NORTE, OSASCO",
            "SP021, KM19+460, SUL, OSASCO",
            "SP021, KM20+870, NORTE, CARAPICUÍBA",
            "SP021, KM24, SUL, OSASCO",
            "SP021, KM24+700, LESTE, SÃO PAULO",
            "SP021, KM25+360, SUL, SÃO PAULO",
            "SP021, KM7, LESTE, SÃO PAULO"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "CCR RODONORTE") {

        var array = ["CARAMBEÍ OESTE - KM 304 + 200M",
            "CARAMBEÍ LESTE KM 304 + 200M",
            "CARAMBEÍ OESTE - KM 304 + 200M - VIRTUAL",
            "CARAMBEÍ LESTE KM 304 + 200M - VIRTUAL",
            "IMBAÚ NORTE KM 377 + 300",
            "IMBAÚ SUL KM 377 + 300",
            "IMBAÚ NORTE KM 377 + 300 - VIRTUAL",
            "IMBAÚ SUL KM 377 + 300 - VIRTUAL",
            "JAGUARIAÍVA - LESTE - KM 223 + 200M",
            "JAGUARIAÍVA - OESTE - KM 223 + 200M",
            "JAGUARIAÍVA - LESTE - KM 223 + 200M - VIRTUAL",
            "JAGUARIAÍVA - OESTE - KM 223 + 200M - VIRTUAL",
            "ORTIGUEIRA NORTE KM 321 + 100",
            "ORTIGUEIRA SUL KM 321 + 100",
            "ORTIGUEIRA NORTE KM 321 + 100 - VIRTUAL",
            "ORTIGUEIRA SUL KM 321 + 100 - VIRTUAL",
            "SÃO LUIZ DO PURUNÃ - NORTE",
            "SÃO LUIZ DO PURUNÃ - SUL",
            "SÃO LUIZ DO PURUNÃ - NORTE - VIRTUAL",
            "SÃO LUIZ DO PURUNÃ - SUL - VIRTUAL",
            "TIBAGI NORTE KM 456 + 900",
            "TIBAGI SUL KM 456 + 900",
            "TIBAGI NORTE KM 456 + 900 - VIRTUAL",
            "TIBAGI SUL KM 456 + 900 - VIRTUAL",
            "WITMARSUM - NORTE",
            "WITMARSUM - SUL",
            "WITMARSUM - NORTE - VIRTUAL",
            "WITMARSUM - SUL - VIRTUAL"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "CCR VIA LAGOS") {

        var array = ["VIA LAGOS - NORTE",
            "VIA LAGOS - SUL"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "CCR VIAOESTE") {

        var array = ["SP075, KM12+500, SUL, ITU",
            "SP270, KM111, LESTE, ARAÇOIABA DA SERRA",
            "SP270, KM111, OESTE, ARAÇOIABA DA SERRA",
            "SP270, KM46+500, OESTE, SÃO ROQUE",
            "SP270, KM78+500, LESTE, ALUMÍNIO",
            "SP280, KM18, OESTE, OSASCO",
            "SP280, KM23, LESTE, BARUERI",
            "SP280, KM32, OESTE, ITAPEVI",
            "SP280, KM74, LESTE, ITU"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "CLN") {

        var array = ["BA 099, KM 14, NORTE, CAMAÇARI",
            "BA 099, KM 14, SUL, CAMAÇARI"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "CENTROVIAS") {

        var array = ["SP225, KM107+500, LESTE, ITIRAPINA",
            "SP225, KM107+500, OESTE, ITIRAPINA",
            "SP225, KM144+150, LESTE, BROTAS",
            "SP225, KM144+150, OESTE, BROTAS",
            "SP225, KM199+300, LESTE, JAÚ",
            "SP225, KM199+300, OESTE, JAÚ",
            "SP225, KM199+300, LESTE, JAÚ (VIRTUAL)",
            "SP225, KM199+300, OESTE, JAÚ (VIRTUAL)",
            "SP310, KM 181+350, SUL, RIO CLARO",
            "SP310, KM 181+650, NORTE, RIO CLARO",
            "SP310, KM 181+650, NORTE, RIO CLARO (VIRTUAL)",
            "SP310, KM 181+350, SUL, RIO CLARO (VIRTUAL)",
            "SP310, KM216+800, NORTE, ITIRAPINA",
            "SP310, KM216+800, SUL, ITIRAPINA"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "COLINAS") {

        var array = ["SP075, KM 62, INDAIATUBA",
            "SP075, KM60+800, INDAIATUBA",
            "SP075, KM25+750, NORTE, ITU PORTICO",
            "SP075, KM25+750, SUL, ITU PORTICO",
            "SP075, KM32+100, NORTE, ITU PORTICO",
            "SP075, KM33+150, SUL, SALTO PORTICO",
            "SP075, KM43+350, NORTE, SALTO PORTICO",
            "SP075, KM44+400, SUL, SALTO PORTICO",
            "SP075, KM66+700, NORTE, CAMPINAS PORTICO",
            "SP075, KM66+700, SUL, CAMPINAS PORTICO",
            "SP075, KM70+650, NORTE, CAMPINAS PORTICO",
            "SP075, KM70+650, SUL, CAMPINAS PORTICO",
            "SP127, KM12+625, RIO CLARO",
            "SP127, KM58+600, RIO DAS PEDRAS",
            "SP280, KM 111+300, BOITUVA",
            "SP280, KM110+400, BOITUVA",
            "SP300, KM 76+300, ITUPEVA",
            "SP300, KM137+722, PORTO FELIZ"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "CONCEBRA") {

        var array = ["ALEXÂNIA KM 43 SUL",
            "GOIANÁPOLIS KM 459 NORTE",
            "GOIANÁPOLIS KM 459 SUL",
            "PROFESSOR JAMIL KM 551 NORTE",
            "PROFESSOR JAMIL KM 551 SUL",
            "ITUMBIARA KM 687 NORTE",
            "ITUMBIARA KM 687 SUL",
            "PRATA KM 123 NORTE",
            "PRATA KM 123 SUL",
            "FRONTEIRA KM 226 NORTE",
            "FRONTEIRA KM 226 SUL",
            "FLORESTAL KM 391 LESTE",
            "FLORESTAL KM 391 OESTE",
            "LUZ KM 514 LESTE",
            "LUZ KM 514 OESTE",
            "CAMPOS ALTOS KM 596 LESTE",
            "CAMPOS ALTOS KM 596 OESTE",
            "PERDIZES KM 732 LESTE",
            "PERDIZES KM 732 OESTE",
            "CAMPO FLORIDO KM 861 LESTE",
            "CAMPO FLORIDO KM 861 OESTE"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "CRO") {

        var array = [
            "AREAL KM 45,5 NORTE",
            "AREAL KM 45,5 SUL",
            "JUIZ DE FORA KM 816,7 NORTE",
            "JUIZ DE FORA KM 816,7 SUL",
            "XEREM KM 102 NORTE",
            "XEREM KM 102 SUL"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "CONCER") {

        var array = [
            "AREAL KM 45,5 NORTE",
            "AREAL KM 45,5 SUL",
            "JUIZ DE FORA KM 816,7 NORTE",
            "JUIZ DE FORA KM 816,7 SUL",
            "XEREM KM 102 NORTE",
            "XEREM KM 102 SUL"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "CRO") {

        var array = [
            "CAMPO VERDE KM 235 + 450 NORTE",
            "CAMPO VERDE KM 235 + 450 SUL",
            "ITIQUIRA KM 33+600 NORTE",
            "ITIQUIRA KM 33+600 SUL",
            "JANGADA KM 398 + 000 NORTE",
            "JANGADA KM 398 + 000 SUL",
            "LUCAS DO RIO VERDE KM 664 +450 NORTE",
            "LUCAS DO RIO VERDE KM 664 +450 SUL",
            "NOBRES KM 498 + 100 NORTE",
            "NOBRES KM 498 + 100 SUL",
            "NOVA MUTUM KM 586 + 900 NORTE",
            "NOVA MUTUM KM 586 + 900 SUL",
            "RONDONOPOLIS KM 133+300 NORTE",
            "RONDONOPOLIS KM 133+300 SUL",
            "SORRISO KM 766 + 700 NORTE",
            "SORRISO KM 766 + 700 SUL",
            "STO ANTONIO LEVERGER KM 302 + 000 NORTE",
            "STO ANTONIO LEVERGER KM 302 + 000 SUL"
        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "DER SP") {

        var array = [
            "ITUPEVA KM 81 LESTE",
            "ITUPEVA KM 81 OESTE"

        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "DERSA") {

        var array = [
            "BALSA - GUARUJA",
            "BALSA BERTIOGA/GUARUJA",
            "BALSA GUARUJA/BERTIOGA",
            "SÃO SEBASTIÃO - ILHA BELA"

        ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "ECO101") {
        var array = ["PEDRO CANÁRIO KM 1, 2 - SUL",
            "PEDRO CANÁRIO KM 1,2 - NORTE",
            "SÃO MATEUS KM 85 - SUL",
            "SÃO MATEUS KM 85 - NORTE",
            "ARACRUZ KM 171,8 - SUL",
            "ARACRUZ KM 171,8 - NORTE",
            "SERRA KM 239,5 - SUL",
            "SERRA KM 239,5 - NORTE",
            "GUARAPARI KM 318,4 - SUL",
            "GUARAPARI KM 318,4 - NORTE",
            "ITAPEMIRIM KM 396,9 - SUL",
            "ITAPEMIRIM KM 396,9 - NORTE",
            "MIMOSO DO SUL KM 449,5 - SUL",
            "MIMOSO DO SUL KM 449,5 - NORTE", ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "ECOCATARATAS") {
        var array = ["CANDÓI - KM 388 - LESTE",
            "CANDÓI - KM 388 - OESTE",
            "CASCAVEL - KM 568 - LESTE",
            "CASCAVEL - KM 568 - OESTE",
            "CÉU AZUL - KM 620 - OESTE",
            "CÉU AZUL - KM 620 - LESTE",
            "LARANJEIRAS DO SUL - KM 464 - OESTE",
            "LARANJEIRAS DO SUL - KM 464 - LESTE",
            "SÃO MIGUEL DO IGUAÇU - KM 704 - LESTE",
            "SÃO MIGUEL DO IGUAÇU - KM 704 - OESTE", ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "ECONORTE") {
        var array = ["JACAREZINHO KM 1 + 300 - LESTE",
            "JACAREZINHO KM 1+300 - OESTE",
            "MARQUES DOS REIS KM 0+600 - OESTE",
            "MARQUES DOS REIS KM 0+600 - LESTE",
            "JATAIZINHO KM 126 + 700 - LESTE",
            "JATAIZINHO KM 126 + 700 - OESTE",
            "SERTANEJA KM 3+600 - LESTE",
            "SERTANEJA KM 3+600 - OESTE",
            "CAMBARA KM 31 - LESTE",
            "CAMBARA KM 31 - OESTE"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "ECOPISTAS") {
        var array = ["SP070, KM114, LESTE, CAÇAPAVA",
            "SP070, KM114, OESTE, CAÇAPAVA",
            "SP070, KM32+900, LESTE, ITAQUAQUECETUBA",
            "SP070, KM32+900, OESTE, ITAQUAQUECETUBA",
            "SP070, KM57+800, LESTE, GUARAREMA",
            "SP070, KM57+800, OESTE, GUARAREMA",
            "SP070, KM92+500, LESTE, S.J. CAMPOS",
            "SP070, KM92+500, OESTE, S.J. CAMPOS", ];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "ECOPONTE") {
        var array = ["PONTE RIO - NITEROI KM322 NORTE"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "ECOSUL") {
        var array = ["CAPÃO SECO - KM 52, 18 - RIO GRANDE",
            "CAPÃO SECO KM 52,18 - PELOTAS",
            "CRISTAL KM 430,79 - PELOTAS",
            "CRISTAL KM 430,79 PORTO ALEGRE",
            "GLÓRIA KM 111,46 - CANGUÇU",
            "GLÓRIA KM 111,46 - PELOTAS",
            "PAVÃO KM 541,20 - JAGUARÃO",
            "PAVÃO KM 541,20 - PELOTAS",
            "RETIRO KM 510,775 - PELOTAS",
            "RETIRO KM 510,775 - PORTO ALEGRE"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "ECOVIA C. DO MAR") {
        var array = ["SÃO JOSÉ DOS PINHAIS KM 60, 5 - CURITIBA",
            "SÃO JOSÉ DOS PINHAIS KM 60,5 - PARANAGUÁ"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "ECOVIAS") {
        var array = ["SP160, KM15 + 917, SUL, DIADEMA",
            "SP160, KM20+100, SUL, DIADEMA",
            "SP160, KM24+260, SUL, S.B. DO CAMPO",
            "SP160, KM32+381, SUL, S.B. DO CAMPO",
            "SP150, KM31+106, SUL, S.B. DO CAMPO",
            "SP055, KM279+950, LESTE, SÃO VICENTE",
            "SP055, KM250+464, OESTE, SANTOS"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "EGR II") {
        var array = ["BOA VISTA DO SUL - KM 78, 9  ASCENDENTE",
            "BOA VISTA DO SUL - KM 78,9  DESCENDENTE",
            "CAMPO BOM KM 19 LESTE",
            "CAMPO BOM KM 19 OESTE",
            "CANDELÁRIA KM 131 + 580 LESTE",
            "CANDELÁRIA KM 131 + 580 OESTE",
            "COXILHA",
            "CRUZEIRO DO SUL - KM 19,8 ASCENDENTE",
            "CRUZEIRO DO SUL - KM 19,8 DESCENDENTE",
            "ENCANTADO - KM 93,9 ASCENDENTE",
            "ENCANTADO - KM 93,9 DESCENDENTE",
            "FLORES DA CUNHA - KM 101 ASCENDENTE",
            "FLORES DA CUNHA - KM 101 DESCENDENTE",
            "GRAMADO 27+580 LESTE",
            "GRAMADO 27+580 OESTE",
            "PORTÃO",
            "SANTO ANTONIO DA PATRULHA ASCENDENTE",
            "SANTO ANTONIO DA PATRULHA DESCENDENTE",
            "SAO FRANCISCO DE PAULA 52+930 LESTE",
            "SAO FRANCISCO DE PAULA 52+930 OESTE",
            "TRES COROAS 23+690 LESTE",
            "TRES COROAS 23+690 OESTE",
            "VENÂNCIO AIRES KM 86 + 880 LESTE",
            "VENÂNCIO AIRES KM 86 + 880 OESTE",
            "VIAMÃO ASCENDENTE",
            "VIAMÃO DESCENDENTE"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "ENTREVIAS") {
        var array = ["SP 330, KM 405, NORTE, ITUVERAVA",
            "SP 330, KM 405, SUL, ITUVERAVA",
            "SP 330, KM 350, SUL, SALES DE OLIVEIRA",
            "SP 330, KM 350, NORTE, SALES DE OLIVEIRA",
            "SP 322, KM 327+500, LESTE, SERTAOZINHO",
            "SP 322, KM 327+500, OESTE, SERTAOZINHO",
            "SP 322, KM 361+500, OESTE, PITANGUEIRAS",
            "SP 322, KM 361+500, LESTE, PITANGUEIRAS",
            "SP 333, KM 234+276, OESTE, PONGAI",
            "SP 333, KM 234+276, LESTE, PONGAI",
            "SP 333, KM 315+130, OESTE, MARILIA",
            "SP 333, KM 315+130, LESTE, MARILIA",
            "SP 333, KM 354+374, LESTE, ECHAPORA",
            "SP 333, KM 354+374, OESTE, ECHAPORA",
            "SP 333, KM 449+760, OESTE, FLORINEA",
            "SP 333, KM 449+760, LESTE, FLORINEA"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "INTERVIAS") {
        var array = ["SP147, KM127 + 200, LESTE, IRACEMÁPOLIS",
            "SP147, KM127+200, OESTE, IRACEMÁPOLIS",
            "SP147, KM52, LESTE, MOGI MIRIM",
            "SP147, KM52, OESTE, MOGI MIRIM",
            "SP147, KM91+300, LESTE, ENG. COELHO",
            "SP147, KM91+300, OESTE, ENG. COELHO",
            "SP191, KM027+500, LESTE, ARARAS",
            "SP191, KM027+500, OESTE, ARARAS",
            "SP191, KM59, LESTE, RIO CLARO",
            "SP191, KM59, OESTE, RIO CLARO",
            "SP215, KM104+400, LESTE, DESCALVADO",
            "SP215, KM104+400, OESTE, DESCALVADO",
            "SP215, KM65+550, LESTE, SANTA CRUZ",
            "SP215, KM65+550, OESTE, SANTA CRUZ",
            "SP330, KM181+760, NORTE, LEME",
            "SP330, KM181+760, SUL, LEME",
            "SP330, KM215, NORTE, PIRASSUNUNGA",
            "SP330, KM215, SUL, PIRASSUNUNGA"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "INTERVIAS MT") {
        var array = ["INTERVIAS LESTE",
            "INTERVIAS OESTE"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "LAMSA") {
        var array = ["BARRA - FUNDÃO",
            "FUNDÃO - BARRA"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "LITORAL SUL") {
        var array = ["BR116, KM298 + 800, SUL, S LOURENÇO SERRA",
            "BR116, KM298+800,NORTE, S LOURENÇO SERRA",
            "BR101, KM001+350, SUL, GARUVA - SC",
            "BR116, KM370+400, NORTE, MIRACATU - SP",
            "BR101, KM079+300, SUL, ARAQUARI - SC",
            "BR101, KM079+300, NORTE, ARAQUARI - SC",
            "BR116, KM485+700, SUL, CAJATI - SP",
            "BR101, KM157+400, NORTE, PORTO BELO - SC",
            "BR101, KM299+640, SUL, SÃO GONÇALO - RJ",
            "BR101, KM243+000, NORTE, PALHOÇA - SC"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "MGO RODOVIAS") {
        var array = ["ARAGUARI I KM 013 + 730 NORTE",
            "ARAGUARI I KM 013+730 SUL",
            "ARAGUARI II KM 051+475 NORTE",
            "ARAGUARI II KM 051+475 SUL",
            "CAMPO ALEGRE KM 226+000 NORTE",
            "CAMPO ALEGRE KM 226+000 SUL",
            "DELTA KM 198+060 NORTE",
            "DELTA KM 198+060 SUL",
            "IPAMERI KM 143+985 SUL",
            "IPAMERI KM 143+985 NORTE",
            "UBERABA KM 104+900 NORTE",
            "UBERABA KM 104+900 SUL"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "MORRO DA MESA") {
        var array = ["PRIMAVERA DO LESTE - NORTE",
            "PRIMAVERA DO LESTE - SUL",
            "RONDONÓPOLIS NORTE",
            "RONDONÓPOLIS SUL"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "MSVIA") {
        var array = ["CAARAPÓ 227 + 993 NORTE",
            "CAARAPÓ 227 + 993 SUL",
            "CAMPO GRANDE 432 + 111 NORTE",
            "CAMPO GRANDE 432 + 111 SUL",
            "ITAQUIRAÍ 113 + 253 NORTE",
            "ITAQUIRAÍ 113 + 253 SUL",
            "JARAGUARI 533 + 824 NORTE",
            "JARAGUARI 533 + 824 SUL",
            "MUNDO NOVO 28 + 209 NORTE",
            "MUNDO NOVO 28 + 209 SUL",
            "PEDRO GOMES - SONORA 817 + 837 NORTE",
            "PEDRO GOMES - SONORA 817 + 837 SUL",
            "RIO BRILHANTE 313 + 725 NORTE",
            "RIO BRILHANTE 313 + 725 SUL",
            "RIO VERDE 703 + 510 NORTE",
            "RIO VERDE 703 + 510 SUL",
            "SÃO GABRIEL 603 + 41 NORTE",
            "SÃO GABRIEL 603 + 41 SUL"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "NASCENTE DAS GERAIS") {
        var array = ["CÓRREGO FUNDO - KM 219 + 900",
            "ITAUNA - KM 81",
            "PASSOS - KM 333",
            "PIUMHI - KM 270 + 700",
            "PRATÁPOLIS - KM 389",
            "SÃO SEBASTIÃO DO OESTE - KM 140 + 500"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "PEDÁGIO ILHABELA") {
        var array = ["TPA ILHABELA, SUL"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "PORTO MORRINHO") {
        var array = ["CAMPO GRANDE",
            "CORUMBA"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "PREF. DE ITIRAPINA") {
        var array = ["PEDAGIO ECOLÓGICO MUNICIPAL KM 10 NORTE",
            "PEDAGIO ECOLÓGICO MUNICIPAL KM 10 SUL"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "RÉGIS BITTENCOURT") {
        var array = ["BR116, KM542 + 900, NORTE, BARRA DO TURVO - SP",
            "BR116, KM542+900, SUL, BARRA DO TURVO - SP",
            "BR116, KM485+700, NORTE, CAJATI - SP",
            "BR116, KM485+700, SUL, CAJATI - SP",
            "BR116, KM057+100, SUL, CAMPINA GRANDE DO SUL - PR",
            "BR116, KM057+100, NORTE, CAMPINA GRANDE DO SUL - PR",
            "BR116, KM298+800, SUL, SÃO LOURENÇO DA SERRA - SP",
            "BR116, KM298+800, NORTE, SÃO LOURENÇO DA SERRA - SP",
            "BR116, KM426+600, NORTE, JUQUIÁ - SP",
            "BR116, KM426+600, SUL, JUQUIÁ - SP",
            "BR116, KM370+400, NORTE, MIRACATU - SP",
            "BR116, KM370+400, SUL, MIRACATU - SP"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "RENOVIAS") {
        var array = ["SP340, KM123 + 500, NORTE, CAMPINAS",
            "SP340, KM123+500, SUL, CAMPINAS",
            "SP340, KM123+500, NORTE, CAMPINAS - PONTO A PONTO",
            "SP340, KM123+500, SUL, CAMPINAS - PONTO A PONTO",
            "SP340, KM147+200, NORTE, STO ANTONIO POS",
            "SP340, KM147+200, SUL, STO ANTONIO POSSE",
            "SP342, KM191+890, OESTE, E. S. DO PINHAL",
            "SP342, KM191+890, LESTE, E. S. DO PINHAL",
            "SP340, KM192+840, NORTE, MOGI GUAÇU",
            "SP340, KM192+840, SUL, MOGI GUAÇU",
            "SP340, KM221+290, NORTE, CASA BRANCA",
            "SP340, KM221+290, SUL, CASA BRANCA",
            "SP340, KM254+690, NORTE, CASA BRANCA",
            "SP340, KM254+690, SUL, CASA BRANCA",
            "SP344, KM219, LESTE, S. J. BOA VISTA",
            "SP344, KM219, OESTE, S. J. BOA VISTA",
            "SP344, KM230+440, LESTE, S. J. BOA VISTA",
            "SP344, KM230+440, LESTE, S. J. BOA VISTA - VIRTUAL",
            "SP342, KM240+340, LESTE, ÁGUAS DA PRATA",
            "SP342, KM240+340, OESTE, ÁGUAS DA PRATA",
            "SP342, KM240+340, LESTE, ÁGUAS DA PRATA - VIRTUAL",
            "SP342, KM240+340, OESTE, ÁGUAS DA PRATA - VIRTUAL",
            "SP350, KM252+140, NORTE, ITOBI",
            "SP350, KM252+140, NORTE, ITOBI - VIRTUAL"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

    if (document.getElementById("list_motivo").value === "RIO TERESÓPOLIS") {
        var array = ["ENGENHEIRO PIERRE BERMAN - NORTE",
            "ENGENHEIRO PIERRE BERMAN - SUL",
            "PA1 SANTO ALEIXO NORTE",
            "PA1 SANTO ALEIXO SUL",
            "PA2 SANTA GUILHERMINA NORTE",
            "PA2 SANTA GUILHERMINA SUL"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "RODOVIA DA MUDANCA") {
        var array = ["LUCAS DO RIO VERDE LESTE",
            "LUCAS DO RIO VERDE OESTE"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }
    }

    if (document.getElementById("list_motivo").value === "RODOVIA DO AÇO") {
        var array = ["SAPUCAI - KM 125 - SUL",
            "SAPUCAI - KM 125 - NORTE",
            "PARAÍBA - KM 195 - SUL",
            "PARAÍBA - KM 195 - NORTE",
            "BARRA - KM 265 - SUL",
            "BARRA - KM 265 - NORTE"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "RODOVIAS DO TIETÊ") {
        var array = ["SP101, KM29 + 700, LESTE, MONTE MOR",
            "SP101, KM29+700, OESTE, MONTE MOR",
            "SP101, KM55+800, LESTE, RAFARD",
            "SP101, KM55+800, OESTE, RAFARD",
            "SP300, KM192+100, LESTE, CONCHAS",
            "SP300, KM192+100, OESTE, CONCHAS",
            "SP300, KM228+200, LESTE, ANHEMBI",
            "SP300, KM228+200, OESTE, ANHEMBI",
            "SP300, KM259+300, LESTE, BOTUCATU",
            "SP300, KM259+300, OESTE, BOTUCATU",
            "SP300, KM285, LESTE, AREIÓPOLIS",
            "SP300, KM285, OESTE, AREIÓPOLIS",
            "SP300, KM314, LESTE, AGUDOS",
            "SP300, KM314, OESTE, AGUDOS",
            "SP308, KM109+300, NORTE, SALTO",
            "SP308, KM109+300, SUL, SALTO",
            "SP308, KM147+300, NORTE, RIO DAS PEDRAS",
            "SP308, KM147+300, SUL, RIO DAS PEDRAS"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "ROTA 116") {
        var array = ["CACHOEIRAS DE MACACU - KM 48, 8 NORTE",
            "CACHOEIRAS DE MACACU - KM 48,8 SUL",
            "CORDEIRO - KM 122,3 NORTE",
            "CORDEIRO - KM 122,3 SUL",
            "ITABORAÍ - KM 1,9 SUL",
            "ITABORAÍ - KM 1,9 NORTE",
            "NOVA FRIBURGO - KM 90,3 SUL",
            "NOVA FRIBURGO - KM 90,3 NORTE"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "ROTA DAS BANDEIRAS") {
        var array = ["SP063, KM10 + 370, LESTE, ITATIBA",
            "SP063, KM10+370, OESTE, ITATIBA",
            "SP065, KM110+100, NORTE, ITATIBA",
            "SP065, KM110+100, SUL, ITATIBA",
            "SP065, KM26+500, NORTE, IGARATÁ",
            "SP065, KM26+500, SUL, IGARATÁ",
            "SP065, KM79+900, NORTE, ATIBAIA",
            "SP065, KM79+900, SUL, ATIBAIA",
            "SP332, KM132+500, NORTE, PAULÍNIA",
            "SP332, KM 119, NORTE, PAULINIA PORTICO",
            "SP332, KM 119+200, SUL, PAULINIA PORTICO",
            "SP332, KM135+500, NORTE, COSMÓPOLIS",
            "SP332, KM135+500, SUL, COSMÓPOLIS",
            "SP332, KM146+400, NORTE, COSMOPOLIS PORT",
            "SP 332 KM 146+600 SUL COSMOPOLIS PORTICO",
            "SP332, KM159+700, NORTE, ENG. COELHO",
            "SP332, KM159+700, SUL, ENG. COELHO",
            "SP360, KM73+740, NORTE, ITATIBA PORTICO",
            "SP360, KM73+950, SUL, ITATIBA PORTICO",
            "SP360, KM77+100, NORTE, ITATIBA",
            "SP360, KM77+100, SUL, ITATIBA"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "ROTA DO ATLÂNTICO") {
        var array = ["CABO DE SANTO AGOSTINHO 030 + 500 - SUL",
            "GAIBÚ 035+800 - SUL",
            "IPOJUCA 001+000 - LESTE",
            "NOSSA SENHORA DO Ó 049+000 - NORTE",
            "SUAPE 040+700 - SUL"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "ROTA DOS COQUEIROS") {
        var array = ["BARRA DE JANGADA 000 + 000 - SUL",
            "ITAPUAMA 006+500 - NORTE"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "SPMAR") {
        var array = ["SP021, KM124 + 740, LESTE, ITAQUAQUECETUBA",
            "SP021, KM128+740, LESTE, ARUJÁ",
            "SP021, KM87+940, SUL, RIBEIRÃO PIRES",
            "SP021, KM50+500, OESTE, PARELHEIROS",
            "SP021, KM075, OESTE, S. B. DO CAMPO",
            "SP021, KM70+200, LESTE, S. B. DO CAMPO",
            "SP021, KM70+300, LESTE, S. B. DO CAMPO",
            "SP021, KM71+400, SUL, S. B. DO CAMPO",
            "SP021, KM86+950, LESTE , RIBEIRÃO PIRES",
            "SPA086, KM000+700 M, SUL, RIBEIRAO PIRES",
            "SP021, KM000+300 ,LESTE, RIBEIRAO PIRES"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "SPS") {
        var array = ["NOVA MUTUM SENTIDO SANTA RITA - LESTE",
            "STA. RITA SENTIDO NOVA MUTUM - OESTE"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }
    }
    if (document.getElementById("list_motivo").value === "SPVIAS") {
        var array = ["SP127, KM128 + 900, NORTE, TATUÍ",
            "SP127, KM133+900, SUL, ITAPETININGA",
            "SP127, KM196+725, NORTE, CAPÃO BONITO",
            "SP127, KM196+725, SUL, CAPÃO BONITO",
            "SP255, KM240+300, NORTE, AVARÉ",
            "SP255, KM240+300, SUL, AVARÉ",
            "SP258, KM250+145, LESTE, BURI",
            "SP258, KM250+145, OESTE, BURI",
            "SP258, KM326+637, LESTE, ITARARÉ",
            "SP258, KM326+637, OESTE, ITARARÉ",
            "SP270, KM135+300, LESTE, SARAPUÍ",
            "SP270, KM135+300, OESTE, SARAPUÍ",
            "SP280, KM158+300, LESTE, QUADRA",
            "SP280, KM158+300, OESTE, QUADRA",
            "SP280, KM208+400, LESTE, ITATINGA",
            "SP280, KM208+400, OESTE, ITATINGA",
            "SP280, KM278, LESTE, IARAS",
            "SP280, KM278, OESTE, IARAS"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "TAMOIOS") {
        var array = ["SP 099, KM 16 + 100, NORTE, JAMBEIRO",
            "SP 099, KM 16+100, SUL, JAMBEIRO",
            "SP 099, KM 59+360, NORTE, PARAIBUNA",
            "SP 099, KM 59+360, SUL, PARAIBUNA"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }
    }
    if (document.getElementById("list_motivo").value === "TEBE") {
        var array = ["SP323, KM019 + 081, NORTE, MONTE ALTO",
            "SP323, KM019+081, SUL, MONTE ALTO",
            "SP326, KM407+479, NORTE, COLINA",
            "SP326, KM407+479, SUL, COLINA",
            "SP351, KM184+250, LESTE, PIRANGI",
            "SP351, KM184+250, OESTE, PIRANGI"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "TRANSBRASILIANA") {
        var array = ["JOSÉ BONIFÁCIO - KM 98, 5 - NORTE",
            "JOSÉ BONIFÁCIO - KM 98,5 - SUL",
            "LINS - KM 183,8 - NORTE",
            "LINS - KM 183,8 - SUL",
            "MARÍLIA - KM 268,1 - NORTE",
            "MARÍLIA - KM 268,1 - SUL",
            "ONDA VERDE - KM 35,8 - NORTE",
            "ONDA VERDE - KM 35,8 - SUL"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "TRIANGULO DO SOL") {
        var array = ["SP310, KM282 + 400, NORTE, ARARAQUARA",
            "SP310, KM282+400, SUL, ARARAQUARA",
            "SP310, KM346+404, NORTE, AGULHA",
            "SP310, KM346+404, SUL, AGULHA",
            "SP310, KM398+500, NORTE, CATIGUA",
            "SP310, KM398+500, SUL, CATIGUA",
            "SP326, KM307+600, NORTE, DOBRADA",
            "SP326, KM307+600, SUL, DOBRADA",
            "SP326, KM357, NORTE, TAIUVA",
            "SP326, KM357, SUL, TAIUVA",
            "SP333, KM110+600, NORTE, JABOTICABAL",
            "SP333, KM110+600, SUL, JABOTICABAL",
            "SP333, KM179+025, NORTE, ITAPOLIS",
            "SP333, KM179+025, SUL, ITAPOLIS"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "VIA 040") {
        var array = ["CRISTALINA KM 93 SUL",
            "CRISTALINA KM 93 NORTE",
            "PARACATU KM 17 SUL",
            "PARACATU KM 17 NORTE",
            "LAGOA GRANDE KM 91 SUL",
            "LAGOA GRANDE KM 91 NORTE",
            "JOAO PINHEIRO KM 172 SUL",
            "JOAO PINHEIRO KM 172 NORTE",
            "SAO GONCALO DO ABAETE KM 254 SUL",
            "SAO GONCALO DO ABAETE KM 254 NORTE",
            "FELIXLANDIA KM 328 SUL",
            "FELIXLANDIA KM 328 NORTE",
            "CURVELO KM 405 SUL",
            "CURVELO KM 405 NORTE",
            "CAPIM BRANCO KM 487 SUL",
            "CAPIM BRANCO KM 487 NORTE",
            "ITABIRITO KM 577 SUL",
            "ITABIRITO 577 NORTE",
            "CONSELHEIRO LAFAIETE KM 642 SUL",
            "CONSELHEIRO LAFAIETE KM 642 NORTE",
            "BARBACENA KM 714 SUL",
            "BARBACENA KM 714 NORTE"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "VIA BAHIA") {
        var array = ["AMÉLIA RODRIGUES KM 551 + 094 - LESTE",
            "AMÉLIA RODRIGUES KM 551+094 - OESTE",
            "MANUEL VITORINO KM 698+041 - NORTE",
            "MANUEL VITORINO KM 698+041 - SUL",
            "NOVA ITARANA KM 566+405 - NORTE",
            "NOVA ITARANA KM 566+405 - SUL",
            "PLANALTO KM 773+819 - NORTE",
            "PLANALTO KM 773+819 - SUL",
            "RAFAEL JAMBEIRO KM 482+138 - NORTE",
            "RAFAEL JAMBEIRO KM 482+138 - SUL",
            "SIMOES FILHO KM 597+728 - LESTE",
            "SIMOES FILHO KM 597+728 - OESTE",
            "VEREDINHA KM 873+499 - NORTE",
            "VEREDINHA KM 873+499 - SUL"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "VIAPAR") {
        var array = ["ARAPONGAS LESTE KM 178 + 848",
            "ARAPONGAS OESTE KM 178 + 848",
            "CAMPO MOURÃO NORTE KM 377 + 895",
            "CAMPO MOURÃO SUL KM 377 + 895",
            "CASTELO BRANCO LESTE KM 148 + 961",
            "CASTELO BRANCO OESTE KM 148 + 961",
            "CORBÉLIA NORTE KM 493 + 795",
            "CORBÉLIA SUL KM 493 + 795",
            "FLORESTA NORTE - KM 127 + 066",
            "FLORESTA SUL - KM 127 + 066",
            "MARIALVA LESTE KM 200 + 964",
            "MARIALVA OESTE KM 200 + 964"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "VIARIO") {
        var array = ["PRINCIPAL NORTE",
            "PRINCIPAL SUL",
            "ALÇA DE ACESSO 100, NORTE",
            "ALÇA DE ACESSO 200, SUL"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "VIARONDON") {
        var array = ["SP300, KM367 + 700, LESTE, AVAÍ",
            "SP300, KM367+700, OESTE, AVAÍ",
            "SP300, KM400+800, LESTE, PIRAJUÍ",
            "SP300, KM400+800, OESTE, PIRAJUÍ",
            "SP300, KM455+700, LESTE, PROMISSÃO",
            "SP300, KM455+700, OESTE, PROMISSÃO",
            "SP300, KM497+700, LESTE, GLICÉRIO",
            "SP300, KM497+700, OESTE, GLICÉRIO",
            "SP300, KM562, LESTE, RUBIÁCEA",
            "SP300, KM562, OESTE, RUBIÁCEA",
            "SP300, KM590+400, LESTE, LAVÍNIA",
            "SP300, KM590+400, OESTE, LAVÍNIA",
            "SP300, KM621+200, LESTE, GUARAÇAÍ",
            "SP300, KM621+200, OESTE, GUARAÇAÍ",
            "SP300, KM655+400, LESTE, CASTILHO",
            "SP300, KM655+400, OESTE, CASTILHO"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "VIAPAULISTA") {
        var array = ["SP 330, KM281, NORTE, SÃO SIMÃO",
            "SP 330, KM281, SUL, SÃO SIMÃO",
            "SP334, KM344, NORTE, BATATAIS",
            "SP334, KM344, SUL, BATATAIS",
            "SP255, KM45+500, NORTE, GUATAPARÁ",
            "SP255, KM45+500, SUL, GUATAPARÁ",
            "SP344, KM374+500, NORTE, RESTINGA",
            "SP344, KM374+500, SUL, RESTINGA",
            "SP330, KM253, NORTE, S.R.PASSA QUATRO",
            "SP330, KM253, SUL, S.R.PASSA QUATRO",
            "SP255, KM117+220,SUL, BOA ESPERANÇA DO SUL",
            "SP255, KM117+220,NORTE, BOA ESPERANÇA DO SUL",
            "SP255, KM165+600, SUL, JAÚ",
            "SP255, KM165+600, NORTE, JAÚ",
            "SP255, KM229+040, SUL, BOTUCATU",
            "SP255, KM229+040, NORTE, BOTUCATU",
            "SP255, KM306, SUL, ITAÍ",
            "SP255, KM306, NORTE, ITAÍ",
            "SP249, KM331+500, SUL, CORONEL MACEDO",
            "SP249, KM331+500, NORTE, CORONEL MACEDO"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "BOMBINHAS") {
        var array = ["TPA BOMBINHAS",
            "TPA BOMBINHAS - ENTRADA SECUNDÁRIA"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "CCR VIASUL") {
        var array = ["BR290, 19 + 430, LESTE, SANTO ANTÔNIO DA PATRULHA",
            "BR290, 77+800, LESTE, GRAVATAI",
            "BR 290, 77+800, OESTE, GRAVATAI"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }
    if (document.getElementById("list_motivo").value === "ECO135") {
        var array = ["MONTES CLAROS KM 399, 1 - SUL",
            "MONTES CLAROS KM 399,1 - NORTE",
            "BOCAIUVA KM 466,2 - SUL",
            "BOCAIUVA KM 466,2 - NORTE",
            "BUENOPOLIS KM 523,3 - SUL",
            "BUENOPOLIS KM 523,3 - NORTE",
            "CORINTO KM 583 - SUL",
            "CORINTO KM 583 - NORTE",
            "CURVELO KM 634,1 - SUL",
            "CURVELO KM 634,1 - NORTE",
            "CURVELO KM 24,9 - SUL",
            "CURVELO KM 24,9 - NORTE"];
        var selectList = document.getElementById("mySelect");
        selectList.setAttribute("id", "mySelect");
        selectList.setAttribute("name", "praca");
        for (var i = 0; i < array.length; i++) {
            var option = document.createElement("option");
            option.value = array[i];
            option.text = array[i];
            selectList.appendChild(option);
        }

    }

}

