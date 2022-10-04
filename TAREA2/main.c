#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
// #include "certamen.h"
#include "certamen.c"

int main()
{
    FILE *archivo;
    archivo = fopen("ejemplos/certamen1.txt", "r");
    char linea[128];
    int n_preguntas;

    fgets(linea, 128, archivo);
    n_preguntas = atoi(linea); // sscanf(linea, "%d", &n_preguntas);
    tCertamen *certamen = crearCertamen(n_preguntas);
    int i = 0;
    while (fgets(linea, 128, archivo))
    {
        // printf("%s", linea);
        // strtok(linea, "\n");
        if (strcmp(linea, "AlternativaSimple") == 0.0)
        {
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
            tPregunta *pregunta = crearPregunta(certamen, (char*)("AlternativaSimple"), enunciado, revisarAlternativaSimple);
            asignarPregunta(certamen, i, pregunta);
        }
        else if (linea == "AlternativaMultiple")
        {
            fgets(linea, 128, archivo);
            strtok(linea, "\n");
            tEnunciadoAlternativaMultiple *enunciado = (tEnunciadoAlternativaMultiple *)malloc(sizeof(tEnunciadoAlternativaMultiple));
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
            enunciado->n_correctas = atoi(linea);
            enunciado->alternativa_correcta = (int *)malloc(sizeof(int) * enunciado->n_correctas);
            for (int j = 0; j < enunciado->n_correctas; j++)
            {
                fgets(linea, 128, archivo);
                strtok(linea, "\n");
                enunciado->alternativa_correcta[j] = atoi(linea);
            }
            tPregunta *pregunta = crearPregunta(certamen, (char*)("AlternativaMultiple"), enunciado, revisarAlternativaMultiple);
            asignarPregunta(certamen, i, pregunta);
        }
        else if (linea == "VerdaderoFalso")
        {
            fgets(linea, 128, archivo);
            strtok(linea, "\n");
            tEnunciadoVerdaderoFalso *enunciado = (tEnunciadoVerdaderoFalso *)malloc(sizeof(tEnunciadoVerdaderoFalso));
            strcpy(enunciado->enunciado, linea);
            fgets(linea, 128, archivo);
            strtok(linea, "\n");
            if (strcmp(linea, "V") == 0.0)
            {
                enunciado->respuesta = true; // 1
            }
            else
            {
                enunciado->respuesta = false; // 0
            }
            tPregunta *pregunta = crearPregunta(certamen, (char*)("VerdaderoFalso"), enunciado, revisarVerdaderoFalso);
            asignarPregunta(certamen, i, pregunta);
        }
        else if (linea == "Completar")
        {
            fgets(linea, 128, archivo);
            strtok(linea, "\n");
            tEnunciadoCompletar *enunciado = (tEnunciadoCompletar *)malloc(sizeof(tEnunciadoCompletar));
            enunciado->n_textos = atoi(linea);
            enunciado->textos = (char **)malloc(sizeof(char *) * enunciado->n_textos);
            for (int j = 0; j < (enunciado->n_textos - 1); j++)
            {
                fgets(linea, 128, archivo);
                strtok(linea, "\n");
                enunciado->textos[j] = (char *)malloc(sizeof(char) * 128);
                strcpy(enunciado->textos[j], linea);
            }
            for (int j = 0; j < (enunciado->n_textos - 1); j++)
            {
                fgets(linea, 128, archivo);
                strtok(linea, "\n");
                enunciado->respuestas = (char **)malloc(sizeof(char) * 128);
                strcpy((char*)(enunciado)->respuestas, linea);
            }
        }
        i++;
    }
    fclose(archivo);

    printf("[ ok ] Certamen creado correctamente\n");

    printf("El certamen cuenta con %d preguntas\n", certamen->n_preguntas);
    // for (int i = 0; i < certamen->n_preguntas; i++)
    // {
    //     leetPregunta(certamen, i);
    // }

    // free memory
    free(certamen->preguntas);
    free(certamen);

    return 0;
}
