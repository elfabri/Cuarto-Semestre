function hola(nom, miCallback) {
    setTimeout( function() {
        console.log("Hola " + nom);
        miCallback();
    }, 1000);
}

function adios(nom, otroCallback) {
    setTimeout( function() {
        console.log("Adios", nom);
        otroCallback();
    })
}

console.log("Iniciando el programa");

hola("carlos", function() {

    adios("carlos", function() {
        console.log("Finalizando el programa");
    });
});
