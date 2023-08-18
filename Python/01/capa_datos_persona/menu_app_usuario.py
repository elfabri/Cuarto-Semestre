from usuario_dao import UsuarioDAO
from logger_base import log

opcion = None
while opcion != 5:
    print("Opciones: ")
    print("1. Listar")
    print("2. Actualizar")
    print("3. Modificar")
    print("4. Eliminar")
    print("5. Salir")
    opcion = int(input("Ingrese una opción (1-5): "))

    if opcion == 1:
        usuarios = UsuarioDAO.seleccionar()
        for u in usuarios:
            log.info(u)
else:
    log.info("Saliendo del programa")