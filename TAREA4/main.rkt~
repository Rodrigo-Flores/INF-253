#lang racket

(define delete
  (lambda (item list)
    (cond
     ((equal? item (car list)) (cdr list))
     (else (cons (car list) (delete item (cdr list)))))))

(define (inverso lista n)
  
  ;(map (lambda (x) (delete x (range n))) lista))

  