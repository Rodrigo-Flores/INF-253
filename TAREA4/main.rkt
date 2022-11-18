#lang scheme
; ---------------------- INICIO INVERSO ---------------------- ;
(define delete
  (lambda (item list)
    (cond
     ((equal? item (car list)) (cdr list))
     (else (cons (car list) (delete item (cdr list)))))))

(define (inverso_helper lista rango)
  (cond ((not (null? lista)) (inverso_helper (cdr lista) (delete (car lista) rango)))
        (else rango)))

(define (inverso lista n)
  (inverso_helper lista (range n)))

; (inverso '(1 3 7) 10)

; ---------------------- INICIO UMBRAL ---------------------- ;

; ---------------------- simple ---------------------- ;
(define index
  (lambda (elemento lista)
    (- (length lista) (length (memv elemento lista)))))

(define (umbral_simple_helper lista umbral)
  (cond ((equal? 1 (length umbral)) (index (car umbral) lista)) (else (cons (list (index (car umbral) lista)) (umbral_simple_helper lista (cdr umbral))))))

(define (umbral_simple lista umbral tipo)
  (cond ((equal? tipo #\M) (flatten (umbral_simple_helper lista (filter (lambda (x) (> x umbral)) lista))))
        ((equal? tipo #\m) (flatten (umbral_simple_helper lista (filter (lambda (x) (< x umbral)) lista))))))

; (umbral_simple '(15 2 1 3 27 5 10) 5 #\M)
; ---------------------- cola ---------------------- ;

(define (umbral_cola_helper lista umbral)
  (map (lambda (x) (index x lista)) umbral))

(define (umbral_cola lista umbral tipo)
  (cond ((equal? tipo #\M) (flatten (umbral_cola_helper lista (filter (lambda (x) (> x umbral)) lista))))
        ((equal? tipo #\m) (flatten (umbral_cola_helper lista (filter (lambda (x) (< x umbral)) lista))))))

; (umbral_cola '(15 2 1 3 27 5 10) 5 #\m)

; ---------------------- INICIO MODIFICAR SELECCIONADOS ---------------------- ;

; ---------------------- simple ---------------------- ;

;(define (modsel_simple lista_seleccion f))
  

; ---------------------- cola ---------------------- ;
