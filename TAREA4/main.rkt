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

; (x "hola")
(y 2 1)
(y 1 8)
(y 10 2)
(y 1 5)
(y 2 2)