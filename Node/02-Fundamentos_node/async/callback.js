function soyAsincrona() {
    setTimeout( function (miCallback) {
        console.log("Hola, soy una funcion asincrona");
    }, 1000);
}

console.log("Iniciando el programa");
soyAsincrona(function() {
    console.log("Finalizando el programa");
});
