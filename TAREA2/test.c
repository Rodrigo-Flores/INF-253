#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char name[64];
    int *age;

} tPersona;


int main() {
    tPersona *persona = (tPersona *) malloc(sizeof(tPersona));
    strcpy(persona->name, "Juan");
    persona->age = (int *) malloc(sizeof(int));
    *(persona->age) = 20;
    printf("%s %d", persona->name, *(persona->age));
    free(persona->age);
    free(persona);

    return 0;
}