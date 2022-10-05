#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "certamen.h"

// crea un nuevo certamen vacio
tCertamen *crearCertamen(int n_preguntas)
{
    tCertamen *certamen = malloc(sizeof(tCertamen));
    certamen->n_preguntas = n_preguntas;
    certamen->preguntas = (tPregunta *)malloc(sizeof(tPregunta) * n_preguntas);

    return certamen;
}

// [ ok ] crea una pregunta con el enunciado y funcion de revision dados
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

// [ ok ] asigna la pregunta a la posicion n_pregunta del certamen
void asignarPregunta(
    tCertamen *certamen,
    int n_pregunta,
    tPregunta *pregunta)
{
    certamen->preguntas[n_pregunta] = *pregunta;
}

// [ ok ] retorna la pregunta en el posicion n_pregunta del certamen
tPregunta leerPregunta(tCertamen *certamen, int n_pregunta)
{
    return certamen->preguntas[n_pregunta];
}

// retorna el numero de respuestas correctas que tiene un certamen
int nCorrectasCertamen(tCertamen certamen);

// [ ok ] retorna el numero de preguntas de un certamen
int largoCertamen(tCertamen certamen)
{
    return certamen.n_preguntas;
}

// revisa si la respuesta a la pregunta es correcta
bool revisarAlternativaSimple(tPregunta pregunta) {
    printf("si\n");
}
bool revisarAlternativaMultiple(tPregunta pregunta){ 
    printf("si\n");
}
bool revisarVerdaderoFalso(tPregunta pregunta) {
    printf("si\n");
}
bool revisarCompletar(tPregunta pregunta) {
    printf("si\n");
}
