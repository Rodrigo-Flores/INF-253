from curses.ascii import isupper
import re

with open('test-regex.txt', 'r') as file:
    text = file.read()

# (Rojo|Verde|Azul|Negro|Blanco|RGB\(\d{1,3},\d{1,3},\d{1,3}\)))

exp = {
    'repetir_no_anidado': r'Repetir\s\d+\sveces\s{\s.*\s}',
    'repetir_anidado': r'Repetir\s\d+\sveces\s\{\n',
    'instrucciones_basicas': r'(Izquierda|Derecha|Avanzar( \d+)?|Pintar \w+)',
    't1': r'(Izquierda|Derecha|Avanzar( \d+)?|Pintar (Rojo|Verde|Azul|Negro|Blanco|RGB\(\d{1,3},\d{1,3},\d{1,3}\))|Repetir\s\d+\sveces\s\{.*\})',
    'movimientos': r'(Izquierda|Derecha|Avanzar( \d+)?)',
    'colorear': r'Pintar (Rojo|Verde|Azul|Negro|Blanco|RGB\(\d{1,3},\d{1,3},\d{1,3}\))'
}

regex = re.compile(exp['movimientos'])
text = text.replace('\n', ' ').replace('  ', ' ').replace('  ', ' ')
# print(regex.findall(text))
# print(text)

texto_separado = re.split(r'\s', text)
conjunto_instrucciones = []
temp = 0
for i in range(len(texto_separado)):
    print(texto_separado[i])
    if texto_separado[i][0].isupper():
        conjunto_instrucciones.append(texto_separado[temp:i])
        temp = i
conjunto_instrucciones.append(texto_separado[temp:])
print(conjunto_instrucciones)
