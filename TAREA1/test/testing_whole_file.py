from curses.ascii import isupper
import re
from Draw import Draw


def detect_error(text):
    print(text)

with open('text3.txt', 'r') as file:
    text = file.read()

# (Rojo|Verde|Azul|Negro|Blanco|RGB\(\d{1,3},\d{1,3},\d{1,3}\)))

expresiones = {
    'repetir_no_anidado': r'Repetir\s\d+\sveces\s{\s.*\s}',
    'repetir_anidado': r'Repetir\s\d+\sveces\s\{\n',
    'instrucciones_basicas': r'(Izquierda|Derecha|Avanzar( \d+)?|Pintar \w+)',
    't1': r'(Izquierda|Derecha|Avanzar( \d+)?|Pintar (Rojo|Verde|Azul|Negro|Blanco|RGB\(\d{1,3},\d{1,3},\d{1,3}\))|Repetir\s\d+\sveces\s\{.*\})',
    'movimientos': r'(Izquierda|Derecha|Avanzar( \d+)?)',
    'colorear': r'Pintar (Rojo|Verde|Azul|Negro|Blanco|RGB\(\d{1,3},\d{1,3},\d{1,3}\))',
    'numero': r'[0-9]+',
    'colores': r'(Rojo|Verde|Azul|Negro|Blanco)',
    'separar_comandos': r'\n',
    'limpiar_comandos': r'(\W)',
}

regex = re.compile(expresiones['movimientos'])
separated_by_lines = re.split(r'\n', text)
detect_error(separated_by_lines[3:])
text = text.replace('\n', ' ').replace('  ', ' ').replace('  ', ' ').replace('  ', ' ')
# print(regex.findall(text))
# print(text)

texto_separado = re.split(r'\s', text)
# print(texto_separado)

dibujo = Draw(ancho=int(texto_separado[1]), fondo=texto_separado[5])

i = 0

while i < len(texto_separado):
    if texto_separado[i] == 'Izquierda':
        dibujo.izquierda()
    elif texto_separado[i] == 'Derecha':
        dibujo.derecha()
    elif texto_separado[i] == 'Avanzar':
        if texto_separado[i] == 'Avanzar' and texto_separado[i + 1].isdigit():
            dibujo.avanzar(distancia=int(texto_separado[i + 1]))
        else:
            dibujo.avanzar()
    elif texto_separado[i] == 'Pintar':
        dibujo.pintar(color=texto_separado[i + 1])
    elif texto_separado[i] == 'Repetir':
        i += 1
        t = i
        for j in range(int(texto_separado[i])):
            flag = True
            while flag:
                if texto_separado[i] == 'Izquierda':
                    dibujo.izquierda()
                elif texto_separado[i] == 'Derecha':
                    dibujo.derecha()
                elif texto_separado[i] == 'Avanzar':
                    if texto_separado[i] == 'Avanzar' and texto_separado[i + 1].isdigit():
                        dibujo.avanzar(distancia=int(texto_separado[i + 1]))
                    else:
                        dibujo.avanzar()
                elif texto_separado[i] == 'Pintar':
                    dibujo.pintar(color=texto_separado[i + 1])
                elif texto_separado[i] == '}':
                    break
                i += 1
                if i == len(texto_separado):
                    i = t
                    break
    i += 1

dibujo.exportar_imagen(filename="../assets/pixelart.png", factor=250)
