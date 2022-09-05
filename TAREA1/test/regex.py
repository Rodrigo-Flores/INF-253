from csv import list_dialects
from posixpath import split
import re

exp = {
    'repetir_no_anidado': r'Repetir\s\d+\sveces\s\{.*\}',
    'repetir_anidado': r'Repetir\s\d+\sveces\s\{\n',
    'instrucciones_basicas': r'(Izquierda|Derecha|Avanzar( \d+)?|Pintar (Rojo|Verde|Azul|Negro|Blanco|RGB\(\d{1,3},\d{1,3},\d{1,3}\)))',
}

def repeticion_recursiva(posicion_palabra, _lista_palabras):
    if re.match(exp['repetir_anidado'], _lista_palabras[posicion_palabra + 1]):
        repeticion_recursiva(posicion_palabra + 1, _lista_palabras)
    elif re.match(exp['repetir_no_anidado'], _lista_palabras[posicion_palabra + 1]):
        return _lista_palabras[posicion_palabra + 1]


lista_palabras = []
with open("test-regex.txt", "r") as file:
    for line in file:
        lista_palabras.append(line.strip())

    lista_palabras = lista_palabras[3:]

i = 0
while i < len(lista_palabras):
    if re.match(exp['repetir_no_anidado'], lista_palabras[i]):
        print(repeticion_recursiva(i, lista_palabras))
        i += 1
    elif re.match(exp['repetir_anidado'], lista_palabras[i]):
        print(repeticion_recursiva(i, lista_palabras))
        i += 1
    else:
        print(lista_palabras[i])
        i += 1