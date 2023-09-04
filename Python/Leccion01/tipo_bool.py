# True or False
# 0 -> False

valor = 0.0
resultado = bool(valor)
print(f"valor: {valor}, resultado: {resultado}")

valor = 0.1
resultado = bool(valor)
print(f"valor: {valor}, resultado: {resultado}")

"""
def uwu(val):
    resul = bool(val)
    print(f"valor: {val}, resultado: {resul}")

uwu(0)
uwu(15)
uwu(-1)
uwu((0,0))
uwu(0.0)
"""

# Str "" -> False
valor = ""
resultado = bool(valor)
print(f"valor: {valor}, resultado: {resultado}")

valor = "hola"
resultado = bool(valor)
print(f"valor: {valor}, resultado: {resultado}")

# tipo colecciones, False para colecciones vacias
# Listas
valor = []
resultado = bool(valor)
print(f"valor de una lista vacia: {valor}, resultado: {resultado}")

valor = [2, 3, 4]
resultado = bool(valor)
print(f"valor de una lista con elementos: {valor}, resultado: {resultado}")

# Tuplas
valor = ()
resultado = bool(valor)
print(f"valor de una tupla vacia: {valor}, resultado: {resultado}")

valor = (2, 3, 4,)
resultado = bool(valor)
print(f"valor de una tupla con elementos: {valor}, resultado: {resultado}")

# Diccionarios
valor = {}
resultado = bool(valor)
print(f"valor de un diccionario vacio: {valor}, resultado: {resultado}")

valor = {"Nombre": "Juana", "Apellido": "Juana"}
resultado = bool(valor)
print(f"valor de un diccionario con elementos: {valor}, resultado: {resultado}")
