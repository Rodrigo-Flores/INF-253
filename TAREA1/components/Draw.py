import numpy as np
from PIL import Image


class Draw:
    def __init__(self, ancho, fondo=(0, 0, 0)) -> None:
        self.posicion = {
            "x": 0,
            "y": 0
        }
        self.orientacion_actual = 1
        # [izquierda, arriba, derecha, abajo]
        self.coordenadas_orientacion = [-1, -1, 1, 1]
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
        self.width = len(self.data[0])
        self.height = len(self.data)

    def pintar(self, color=(0, 0, 0)) -> None:
        '''
        Pinta un pixel en la posicion (x, y) con el color dado.
            Parametros:
                    x (int): Posicion x del pixel.
                    y (int): Posicion y del pixel.
                    color (tupla de enteros): Color del pixel.
        '''
        if type(color) is str:
            color = self.colores[color]
        self.data[self.posicion["x"]][self.posicion["y"]] = color

    def derecha(self) -> None:
        '''
        Cambia la orientacion a la derecha.
        '''
        self.orientacion_actual = (self.orientacion_actual + 1) % 4

    def izquierda(self) -> None:
        '''
        Cambia la orientacion a la izquierda.
        '''
        self.orientacion_actual = (self.orientacion_actual - 1) % 4

    def avanzar(self, distancia=1) -> None:
        '''
        Avanza una distancia en la direccion actual.
            Parametros:
                    distancia (int): Distancia a avanzar.
        '''
        if self.orientacion_actual == 0:
            self.posicion["y"] -= (distancia *
                                   self.coordenadas_orientacion[self.orientacion_actual])
        elif self.orientacion_actual == 1:
            self.posicion["x"] -= (distancia *
                                   self.coordenadas_orientacion[self.orientacion_actual])
        elif self.orientacion_actual == 2:
            self.posicion["y"] += (distancia *
                                   self.coordenadas_orientacion[self.orientacion_actual])
        elif self.orientacion_actual == 3:
            self.posicion["x"] += (distancia *
                                   self.coordenadas_orientacion[self.orientacion_actual])

    def exportar_imagen(self, filename='assets/pixelart.png', factor=100) -> str:
        '''
        Convierte una matriz de valores RGB en una imagen y la guarda como un archivo png.
        Las imagenes son escaladas por un factor ya que con los ejemplos se producirian imagenes muy pequeñas.
            Parametros:
                    matriz (lista de lista de tuplas de enteros): Matriz que representa la imagen en rgb.
                    filename (str): Nombre del archivo en que se guardara la imagen.
                    factor (int): Factor por el cual se escala el tamaño de las imagenes.
        '''
        np.swapaxes(self.data, 0, -1)
        img = Image.fromarray(self.data, 'RGB')
        img = img.resize((self.height * factor, self.width * factor),
                         Image.Resampling.BOX)
        img.save(filename)
        return "Imagen guardada en: " + filename

if __name__ == "__main__":
    draw = Draw(3, "Verde")
    print(draw.exportar_imagen())
