from usuario_dao import UsuarioDAO
from Usuario import Usuario
from logger_base import log

opcion = None
while opcion != 5:
    print("Opciones: ")
    print("1. Listar")
    print("2. Agregar")
    print("3. Modificar")
    print("4. Eliminar")
    print("5. Salir")
    opcion = int(input("Ingrese una opción (1-5): "))

    if opcion == 1:
        usuarios = UsuarioDAO.seleccionar()
        for u in usuarios:
            log.info(u)

    elif opcion == 2:
        un = input(f"Ingrese nombre de usuario: ")
        pw = input(f"Ingrese contraseña: ")
        usuario = Usuario(username=un, pw=pw)
        usu_insertado = UsuarioDAO.insertar(usuario)
        log.info(f"Usuario insertado: {usu_insertado}")

else:
    log.info("Saliendo del programa")