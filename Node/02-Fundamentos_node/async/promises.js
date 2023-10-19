function hola(nom) {
    return new Promise(function (resolve, reject) {
        setTimeout( function() {
            console.log("Hola " + nom);
            resolve(nom);
        }, 1000);
    })
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

console.log("iniciando proceso");
hola("Ariel")
    .then((nombre) => {
        console.log("Terminando proceso");
    })
