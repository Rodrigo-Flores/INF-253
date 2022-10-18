#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

typedef struct
{
    char enunciado[128];
    int n_alternativas;
    char **alternativas;
    int alternativa_correcta;
} tEnunciadoAlternativa;

typedef struct
{
    char enunciado[128];
    int n_alternativas;
    char **alternativas;
    int n_correctas;
    int *alternativa_correcta;
} tEnunciadoAlternativaMultiple;

typedef struct
{
    char enunciado[128];
    bool respuesta;
} tEnunciadoVerdaderoFalso;

typedef struct
{
    int n_textos;
    char **textos;
    char **respuestas;
} tEnunciadoCompletar;

typedef struct
{
    char tipo[64];
    void *enunciado;
    void *respuesta;
    bool (*revisar)(void *);
} tPregunta;

typedef struct
{
    int n_preguntas;
    tPregunta *preguntas;
} tCertamen;

typedef struct {
    int correctas;
    int incorrectas;
} tRespuesta;

// FUNCIONES

/*
Crea un nuevo certamen vacio

    Parametros:
        n_preguntas (int): Numero de preguntas del certamen
    
    Retorno:
        certamen (tCertamen *): Certamen creado
*/
tCertamen *crearCertamen(int n_preguntas);

/*
Crea una pregunta con el enunciado y funcion de revision dados

    Parametros:
        enunciado (char *): Enunciado de la pregunta
        revisar (bool (*)(void *)): Funcion de revision de la pregunta

    Retorno:
        pregunta (tPregunta *): Pregunta creada
*/
tPregunta *crearPregunta(
    tCertamen *certamen,
    char *tipo,
    void *enunciado,
    bool (*revisar)(void *));

/*
Asigna la pregunta a la posicion n_pregunta del certamen

    Parametros:
        certamen (tCertamen *): Certamen al que se le asignara la pregunta
        n_pregunta (int): Posicion de la pregunta en el certamen
        pregunta (tPregunta *): Pregunta a asignar

    Retorno:
        void
*/
void asignarPregunta(
    tCertamen *certamen,
    int n_pregunta,
    tPregunta *pregunta);

/*
Retorna la pregunta en el posicion n_pregunta del certamen

    Parametros:
        certamen (tCertamen *): Certamen del que se obtendra la pregunta
        n_pregunta (int): Posicion de la pregunta en el certamen

    Retorno:
        pregunta (tPregunta): Pregunta en la posicion n_pregunta del certamen
*/
tPregunta leerPregunta(tCertamen *certamen, int n_pregunta);

// retorna el numero de respuestas correctas que tiene un certamen
int nCorrectasCertamen(tCertamen certamen);

/*
Retorna el numero de preguntas de un certamen

    Parametros:
        certamen (tCertamen): Certamen del que se obtendra el largo
        
    Retorno:
        largo (int): Numero de preguntas del certamen
*/
int largoCertamen(tCertamen certamen);

/*
Revisa si la respuesta a la pregunta es correcta

    Parametros:
        pregunta (tPregunta): Pregunta a revisar
        respuesta (unsigned int *): Respuesta a la pregunta

    Retorno:
        correcta (bool): Verdadero si la respuesta es correcta, falso en caso contrario
*/
bool revisarAlternativaSimple(tPregunta pregunta, unsigned int respuesta);

/*
Revisa si la respuesta a la pregunta es correcta

    Parametros:
        pregunta (tPregunta): Pregunta a revisar
        respuestas (unsigned int *): Array de respuestas a la pregunta

    Retorno:
        correcta (bool): Verdadero si la respuesta es correcta, falso en caso contrario
*/
bool revisarAlternativaMultiple(tPregunta pregunta, unsigned int *respuestas);

/*
Revisa si la respuesta a la pregunta es correcta

    Parametros:
        pregunta (tPregunta): Pregunta a revisar
        respuesta (bool): Respuesta a la pregunta

    Retorno:
        correcta (bool): Verdadero si la respuesta es correcta, falso en caso contrario
*/
bool revisarVerdaderoFalso(tPregunta pregunta,  bool respuesta);

/*
Revisa si la respuesta a la pregunta es correcta

    Parametros:
        pregunta (tPregunta): Pregunta a revisar
        respuesta (char **): Array de respuestas a la pregunta

    Retorno:
        correcta (bool): Verdadero si la respuesta es correcta, falso en caso contrario
*/
bool revisarCompletar(tPregunta pregunta, char **respuestas);
