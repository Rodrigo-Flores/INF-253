#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int funcionPrueba(int x, int y);

int main() {
    // char *x = "hola";
    char x[128] = "hola";
    // char *y = "hola";

    if (strcmp(x, "hola") == 0.0) {
        printf("Son iguales");
    } else {
        printf("Son diferentes");
    }

    return 0;
}