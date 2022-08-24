from cmath import exp
import re
from components.Draw import Draw

# (Izquierda|Derecha|Avanzar( [1-9]+)?|Pintar (Rojo|Verde|Azul|Negro|Blanco)|Repetir [1-9]+ veces { .+ })

expresiones = {
    'comando_simple': r'[A-Z][a-z]+',
    'comando_color': r'(Rojo|Verde|Azul|Negro|Blanco)',
    'comando_con_numero': r'[A-Z][a-z]+( \d+)',
    'numero': r'[0-9]+',
    'separar_comandos': r'\n',
    'limpiar_comandos': r'(\W)',
    'extra': r'[A-Z][a-z]+(\s\d+\s[a-z]+|\s[a-z]+\s[a-z]+|\s\d+)?',
    'rgb': r'RGB\(\d{1,3}, \d{1,3}, \d{1,3}\)',
    'colores': r'(Rojo|Verde|Azul|Negro|Blanco)',
    'instrucciones': r''

}

with open("test/text2.txt", "r") as file:
    t = file.read()
    comandos = re.split(expresiones['separar_comandos'], t)
    comandos_limpios = []
    for i in comandos:
        comandos_limpios.append([x for x in re.split(expresiones['limpiar_comandos'], i) if x not in ["", " "]])

cabeza_comandos_limpios = comandos_limpios[0:2]
cuerpo_comandos_limpios = comandos_limpios[3:]

# se crea una instancia de Draw para poder dibujar el pixelart usando los comandos de cabeza
dibujo = Draw(ancho=int(cabeza_comandos_limpios[0][1]), fondo=cabeza_comandos_limpios[1][3])

for linea_comando in cuerpo_comandos_limpios:
    for i in range(len(linea_comando)):
        if linea_comando[i] == 'Pintar' and re.match(expresiones['colores'], linea_comando[i + 1]):
            dibujo.pintar(color=linea_comando[i + 1])
        elif linea_comando[i] == 'Avanzar' and (i + 1) == len(linea_comando):
            dibujo.avanzar()
        elif linea_comando[i] == 'Avanzar' and re.match(expresiones['numero'], linea_comando[i + 1]):
            dibujo.avanzar(distancia=int(linea_comando[i + 1]))
        elif linea_comando[i] == 'Izquierda':
            dibujo.izquierda()
        elif linea_comando[i] == 'Derecha':
            dibujo.derecha()

dibujo.exportar_imagen(factor=250)
