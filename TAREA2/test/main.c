#include <stdio.h>
#include <stdlib.h>
#include "certamen.h"

int main()
{
    FILE *archivo;
    archivo = fopen("./../ejemplos/certamen1.txt", "r");
    char linea[128];
    int n_preguntas;

    fgets(linea, 128, archivo);
    n_preguntas = atoi(linea); // sscanf(linea, "%d", &n_preguntas);
    tCertamen *certamen = crearCertamen(n_preguntas);

    // recoleccion de datos
    int i = 0;
    while (fgets(linea, 128, archivo))
    {
        strtok(linea, "\n");
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
            tPregunta *pregunta = crearPregunta(certamen, (char *)("AlternativaSimple"), enunciado, (void *)revisarAlternativaSimple);
            asignarPregunta(certamen, i, pregunta);
            i++;
        }
        if (strcmp(linea, "AlternativaMultiple") == 0.0)
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
            tPregunta *pregunta = crearPregunta(certamen, (char *)("AlternativaMultiple"), enunciado, (void *)revisarAlternativaMultiple);
            asignarPregunta(certamen, i, pregunta);
            i++;
        }
        if (strcmp(linea, "VerdaderoFalso") == 0.0)
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
            tPregunta *pregunta = crearPregunta(certamen, (char *)("VerdaderoFalso"), enunciado, (void *)revisarVerdaderoFalso);
            asignarPregunta(certamen, i, pregunta);
            i++;
        }
        if (strcmp(linea, "Completar") == 0.0)
        {
            fgets(linea, 128, archivo);
            strtok(linea, "\n");
            tEnunciadoCompletar *enunciado = (tEnunciadoCompletar *)malloc(sizeof(tEnunciadoCompletar));
            enunciado->n_textos = atoi(linea);
            enunciado->textos = (char **)malloc(sizeof(char *) * enunciado->n_textos);
            for (int j = 0; j < (enunciado->n_textos); j++)
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
                strcpy((char *)(enunciado)->respuestas, linea);
            }
            tPregunta *pregunta = crearPregunta(certamen, (char *)("Completar"), enunciado, (void *)revisarCompletar);
            asignarPregunta(certamen, i, pregunta);
            i++;
        }
    }
    // logica de respuesta de usuario
    int respuesta, k = 0;
    tRespuesta *respuestas = (tRespuesta *)malloc(sizeof(tRespuesta) * certamen->n_preguntas);
    respuestas->correctas = 0;
    respuestas->incorrectas = 0;
    fseek(archivo, 0, SEEK_SET);
    while (fgets(linea, 128, archivo))
    {
        respuesta = 0;
        strtok(linea, "\n");
        if (strcmp(linea, "AlternativaSimple") == 0.0)
        {
            printf("- - - - - - - - - %d - - - - - - - - -\n", k + 1);
            tPregunta pregunta = leerPregunta(certamen, k);
            tEnunciadoAlternativa *enunciado = (tEnunciadoAlternativa *)pregunta.enunciado;
            printf("%s\n", enunciado->enunciado);
            for (int j = 0; j < enunciado->n_alternativas; j++)
            {
                printf("%d. %s\n", j + 1, enunciado->alternativas[j]);
            }
            printf("\n>");
            scanf("%d", &respuesta);
            if (revisarAlternativaSimple(pregunta, respuesta))
            {
                respuestas->correctas++;
            }
            else
            {
                respuestas->incorrectas++;
            }
            k++;
        }
        if (strcmp(linea, "AlternativaMultiple") == 0.0)
        {
            printf("- - - - - - - - - %d - - - - - - - - -\n", k + 1);
            tPregunta pregunta = leerPregunta(certamen, k);
            tEnunciadoAlternativaMultiple *enunciado = (tEnunciadoAlternativaMultiple *)pregunta.enunciado;
            printf("%s\n", enunciado->enunciado);
            for (int j = 0; j < enunciado->n_alternativas; j++)
            {
                printf("%d. %s\n", j + 1, enunciado->alternativas[j]);
            }
            printf("¿Cuantas alternativas se escogeras?\n>");
            scanf("%d", &respuesta);
            int *respuestas_usuario = (int *)malloc(sizeof(int) * respuesta);
            for (int j = 0; j < respuesta; j++)
            {
                printf(">");
                scanf("%d", &respuestas_usuario[j]);
            }
            if (revisarAlternativaMultiple(pregunta, respuestas_usuario))
            {
                respuestas->correctas++;
            }
            else
            {
                respuestas->incorrectas++;
            }

            k++;
        }
        if (strcmp(linea, "VerdaderoFalso") == 0.0)
        {
            printf("- - - - - - - - - %d - - - - - - - - -\n", k + 1);
            tPregunta pregunta = leerPregunta(certamen, k);
            tEnunciadoVerdaderoFalso *enunciado = (tEnunciadoVerdaderoFalso *)pregunta.enunciado;
            printf("%s\n", enunciado->enunciado);
            printf("1. Verdadero\n");
            printf("2. Falso\n>");
            scanf("%d", &respuesta);
            if (respuesta == 1)
            {
                if (revisarVerdaderoFalso(pregunta, true))
                {
                    respuestas->correctas++;
                }
                else
                {
                    respuestas->incorrectas++;
                }
            }
            else if (respuesta == 0)
            {
                if (revisarVerdaderoFalso(pregunta, false))
                {
                    respuestas->correctas++;
                }
                else
                {
                    respuestas->incorrectas++;
                }
            }

            k++;
        }
        if (strcmp(linea, "Completar") == 0.0)
        {
            printf("- - - - - - - - - %d - - - - - - - - -\n", k + 1);
            tPregunta pregunta = leerPregunta(certamen, k);
            tEnunciadoCompletar *enunciado = (tEnunciadoCompletar *)pregunta.enunciado;
            printf("%d\n", k);
            for (int j = 0; j < enunciado->n_textos; j++)
            {
                printf("%s\n", enunciado->textos[j]);
            }
            printf("\n>");
            // char **respuestas_usuario = (char **)malloc(sizeof(char *) * (enunciado->n_textos - 1));
            // for (int j = 0; j < (enunciado->n_textos - 1); j++)
            // {
            //     respuestas_usuario[j] = (char *)malloc(sizeof(char) * 128);
            //     scanf("%s", respuestas_usuario[j]);
            // }
            // if (revisarCompletar(pregunta, respuestas_usuario))
            // {
            //     respuestas->correctas++;
            // }
            // else
            // {
            //     respuestas->incorrectas++;
            // }
            k++;
        }
    }

    printf("Correctas: %d\n", respuestas->correctas);
    printf("Incorrectas: %d\n", respuestas->incorrectas);

    free(certamen->preguntas);
    free(certamen);
    free(respuestas);

    fclose(archivo);

    return 0;
}