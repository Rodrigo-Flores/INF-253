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

    fclose(archivo);

    return 0;
}