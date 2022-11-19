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
(define get-index
  (lambda (elemento lista)
    (- (length lista) (length (memv elemento lista)))))

(define (umbral_simple_helper lista umbral)
  (cond ((equal? 1 (length umbral)) (get-index (car umbral) lista)) (else (cons (list (get-index (car umbral) lista)) (umbral_simple_helper lista (cdr umbral))))))

(define (umbral_simple lista umbral tipo)
  (cond ((equal? tipo #\M) (flatten (umbral_simple_helper lista (filter (lambda (x) (> x umbral)) lista))))
        ((equal? tipo #\m) (flatten (umbral_simple_helper lista (filter (lambda (x) (< x umbral)) lista))))))

; (umbral_simple '(15 2 1 3 27 5 10) 5 #\M)
; ---------------------- cola ---------------------- ;

(define (umbral_cola_helper lista umbral)
  (map (lambda (x) (get-index x lista)) umbral))

(define (umbral_cola lista umbral tipo)
  (cond ((equal? tipo #\M) (flatten (umbral_cola_helper lista (filter (lambda (x) (> x umbral)) lista))))
        ((equal? tipo #\m) (flatten (umbral_cola_helper lista (filter (lambda (x) (< x umbral)) lista))))))

; (umbral_cola '(15 2 1 3 27 5 10) 5 #\m)

; ---------------------- INICIO MODIFICAR SELECCIONADOS ---------------------- ;

; ---------------------- simple ---------------------- ;

;(define (get-element lst pos) 
;  (if (<= pos 0)
;      (car lst)
;      (get-element (cdr lst) (- pos 1))))
;
;(define (modsel_simple_helper lista seleccion f i)
;  (if (equal? i 0) (car lista)
;      (if (equal? i 4) (car lista) (cons '() (modsel_simple_helper (cdr lista) seleccion f (- i 1))))))
;
;(define (modsel_simple lista seleccion f)
;  ;(map f (map (lambda (x) (get-element lista x)) seleccion))
;  (modsel_simple_helper (reverse lista) seleccion f (- (length lista) 1)))
;

; ---------------------- cola ---------------------- ;
(define (modsel_cola_helper lista seleccion f i aux)
  (if (not (null? lista))
      (if (list? (memq i seleccion)) (modsel_cola_helper (cdr lista) seleccion f (+ i 1) (cons aux (f (car lista))))
          (modsel_cola_helper (cdr lista) seleccion f (+ i 1) (cons aux (car lista))))
      (flatten aux)))

(define (modsel_cola lista seleccion f)
  (modsel_cola_helper lista seleccion f 0 '()))

(modsel_cola '(15 2 1 3 27 5 10) '(0 4 6) (lambda (x) (modulo x 2)))
;(modsel_cola '(15 2 1 3 27 5 10) '(3 1 2) (lambda (x) (+ x 5)))