Datos personales:
    Nombre: Rodrigo Ignacio Flores Figueroa
    RUT: 21070159-1
    ROL: 202173523-2

Detalles compilacion:
    Compilador: gcc (Ubuntu 11.2.0-19ubuntu1) 11.2.0
    Comandos makefile:
        make: para correr el programa
        make clean: para limpiar el ejecutable
    Intruccion basica: gcc main.c certamen.c
    Ambiente de desarrollo: Ubuntu Linux 22.04.1 LTS

Uso del programa:
    Comandos a ejecutar (linux):
        make
        ./programa

Observaciones:
    No se lograron cumplir todos los requerimientos.

    Actualmente, el programa permite guardar completamente el certamen del archivo de texto sin problemas.

    Al momento de mostrar en pantalla las preguntas, al acceder a la primera posicion del arreglo de preguntas, este imprime un valor basura.
    Se hizo el intento de comenzar a guardar desde la segunda (1) posicion del arreglo, pero el resultado es el mismo.

    Se aniadieron parametro extra a las funciones revisar, pues no se veia lograble sin hacerlo.

    Se modificaron las estructuras de tPregunta y la funcion CrearPregunta para recibir solo una funcion con un puntero de void.

    No es posible revisar correctamente el certamen por dos razones:
        mal calculo al contar las respuestas correctas e incorrectas.
        no se puede responder a las preguntas de tipo Completar, por lo que el resultado no es transparente.
