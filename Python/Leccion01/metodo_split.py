# help(str.split)

cursos = "Java JavaScript Node Python"

lista_cursos = cursos.split()

print(f"Lista de cursos: {lista_cursos}")
print(type(lista_cursos))

c_sep_coma = "Java,Python,Node,JavaScript,Spring"
l_c = c_sep_coma.split(',', 2)
print(f"Lista de cursos: {l_c}")
print(len(l_c))
