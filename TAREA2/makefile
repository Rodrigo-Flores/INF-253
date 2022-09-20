all: programa

programa: main.o certamen.o
	gcc -o programa main.o certamen.o

main.o: main.c certamen.h
	gcc -c main.c

certamen.o: certamen.c certamen.h
	gcc -c certamen.c


test: test.o
	gcc -o test test.o

test.o: test.c
	gcc -c test.c

clean:
	rm -f *.o programa