# help(str.join)

tupla_str = ("Hola", "soy", "yo", "xd")
mensaje = ' '.join(tupla_str)

print(f"Mensaje: {mensaje}")

lista_cursos = ["Java", "Python", "Angular", "Spring"]
mensaje = ", ".join(lista_cursos)

print(f"Mensaje: {mensaje}")

cadena = "HolaMundo"
msg = '.'.join(cadena)

print(f"Mensaje: {msg}")

diccionario = {"nombre": "Juan", "apellido": "Perez", "edad": "18"}
llaves = '-'.join(diccionario.keys())
valores = '-'.join(diccionario.values())

print(f"Llaves: {llaves}, Type: {type(llaves)}")
print(f"Valores: {valores}, Type: {type(valores)}")
