#lang racket
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

; ---------------------- INICIO UMBRAL ---------------------- ;

; ---------------------- simple ---------------------- ;
(define index
  (lambda (elemento lista)
    (- (length lista) (length (memv elemento lista)))))

(define (umbral_simple_helper lista umbral)
  (cond ((equal? 1 (length umbral)) (index (car umbral) lista)) (else (cons (list (index (car umbral) lista)) (umbral_simple_helper lista (cdr umbral)))))
  ;(map (lambda (x) (index x lista)) umbral) ; de esta forma tambien funciona, pero la recusion no es muy visible
  )

(define (umbral_simple lista umbral tipo)
  (cond ((equal? tipo #\M) (flatten (umbral_simple_helper lista (filter (lambda (x) (> x umbral)) lista))))
        ((equal? tipo #\m) (flatten (umbral_simple_helper lista (filter (lambda (x) (< x umbral)) lista))))))

; ---------------------- cola ---------------------- ;

; ---------------------- INICIO MODIFICAR SELECCIONADOS ---------------------- ;

; ---------------------- simple ---------------------- ;

;(define (modsel_simple lista_seleccion f))
  

; ---------------------- cola ---------------------- ;