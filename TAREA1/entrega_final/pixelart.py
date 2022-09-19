import re
from turtle import end_fill
import numpy as np
from PIL import Image


class Draw:
    def __init__(self, ancho, fondo=(0, 0, 0)) -> None:
        '''
        Inicializa el cursor en la posicion (0, 0) y la orientacion hacia la derecha.
            Parametros:
                    ancho (int): Ancho de la imagen.
                    fondo (tupla de enteros): Color de fondo de la imagen.
            Retorno:
                    None
        '''
        self.posicion = {
            "row": 0,
            "col": 0
        }
        self.orientacion_actual = 2
        # [izquierda, derecha, abajo, arriba]
        self.coordenadas_orientacion = {
            1: -1,
            2: 1,
            3: 1,
            0: -1
        }
        self.colores = {
            "Negro": (0, 0, 0),
            "Rojo": (255, 0, 0),
            "Verde": (0, 255, 0),
            "Azul": (0, 0, 255),
            "Blanco": (255, 255, 255),
        }
        if type(fondo) is str:
            fondo = self.colores[fondo]
        self.data = []
        for i in range(ancho):
            self.data.append([fondo for j in range(ancho)])
        self.data = np.array(self.data, dtype=np.uint8)
        self.size = len(self.data)

    def pintar(self, color=(0, 0, 0)) -> None:
        '''
        Pinta un pixel en la posicion (x, y) con el color dado.
            Parametros:
                    x (int): Posicion x del pixel.
                    y (int): Posicion y del pixel.
                    color (tupla de enteros): Color del pixel.
            Retorno:
                    None
        '''
        if type(color) is str:
            color = self.colores[color]
        self.data[self.posicion["row"]][self.posicion["col"]] = color

    def derecha(self) -> None:
        '''
        Cambia la orientacion a la derecha.
        Parametros:
                None
        Retorno:
                None
        '''
        self.orientacion_actual = (self.orientacion_actual + 1) % 4

    def izquierda(self) -> None:
        '''
        Cambia la orientacion a la izquierda.
        Parametros:
                None
        Retorno:
                None
        '''
        self.orientacion_actual = (self.orientacion_actual - 1) % 4

    def avanzar(self, distancia=1) -> None:
        '''
        Avanza una distancia en la direccion actual.
            Parametros:
                    distancia (int): Distancia a avanzar.
            Retorno:
                    None
        '''
        if self.orientacion_actual == 1 or self.orientacion_actual == 2:
            if self.posicion["col"] > self.size - 1 or self.posicion["col"] < 0:
                assert "Cursor fuera de limite."
            else:
                self.posicion["col"] += (distancia *
                                         self.coordenadas_orientacion[self.orientacion_actual])

        elif self.orientacion_actual == 0 or self.orientacion_actual == 3:
            if self.posicion["row"] > self.size - 1 or self.posicion["row"] < 0:
                assert "Cursor fuera de limite."
            else:
                self.posicion["row"] += (distancia *
                                         self.coordenadas_orientacion[self.orientacion_actual])

    def exportar_imagen(self, filename='assets/pixelart.png', factor=100) -> str:
        '''
        Convierte una matriz de valores RGB en una imagen y la guarda como un archivo png.
        Las imagenes son escaladas por un factor ya que con los ejemplos se producirian imagenes muy pequeñas.
            Parametros:
                    matriz (lista de lista de tuplas de enteros): Matriz que representa la imagen en rgb.
                    filename (str): Nombre del archivo en que se guardara la imagen.
                    factor (int): Factor por el cual se escala el tamaño de las imagenes.
            Retorno:
                    str: Nombre del archivo en que se guardo la imagen.
        '''
        np.swapaxes(self.data, 0, -1)
        img = Image.fromarray(self.data, 'RGB')
        img = img.resize((self.size * factor, self.size * factor),
                         Image.Resampling.BOX)
        img.save(filename)
        return "Imagen guardada en: " + filename


def check_for_errors(text: str, expresiones: dict) -> bool:
    '''
    Verifica que la linea no tenga errores de sintaxis.
        Parametros:
                line (str): Linea a verificar.
                expresiones (dict): Diccionario con las expresiones regulares.
        Retorno:
                bool: False si no hay errores, True si hay errores.
    '''
    i = 4
    for line in text:
        # print(line)
        line = line.strip()
        f1 = re.match(expresiones["repetir_no_anidado"], line)
        f2 = re.match(expresiones["repetir_anidado"], line)
        f3 = re.match(expresiones["instrucciones_basicas"], line)
        f4 = re.match(expresiones["colorear"], line)
        if line == "" or line == "}":
            continue
        if not (f1 or f2 or f3 or f4):
            print("Error en la linea " + str(i) + ": " + line)
            with open("errores.txt", "w") as file:
                file.write('{} {}\n'.format(i, line))
            return True
        i += 1
    with open("errores.txt", "w") as file:
        file.write("No hay errores!")
    return False


nombre_archivo = "texto.txt"
with open(nombre_archivo, 'r') as file:
    text = file.read()

expresiones = {
    'repetir_no_anidado': r'Repetir\s\d+\sveces\s{\s.*\s}',
    'repetir_anidado': r'\bRepetir\b\s\d+\s\bveces\b\s\{',
    'instrucciones_basicas': r'(\bIzquierda\b|\bDerecha\b|\bAvanzar\b( \d+)?|\bPintar\b)',
    'colorear': r'Pintar (\bRojo\b|\bVerde\b|\bAzul\b|\bNegro\b|\bBlanco\b|RGB(\d{1,3},\d{1,3},\d{1,3}\)))',
    't1': r'(Izquierda|Derecha|Avanzar( \d+)?|Pintar (Rojo|Verde|Azul|Negro|Blanco|RGB\(\d{1,3},\d{1,3},\d{1,3}\))|Repetir\s\d+\sveces\s\{.*\})',
}

regex = re.compile(expresiones['instrucciones_basicas'])
separated_by_lines = re.split(r'\n', text)
check_for_errors(separated_by_lines[3:], expresiones)
text = re.sub(r'\n', ' ', text).replace('  ', ' ').replace('  ', ' ').replace('  ', ' ')

texto_separado = re.split(r'\s', text)

dibujo = Draw(ancho=int(texto_separado[1]), fondo=texto_separado[5])

i = 0

while i < len(texto_separado):
    print(texto_separado[i])
    if texto_separado[i] == 'Izquierda':
        dibujo.izquierda()
    elif texto_separado[i] == 'Derecha':
        dibujo.derecha()
    elif texto_separado[i] == 'Avanzar':
        try:
            if texto_separado[i] == 'Avanzar' and texto_separado[i + 1].isdigit():
                dibujo.avanzar(distancia=int(texto_separado[i + 1]))
            else:
                dibujo.avanzar()
        except IndexError:
            dibujo.avanzar()
    elif texto_separado[i] == 'Pintar':
        dibujo.pintar(color=texto_separado[i + 1])
    i += 1

dibujo.exportar_imagen(filename="pixelart.png", factor=250)
