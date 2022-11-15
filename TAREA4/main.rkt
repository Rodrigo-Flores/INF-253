#lang racket

(define delete
  (lambda (item list)
    (cond
     ((equal? item (car list)) (cdr list))
     (else (cons (car list) (delete item (cdr list)))))))

(define index
  (lambda (elemento lista)
    (- (length lista) (length (memv elemento lista)))))

(define (umbral_simple_helper lista umbral)
  (cond ((= 1 (length lista)) (first lista))
        (else (display (index (first umbral) lista)))))

(define (umbral_simple lista umbral tipo)
  (cond ((equal? tipo #\M) (umbral_simple_helper lista (filter (lambda (x) (> x umbral)) lista)))
        ((equal? tipo #\m) (umbral_simple_helper lista (filter (lambda (x) (< x umbral)) lista)))))


(umbral_simple '(15 2 1 3 27 5 10) 5 #\M)