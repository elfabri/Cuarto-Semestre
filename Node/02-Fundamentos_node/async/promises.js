function hola(nom, miCallback) {
    setTimeout( function() {
        console.log("Hola " + nom);
        miCallback(nom);
    }, 1000);
}

function hablar(callbackHablar) {
    setTimeout( function () {
        console.log("bla bla bla");
        callbackHablar();
    }, 1000);
}

function adios(nom, otroCallback) {
    setTimeout( function() {
        console.log("Adios " + nom);
        otroCallback();
    }, 1500);
}
