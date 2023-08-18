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

    elif opcion == 3:
        idu = int(input("Ingrese id de usuario: "))
        un = input("Nombre: ")
        pw = input("Contraseña: ")

        usuario = Usuario(id_usuario=idu, username=un, pw=pw)
        usu_actualizado = UsuarioDAO.actualizar(usuario)
        log.info(f"Usuario actualizado: {usu_actualizado}")

    elif opcion == 4:
        idu = int(input("Ingrese id de usuario: "))

        usuario = Usuario(id_usuario=idu)
        usu_eliminado = UsuarioDAO.eliminar(usuario)
        log.info(f"Usuario eliminado: {usu_eliminado}")

else:
    log.info("Saliendo del programa")