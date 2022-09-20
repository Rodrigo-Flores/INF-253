#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "certamen.h"

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
        printf("%s", linea);
        strtok(linea, "\n");
        if (strcmp(linea, "AlternativaSimple") == 0.0)
        {
            char *tipo = "AlternativaSimple";
            fgets(linea, 128, archivo);
            strtok(linea, "\n");
            tPregunta *pregunta = crearPregunta(certamen, tipo, linea, revisarAlternativaSimple);
        }
        else if (linea == "AlternativaMultiple")
        {
            continue;
        }
        else if (linea == "VerdaderoFalso")
        {
            continue;
        }
        else if (linea == "Completar")
        {
            continue;
        }
        i++;
    }

    return 0;
}
