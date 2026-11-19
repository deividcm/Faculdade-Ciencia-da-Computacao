$(document).ready( function () {
    const LIMITE_CARACTERES = 300;

    function exibirErro(idCampo, idErro, mensagem) {
        $(idCampo).addClass("input-invalido");
        $(idErro).text(mensagem).fadeIn(150);
    }

    $(".caixa-interativa").on("input change", function () {
        $(this).removeClass("input-invalido");
        $(this).siblings(".mensagem-erro").hide().text("");
    });

    $("#descricao").on("input", function () {
        const totalDigitado = $(this).val().length;
        const restantes = LIMITE_CARACTERES - totalDigitado;

        $("#contador-caracteres").text(`${restantes} caracteres restantes`);

        if (restantes <= 30) {
            $("#contador-caracteres").addClass("alerta-limite");
        } else {
            $("#contador-caracteres").removeClass("alerta-limite");
        }
    });
    $("#tipo-problema").on("change", function () {
        const categoria = $(this).val();

        $(".campo-dinamico").slideUp(200, function () {
            $(this).find("input, select").val("").removeClass("input-invalido");
            $(this).find(".mensagem-erro").hide().text("");
        });

        if (categoria === "hardware") {
            $("#campo-hardware").stop(true, true).css("display", "flex").hide().slideDown(250);
        } else if (categoria === "software") {
            $("#campo-software").stop(true, true).css("display", "flex").hide().slideDown(250);
        } else if (categoria === "rede") {
            $("#campo-rede").stop(true, true).css("display", "flex").hide().slideDown(250);
        }
    });


    $("#telefone").on("input", function () {
        let valor = $(this).val().replace(/\D/g, "");
        if (valor.length > 11) valor = valor.slice(0, 11);

        if (valor.length > 7) {
            valor = valor.replace(/^(\d{2})(\d{1})(\d{4})(\d{0,4}).*/, "($1) $2 $3-$4");
        } else if (valor.length > 2) {
            valor = valor.replace(/^(\d{2})(\d{0,5})/, "($1) $2");
        } else if (valor.length > 0) {
            valor = valor.replace(/^(\d*)/, "($1");
        }
        $(this).val(valor);
    });


    $("#form-chamado").on("submit", function (event) {
        event.preventDefault();
        let valido = true;

        $(".mensagem-erro").hide().text("");
        $(".caixa-interativa").removeClass("input-invalido");

        const nome = $("#nome").val().trim();
        const email = $("#email").val().trim();
        const telefone = $("#telefone").val().replace(/\D/g, "");
        const tipoProblema = $("#tipo-problema").val();
        const numeroSerie = $("#numero-serie").val().trim();
        const descricao = $("#descricao").val().trim();

        if (nome.length < 3) {
            exibirErro("#nome", "#erro-nome", "Informe seu nome completo (mínimo 3 caracteres).");
            valido = false;
        }

        const regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!regexEmail.test(email)) {
            exibirErro("#email", "#erro-email", "Informe um endereço de e-mail válido.");
            valido = false;
        }

        if (telefone.length < 10) {
            exibirErro("#telefone", "#erro-telefone", "Informe um telefone válido com DDD.");
            valido = false;
        }

        if (tipoProblema === "") {
            exibirErro("#tipo-problema", "#erro-tipo", "Selecione a categoria do problema.");
            valido = false;
        }

        if (tipoProblema === "hardware" && numeroSerie === "") {
            exibirErro("#numero-serie", "#erro-serie", "Informe o número de série do equipamento.");
            valido = false;
        }

        if (descricao.length < 15) {
            exibirErro("#descricao", "#erro-descricao", "Descreva o problema com pelo menos 15 caracteres.");
            valido = false;
        }

        if (valido) {
            alert("Chamado aberto com sucesso! Nossa equipe entrará em contato.");
            this.reset();
            $("#campo-hardware").hide();
            $("#contador-caracteres")
                .removeClass("alerta-limite")
                .text(`${LIMITE_CARACTERES} caracteres restantes`);
        }
        if (tipoProblema === "hardware" && $("#numero-serie").val().trim() === "") {
        exibirErro("#numero-serie", "#erro-serie", "Informe o número de série do equipamento.");
        valido = false;
        } else if (tipoProblema === "software" && $("#sistema-operacional").val().trim() === "") {
            exibirErro("#sistema-operacional", "#erro-software", "Informe o sistema ou programa afetado.");
            valido = false;
        } else if (tipoProblema === "rede" && $("#tipo-conexao").val() === "") {
            exibirErro("#tipo-conexao", "#erro-rede", "Selecione o tipo de conexão utilizado.");
            valido = false;
        }
    });
});
