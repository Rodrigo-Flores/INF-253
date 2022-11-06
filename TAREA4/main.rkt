#lang racket

(define (func x)
  (lambda (number) (+ number 3)) x)

;(define (inverso lista n)
;  (cond (= 1 (length lista)
;        (first lista))
;        (member (inverso (rest lista) n) (range n)
;                (display (append (list '()) (inverso (rest lista) n))))
;        (else (inverso (rest lista) n))))
        

;(define (inverso lista n)
;  (if (= 1 (length lista)) (first lista) (if (member (inverso (rest lista)) (list (range n)))) (cons '() (inverso (rest lista)))))


  ; cons (first lista) (inverso (rest lista) n)