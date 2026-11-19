
$("#descricao").on("input", verificaTexto);

function verificaTexto(){
    let a = document.getElementById("descricao");
    a.ariaValueMax = 30;
    console.log(a.ariaValueText)
}