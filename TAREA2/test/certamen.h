#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

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
    bool (*revisar)(void *, void *);
} tPregunta;

typedef struct
{
    int n_preguntas;
    tPregunta *preguntas;
} tCertamen;

// FUNCIONES

// crea un nuevo certamen vacio
tCertamen *crearCertamen(int n_preguntas);

// crea una pregunta con el enunciado y funcion de revision dados
tPregunta *crearPregunta(
    tCertamen *certamen,
    char *tipo,
    void *enunciado,
    bool revisar(void *, void *));

// asigna la pregunta a la posicion n_pregunta del certamen
void asignarPregunta(
    tCertamen *certamen,
    int n_pregunta,
    tPregunta *pregunta);

// retorna la pregunta en el posicion n_pregunta del certamen
tPregunta leetPregunta(tCertamen *certamen, int n_pregunta);

// retorna el numero de respuestas correctas que tiene un certamen
int nCorrectasCertamen(tCertamen certamen);

// retorna el numero de preguntas de un certamen
int largoCertamen(tCertamen certamen);

// revisa si la respuesta a la pregunta es correcta
bool revisarAlternativaSimple(tPregunta pregunta);
bool revisarAlternativaMultiple(tPregunta pregunta);
bool revisarVerdaderoFalso(tPregunta pregunta);
bool revisarCompletar(tPregunta pregunta);
