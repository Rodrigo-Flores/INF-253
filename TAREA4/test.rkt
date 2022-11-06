#lang racket

(define (x text)
  (display text)
  (newline))

(define (y n1 n2)
  (cond
    ((> n1 n2) display n1)
    ((< n1 n2) display n2)
    ((= n1 n2) display '())
    )
  )

(define (suma lista)
  (if (= 1 (length lista)) (first lista) (+ (first lista) (suma (rest lista)))))


; (x "hola")
; (y 2 1)
