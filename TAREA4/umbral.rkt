#lang racket

(define (umbral_simple_aux lista umbral)
  (if (= 1 (length lista))
      (if (> (first lista) umbral)
          (cons (first lista) (umbral_simple_aux (rest lista) umbral))
          '())
      (if (not(null? lista))
          (cons lista (umbral_simple_aux (rest lista) umbral))
          '())))

(define (umbral_simple lista umbral tipo)
  (if (eq? #\M tipo) (umbral_simple_aux (sort lista <) umbral) '()))