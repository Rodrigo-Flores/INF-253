import re
from components.Draw import Draw

# (Izquierda|Derecha|Avanzar( [1-9]+)?|Pintar (Rojo|Verde|Azul|Negro|Blanco)|Repetir [1-9]+ veces { .+ })

expresiones = {
    'numero': r'[0-9]+',
    'colores': r'(Rojo|Verde|Azul|Negro|Blanco)',
    'separar_comandos': r'\n',
    'limpiar_comandos': r'(\W)',
    'repetir_no_anidado': r'Repetir\s\d+\sveces\s\{.*\}',
    'repetir_anidado': r'Repetir\s\d+\sveces\s\{\n',
    'instrucciones_basicas': r'(Izquierda|Derecha|Avanzar( \d+)?|Pintar (Rojo|Verde|Azul|Negro|Blanco|RGB\(\d{1,3},\d{1,3},\d{1,3}\)))',
}

with open("test/test-regex.txt", "r") as file:
    comandos = file.read()
    # comandos = re.split(expresiones['separar_comandos'], t)
    comandos = comandos.replace('\n', ' ').replace('  ', ' ').replace('  ', ' ')
    print(comandos)
    comandos_limpios = []
    for i in comandos:
        comandos_limpios.append([x for x in re.split(expresiones['limpiar_comandos'], i) if x not in ["", " "]])

cabeza_comandos_limpios = comandos_limpios[0:2]
cuerpo_comandos_limpios = comandos_limpios[3:]

# print(cabeza_comandos_limpios)
# print(cuerpo_comandos_limpios)

# for i in cuerpo_comandos_limpios:
#     print(i)


# dibujo = Draw(ancho=int(cabeza_comandos_limpios[0][1]), fondo=cabeza_comandos_limpios[1][3])

# for linea_comando in cuerpo_comandos_limpios:
#     for i in range(len(linea_comando)):
#         if linea_comando[i] == 'Pintar' and re.match(expresiones['colores'], linea_comando[i + 1]):
#             dibujo.pintar(color=linea_comando[i + 1])
#         elif linea_comando[i] == 'Avanzar' and (i + 1) == len(linea_comando):
#             dibujo.avanzar()
#         elif linea_comando[i] == 'Avanzar' and re.match(expresiones['numero'], linea_comando[i + 1]):
#             dibujo.avanzar(distancia=int(linea_comando[i + 1]))
#         elif linea_comando[i] == 'Izquierda':
#             dibujo.izquierda()
#         elif linea_comando[i] == 'Derecha':
#             dibujo.derecha()

dibujo.exportar_imagen(factor=250)
