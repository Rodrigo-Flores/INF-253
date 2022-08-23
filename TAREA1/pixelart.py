import re
from components.Draw import Draw

expresiones = {
    'comando_simple': r'[A-Z][a-z]+',
    'comando_color': r'(Rojo|Verde|Azul|Negro|Blanco)',
    'comando_con_numero': r'[A-Z][a-z]+\s\d+',
    'separar_comandos': r'\n',
    'limpiar_comandos': r'(\W)',
    'extra': r'[A-Z][a-z]+(\s\d+\s[a-z]+|\s[a-z]+\s[a-z]+|\s\d+)?',
    'rgb': r'RGB\(\d{1,3}, \d{1,3}, \d{1,3}\)',
}

with open("test-regex.txt", "r") as file:
    t = file.read()
    comandos = re.split(expresiones['separar_comandos'], t)
    comandos_limpios = []
    for i in comandos:
        comandos_limpios.append([x for x in re.split(expresiones['limpiar_comandos'], i) if x not in ["", " "]])

cabeza_comandos_limpios = comandos_limpios[0:2]
cuerpo_comandos_limpios = comandos_limpios[3:]

dibujo = Draw(ancho=int(cabeza_comandos_limpios[0][1]), fondo=cabeza_comandos_limpios[1][3])
dibujo.exportar_imagen(factor=500)
