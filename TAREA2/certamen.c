#include "certamen.h"
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// crea un nuevo certamen vacio
tCertamen *crearCertamen(int n_preguntas)
{
    tCertamen *certamen;
    certamen->n_preguntas = n_preguntas;
    certamen->preguntas = (tPregunta *)malloc(sizeof(tPregunta) * n_preguntas);

    return certamen;
}

// crea una pregunta con el enunciado y funcion de revision dados
tPregunta *crearPregunta(
    tCertamen *certamen,
    char *tipo,
    void *enunciado,
    bool (*revisar)(void*))
{
    tPregunta *pregunta = (tPregunta *)malloc(sizeof(tPregunta));
    strcpy(pregunta->tipo, tipo);
    pregunta->enunciado = enunciado;
    pregunta->revisar = revisar;

    return pregunta;
}

// asigna la pregunta a la posicion n_pregunta del certamen
void asignarPregunta(
    tCertamen *certamen,
    int n_pregunta,
    tPregunta *pregunta)
{
    certamen->preguntas[n_pregunta] = *pregunta;
}

// retorna la pregunta en la posicion n_pregunta del certamen
tPregunta leerPregunta(tCertamen *certamen, int n_pregunta)
{
    // check data type
    if (sizeof(certamen->preguntas[n_pregunta].enunciado) == sizeof(tEnunciadoAlternativa))
    {
        printf("tEnunciadoAlternativa");
    }
    else if (sizeof(certamen->preguntas[n_pregunta].enunciado) == sizeof(tEnunciadoAlternativaMultiple))
    {
        printf("tEnunciadoAlternativaMultiple");
    }
    else if (sizeof(certamen->preguntas[n_pregunta].enunciado) == sizeof(tEnunciadoVerdaderoFalso))
    {
        printf("tEnunciadoVerdaderoFalso");
    }
    else if (sizeof(certamen->preguntas[n_pregunta].enunciado) == sizeof(tEnunciadoCompletar))
    {
        printf("tEnunciadoCompletar");
    }
    return certamen->preguntas[n_pregunta];
}

// retorna el numero de respuestas correctas que tiene un certamen
int nCorrectasCertamen(tCertamen certamen);

// retorna el numero de preguntas de un certamen
int largoCertamen(tCertamen certamen)
{
    return certamen.n_preguntas;
}

// revisa si la respuesta a la pregunta es correcta
bool revisarAlternativaSimple(tPregunta pregunta);
bool revisarAlternativaMultiple(tPregunta pregunta);
bool revisarVerdaderoFalso(tPregunta pregunta);
bool revisarCompletar(tPregunta pregunta);

void numero(int n) {
    printf("%d", n);
}