#lang scheme (current-namespace (make-base-namespace)) ; si no declaraba esto, eval me daba error

; ---------------------- INICIO INVERSO ---------------------- ;
;; elimina un elemento de una lista
;;
;; elemento : elemento en cuestion
;; lista : umbral para filtrar
(define delete
  (lambda (elemento lista)
    (cond
     ((equal? elemento (car lista)) (cdr lista))
     (else (cons (car lista) (delete elemento (cdr lista)))))))

;; descarta los los valores de la lista dada en un rango dado
;;
;; lista : lista de elementos a borrar
;; rango : rango de valores
(define (inverso_helper lista rango)
  (cond ((not (null? lista)) (inverso_helper (cdr lista) (delete (car lista) rango)))
        (else rango)))

(define (inverso lista n)
  (inverso_helper lista (range n)))

; (inverso '(1 3 7) 10)

; ---------------------- INICIO UMBRAL ---------------------- ;

; ---------------------- simple ---------------------- ;
;; obtiene el indice de un elemento en un lista
;;
;; elemento : elemento en cuestion (debe pertenecer)
;; lista : lista en la cual se busca el elemento
(define get-index
  (lambda (elemento lista)
    (- (length lista) (length (memv elemento lista)))))

;; funcion auxiliar a umbral_simple. retorna las posiciones de elementos para un umbral dado
;;
;; lista : lista de elementos para buscar umbral
;; umbral : umbral para filtrar
(define (umbral_simple_helper lista umbral)
  (cond ((equal? 1 (length umbral)) (get-index (car umbral) lista)) (else (cons (list (get-index (car umbral) lista)) (umbral_simple_helper lista (cdr umbral))))))

(define (umbral_simple lista umbral tipo)
  (cond ((equal? tipo #\M) (flatten (umbral_simple_helper lista (filter (lambda (x) (> x umbral)) lista))))
        ((equal? tipo #\m) (flatten (umbral_simple_helper lista (filter (lambda (x) (< x umbral)) lista))))))

;(umbral_simple '(15 2 1 3 27 5 10) 5 #\M)
; ---------------------- cola ---------------------- ;

;; funcion auxiliar a umbral_cola. retorna las posiciones de elementos para un umbral dado
;;
;; lista : lista de elementos para buscar umbral
;; umbral : umbral para filtrar
(define (umbral_cola_helper lista umbral)
  (map (lambda (x) (get-index x lista)) umbral))

(define (umbral_cola lista umbral tipo)
  (cond ((equal? tipo #\M) (flatten (umbral_cola_helper lista (filter (lambda (x) (> x umbral)) lista))))
        ((equal? tipo #\m) (flatten (umbral_cola_helper lista (filter (lambda (x) (< x umbral)) lista))))))

; (umbral_cola '(15 2 1 3 27 5 10) 5 #\m)

; ---------------------- INICIO MODIFICAR SELECCIONADOS ---------------------- ;

; ---------------------- simple ---------------------- ;

;; funcion auxiliar a modsel_simple. modifica los elementos en las posiciones dadas de una lista
;;
;; lista : lista a modificar
;; seleccion : lista de indices
;; f : funcion lambda dada
;; i : acumulador para la posicion del elemento
;; aux : lista auxiliar para guardar elementos modificados
(define (modsel_simple_helper lista seleccion f i aux)
  (cond ((not (null? lista))
         (if (list? (memq i seleccion))
             (modsel_simple_helper (cdr lista) seleccion f (+ i 1) (cons aux (f (car lista))))
             (modsel_simple_helper (cdr lista) seleccion f (+ i 1) (cons aux (car lista)))))
        (else (flatten aux))))   

(define (modsel_simple lista seleccion f)
  (modsel_simple_helper lista seleccion f 0 '()))

;(modsel_simple '(15 2 1 3 27 5 10) '(0 4 6) (lambda (x) (modulo x 2)))
;(modsel_simple '(15 2 1 3 27 5 10) '(3 1 2) (lambda (x) (+ x 5)))

; ---------------------- cola ---------------------- ;

;; funcion auxiliar a modsel_cola. modifica los elementos en las posiciones dadas de una lista
;;
;; lista : lista a modificar
;; seleccion : lista de indices
;; f : funcion lambda dada
;; i : acumulador para la posicion del elemento
;; aux : lista auxiliar para guardar elementos modificados
(define (modsel_cola_helper lista seleccion f i aux)
  (if (not (null? lista))
      (if (list? (memq i seleccion)) (modsel_cola_helper (cdr lista) seleccion f (+ i 1) (cons aux (f (car lista))))
          (modsel_cola_helper (cdr lista) seleccion f (+ i 1) (cons aux (car lista))))
      (flatten aux)))

(define (modsel_cola lista seleccion f)
  (modsel_cola_helper lista seleccion f 0 '()))

;(modsel_cola '(15 2 1 3 27 5 10) '(0 4 6) (lambda (x) (modulo x 2)))
;(modsel_cola '(15 2 1 3 27 5 10) '(3 1 2) (lambda (x) (+ x 5)))

; ---------------------- INICIO ESTABLES ---------------------- ;
(define (estables lista umbral fM fm)
  (append
   (list (length (umbral_simple (modsel_cola lista (umbral_simple lista umbral #\M) fM) umbral #\M)))
   (list (length (umbral_simple (modsel_cola lista (umbral_simple lista umbral #\m) fm) umbral #\m)))))

;(estables '(15 2 1 3 27 5 10) 5 (lambda (x) (/ x 2)) (lambda (x) (* x 2)))

; ---------------------- INICIO QUERY ---------------------- ;

;; obtiene un elemento de una posicion de una lista dada
;;
;; lst : lista de donde se extrae el elemento en la posicion dada
;; pos : posicion del elemento en la lista
(define (get-element lst pos) 
  (if (<= pos 0)
      (car lst)
      (get-element (cdr lst) (- pos 1))))

(define (query lista pos op params)
  (cond ((equal? op 1) (umbral_cola (get-element lista pos) (get-element params 0) (get-element params 1)))
        ((equal? op 2) (modsel_simple (get-element lista pos) (get-element params 0) (eval (get-element params 1))))
        ((equal? op 3) (estables (get-element lista pos) (get-element params 0) (eval (get-element params 1)) (eval (get-element params 2))))))


;(query '((0 1 2 3 4) (4 3 2 1 0) (15 2 1 3 27 5 10)) 1 1 '(1 #\M))
;(0 1 2)
;(query '((0 1 2 3 4) (4 3 2 1 0) (15 2 1 3 27 5 10)) 0 2 '((0 4) (lambda (x) (+ x 100))))
;(100 1 2 3 104)
;(query '((0 1 2 3 4) (4 3 2 1 0) (15 2 1 3 27 5 10)) 2 3 '(5 (lambda (x) (/ x 2)) (lambda (x) (* x 2))))
;(2 1)












  