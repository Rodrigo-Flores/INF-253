% - - - - - - - PRIMERO - - - - - - - - %

sepparimpar(List, Par, Impar) :- 
    sepparimpar(List, Par, Impar, 0).

sepparimpar([], [], [], _).
sepparimpar([H|T], [H|Par], Impar, N) :- 
    N mod 2 =:= 0, 
    N1 is N + 1, 
    sepparimpar(T, Par, Impar, N1).
sepparimpar([H|T], Par, [H|Impar], N) :-
    N mod 2 =:= 1, 
    N1 is N + 1, 
    sepparimpar(T, Par, Impar, N1).

% - - - - - - - SEGUNDO - - - - - - - - %


%%
% 
% pone al reverso una lista dada (la da vuelta)
%
%%

reverse(List, Reversed) :- reverse(List, Reversed, []).
reverse([], Reversed, Reversed).
reverse([H|T], Reversed, Acc) :- reverse(T, Reversed, [H|Acc]).


%%
% 
% crea un rango entre dos valores dados
% ocupa el predicado reverse
%
%%
range(Start, End, Range) :- range(Start, End, Range, []).
range(Start, End, Range, Acc) :- 
    Start =< End, 
    Start1 is Start + 1, 
    range(Start1, End, Range, [Start|Acc]).
range(Start, End, Range, Acc) :-
    Start > End, 
    reverse(Acc, Range).


%%
% 
% elimina el ultimo elemento de una lista (el ultimo en posicion)
% ej: [1,2,3,4,5] -> [1,2,3,4] 
% ej: [4,3,2,1] -> [4,3,2]
%
%%
deleteLast([_], []).
deleteLast([H|T], [H|T1]) :- deleteLast(T, T1).


%%
% 
% para cada elmento en una lista, se verifica la existencia dentro de este en otra lista
%
%%
all_in([], _).
all_in([H|T], List) :-
    member(H, List),
    all_in(T, List).

%%
% 
% realiza el trabajo, llamando a los predicados anteriores
% determinar si los elmentos en un rango dado, estan presentes en la lista.
%
%%
todosrango(List, N, M) :-
    range(N, M, R),
    deleteLast(R, L),
    all_in(L, List).

% - - - - - - - TERCERO - - - - - - - - %

%%
% 
% toma el elemento mas grande en una lista
%
%%
max([X], X).
max([X|Xs], X) :- max(Xs, Y), X >= Y.
max([X|Xs], Y) :- max(Xs, Y), X < Y.

%%
% 
% junto con el predicado max, obtiene el maximo elemento de una lista incrementado en uno
%
%%
max1(List, Max1) :- max(List, Max), Max1 is Max + 1.

%%
% 
% toma el elemento mas pequeño en una lista
%
%%
min([X], X).
min([X|Xs], X) :- min(Xs, Y), X =< Y.
min([X|Xs], Y) :- min(Xs, Y), X > Y.


%%
% 
% en conjunto de los predicados anteriores, obtiene el minimo elemento de una lista y el maximo mas 1 (el rango)
%
%%
rangomax(List, X, Y) :- max1(List, X), min(List, Y).