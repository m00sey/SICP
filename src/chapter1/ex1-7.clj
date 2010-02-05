; Exercise 1.7
; The good-enough? test used in computing square roots will not be very effective for finding the square roots of very small numbers.
; Also, in real computers, arithmetic operations are almost always performed with limited precision.
; This makes our test inadequate for very large numbers.
; Explain these statements, with examples showing how the test fails for small and large numbers.
;
; An alternative strategy for implementing good-enough? is to watch how guess changes from one iteration to the next
; and to stop when the change is a very small fraction of the guess.
; Design a square-root procedure that uses this kind of end test.
; Does this work better for small and large numbers?

;The problem is we had a fixed epsilon
;which in the case of small numbers will not be very accurate
;in the case of large numbers a comparatively small epsilon could
;causes more iterations than actually required.

;we can fix this by making the epsilon relative to the guess.

(ns chapter1.ex1-7
  (:use clojure.test))

(defn abs [x]
  (if (< x 0) (- x) x))

(defn square
  [x]
  (* x x)
  )

(defn average
  [x y]
  (/ (+ x y) 2))

(defn improve
  [guess x]
  (average guess (/ x guess))
  )

;make the good enough, relative to the guess
(defn good-enough?
  [guess x]
  (< (abs (- guess (/ x guess)))
       (/ guess 1000000)) )
  
(defn sqrt-iter
  [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x)
      x))
  )

(defn sqrt
  [x]
  (sqrt-iter 1.0 x))