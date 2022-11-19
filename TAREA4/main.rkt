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

(define (modsel_simple_helper lista seleccion f i aux)
  (cond ((not (null? lista))
         (if (list? (memq i seleccion))
             (modsel_simple_helper (cdr lista) seleccion f (+ i 1) (cons aux (f (car lista))))
             (modsel_simple_helper (cdr lista) seleccion f (+ i 1) (cons aux (car lista)))))
        (else (flatten aux))))
  ;(if (equal? 1 (length lista)) (flatten aux) '(1)))
      

(define (modsel_simple lista seleccion f)
  (modsel_simple_helper lista seleccion f 0 '()))

;(modsel_simple '(15 2 1 3 27 5 10) '(0 4 6) (lambda (x) (modulo x 2)))
;(modsel_simple '(15 2 1 3 27 5 10) '(3 1 2) (lambda (x) (+ x 5)))

; ---------------------- cola ---------------------- ;
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