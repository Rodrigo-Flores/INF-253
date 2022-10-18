#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "certamen.h"

/*
Crea un nuevo certamen vacio

    Parametros:
        n_preguntas (int): Numero de preguntas del certamen
    
    Retorno:
        certamen (tCertamen *): Certamen creado
*/
tCertamen *crearCertamen(int n_preguntas)
{
    tCertamen *certamen = malloc(sizeof(tCertamen));
    certamen->n_preguntas = n_preguntas;
    certamen->preguntas = (tPregunta *)malloc(sizeof(tPregunta) * (n_preguntas));

    return certamen;
}

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
    bool revisar(void *))
{
    tPregunta *pregunta = (tPregunta *)malloc(sizeof(tPregunta));
    strcpy(pregunta->tipo, tipo);
    pregunta->enunciado = enunciado;
    pregunta->revisar = revisar;

    return pregunta;
}
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
    tPregunta *pregunta)
{
    certamen->preguntas[n_pregunta] = *pregunta;
}
/*
Retorna la pregunta en el posicion n_pregunta del certamen

    Parametros:
        certamen (tCertamen *): Certamen del que se obtendra la pregunta
        n_pregunta (int): Posicion de la pregunta en el certamen

    Retorno:
        pregunta (tPregunta): Pregunta en la posicion n_pregunta del certamen
*/
tPregunta leerPregunta(tCertamen *certamen, int n_pregunta)
{
    return certamen->preguntas[n_pregunta];
}

// retorna el numero de respuestas correctas que tiene un certamen
int nCorrectasCertamen(tCertamen certamen) {
    
}

/*
Retorna el numero de preguntas de un certamen

    Parametros:
        certamen (tCertamen): Certamen del que se obtendra el largo
        
    Retorno:
        largo (int): Numero de preguntas del certamen
*/
int largoCertamen(tCertamen certamen)
{
    return certamen.n_preguntas;
}

/*
Revisa si la respuesta a la pregunta es correcta

    Parametros:
        pregunta (tPregunta): Pregunta a revisar
        respuesta (unsigned int *): Respuesta a la pregunta

    Retorno:
        correcta (bool): Verdadero si la respuesta es correcta, falso en caso contrario
*/
bool revisarAlternativaSimple(tPregunta pregunta, unsigned int respuesta) {
    return ((tEnunciadoAlternativa *)pregunta.enunciado)->alternativa_correcta == respuesta;
}

/*
Revisa si la respuesta a la pregunta es correcta

    Parametros:
        pregunta (tPregunta): Pregunta a revisar
        respuestas (unsigned int *): Array de respuestas a la pregunta

    Retorno:
        correcta (bool): Verdadero si la respuesta es correcta, falso en caso contrario
*/
bool revisarAlternativaMultiple(tPregunta pregunta, unsigned int *respuestas){ 
    tEnunciadoAlternativaMultiple *enunciado = (tEnunciadoAlternativaMultiple *)pregunta.enunciado;
    int n_correctas = 0;
    for (int i = 0; i < enunciado->n_alternativas; i++) {
        if (enunciado->alternativa_correcta[i] == respuestas[i]) {
            n_correctas++;
        }
    }
    return n_correctas == enunciado->n_correctas;
}

/*
Revisa si la respuesta a la pregunta es correcta

    Parametros:
        pregunta (tPregunta): Pregunta a revisar
        respuesta (bool): Respuesta a la pregunta

    Retorno:
        correcta (bool): Verdadero si la respuesta es correcta, falso en caso contrario
*/
bool revisarVerdaderoFalso(tPregunta pregunta, bool respuesta) {
    return ((tEnunciadoVerdaderoFalso *)pregunta.enunciado)->respuesta == respuesta;
}

/*
Revisa si la respuesta a la pregunta es correcta

    Parametros:
        pregunta (tPregunta): Pregunta a revisar
        respuesta (char **): Array de respuestas a la pregunta

    Retorno:
        correcta (bool): Verdadero si la respuesta es correcta, falso en caso contrario
*/
bool revisarCompletar(tPregunta pregunta, char **respuesta) {
    tEnunciadoCompletar *enunciado = (tEnunciadoCompletar *)pregunta.enunciado;
    int n_correctas = 0;
    for (int i = 0; i < enunciado->n_textos; i++) {
        if (strcmp(enunciado->respuestas[i], respuesta[i]) == 0) {
            n_correctas++;
        }
    }
    return n_correctas == enunciado->n_textos;
}
