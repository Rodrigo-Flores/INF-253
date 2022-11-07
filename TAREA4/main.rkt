#lang racket

(define (func x rango)
  (if (= 1 (length rango)) (if (= (first rango) x) (x) '()) (append '() (func x (rest rango)))))

(define delete
  (lambda (item list)
    (cond
     ((equal? item (car list)) (cdr list))
     (else (cons (car list) (delete item (cdr list)))))))

(define subset
    (lambda (lst)
        (if (null? lst)
            lst
            (append (subset (cdr lst)))
        )))

(define (inverso lista n)
  (map (lambda (x) (delete x (range n))) lista))
  ;(if (= 1 (length lista)) (delete (first lista) (range n)) (inverso rest lista)))

;(define (inverso lista n)
;  (cond (= 1 (length lista)
;        (first lista))
;        (member (inverso (rest lista) n) (range n)
;                (display (append (list '()) (inverso (rest lista) n))))
;        (else (inverso (rest lista) n))))
        

;(define (inverso lista n)
;  (if (= 1 (length lista)) (first lista) (if (member (inverso (rest lista)) (list (range n)))) (cons '() (inverso (rest lista)))))


  ; cons (first lista) (inverso (rest lista) n)