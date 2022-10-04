#include <stdio.h>
#include <stdlib.h>

// #include "header.h"
#include "certamen.h"

int main () {
    FILE *archivo;
    archivo = fopen("./../ejemplos/certamen1.txt", "r");
    char linea[128];
    int n_preguntas;

    fgets(linea, 128, archivo);
    n_preguntas = atoi(linea); // sscanf(linea, "%d", &n_preguntas);
    tCertamen *certamen = crearCertamen(n_preguntas);

    int i = 0;
    while (fgets(linea, 128, archivo)) {
        strtok(linea, "\n");
        if (strcmp(linea, "AlternativaSimple") == 0.0) {
            fgets(linea, 128, archivo);
            strtok(linea, "\n");
            tEnunciadoAlternativa *enunciado = (tEnunciadoAlternativa *)malloc(sizeof(tEnunciadoAlternativa));
            strcpy(enunciado->enunciado, linea);
            fgets(linea, 128, archivo);
            strtok(linea, "\n");
            enunciado->n_alternativas = atoi(linea);
            enunciado->alternativas = (char **)malloc(sizeof(char *) * enunciado->n_alternativas);
            for (int j = 0; j < enunciado->n_alternativas; j++)
            {
                fgets(linea, 128, archivo);
                strtok(linea, "\n");
                enunciado->alternativas[j] = (char *)malloc(sizeof(char) * 128);
                strcpy(enunciado->alternativas[j], linea);
            }
            fgets(linea, 128, archivo);
            strtok(linea, "\n");
            enunciado->alternativa_correcta = atoi(linea);
            tPregunta *pregunta = crearPregunta(certamen, (char*)("AlternativaSimple"), enunciado);
            asignarPregunta(certamen, i, pregunta);
        }
        i++;
    }

    // tPregunta pregunta = leerPregunta(certamen, 0);
    // tEnunciadoAlternativa *enunciado = (tEnunciadoAlternativa *)pregunta.enunciado;
    // printf("%s", enunciado->enunciado);

    free(certamen->preguntas);
    free(certamen);

    fclose(archivo);

    return 0;
}