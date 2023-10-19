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

function adios(nom) {
    return new Promise((res, rej) => {
        setTimeout( function() {
            console.log("Adios " + nom);
            res();
        }, 1500);
    })
}

// ejejej
console.log("iniciando proceso");
hola("Ariel")
    .then(adios)
    .then((nombre) => {
        console.log("Terminando proceso");
    })
