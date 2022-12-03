Datos del alumno:
    - Nombre: Rodrigo Ignacio Flores Figueroa
    - ROL USM: 202173523-2

Ejecucion:
    - Desde una terminal ejecutar swipl
    - Cargar el archivo con consult('main.pl') desde el mismo nivel de directorio que main.pl

Funcionamiento:
    - Problema 1: Funciona correctamente. Aunque,
    el orden de entrega de los datos es un poco diferente a los ejemplos del enunciado.

    - Problema 2: Funciona para consultas de la forma todosrango([1, 5, 3, 2, 4, 6], 3, 7),
    pero no para consultas de la forma todosrango([1, 5, 3, 2, 4, 6], X, Y).

    - Problema 3: Funciona para las consultas de la forma rangomax([1, 5, 3, 2, 4, 6] , X, Y),
    pero no para consultas de la forma rangomax([1, 5, 3, 2, 4, 6], 1, 7).

    - Problema 4: No se programó.

Detalles tecnicos:
    - swi-prolog version: SWI-Prolog version 9.0.0 for x86_64-linux
    - OS: Ubuntu 22.04.1 LTS