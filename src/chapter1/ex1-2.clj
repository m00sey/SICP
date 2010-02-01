; Exercise 1.2.
; Translate the following expression into prefix form
; Numerator:   5 + 4 + (2 - (3 - (6 + 4/5)))
; Denominator: 3(6 - 2)(2 - 7)
(ns chapter1.ex1-2)

;ran in REPL 
(/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5)))))
   (* 3 (- 6 2) (- 2 7)) )
