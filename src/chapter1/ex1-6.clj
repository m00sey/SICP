;Exercise 1.6.  Alyssa P. Hacker doesn't see why if needs to be provided as a special form. `
;`Why can't I just define it as an ordinary procedure in terms of cond?'' she asks.
; Alyssa's friend Eva Lu Ator claims this can indeed be done, and she defines a new version of if:
;
;(define (new-if predicate then-clause else-clause)
;  (cond (predicate then-clause)
;        (else else-clause)))

;What happens when Alyssa attempts to use this to compute square roots? Explain.

;Answer for Scheme.
;The implementation of new-if as a procedure, means it will be evaluated with applicative order, meaning square-iter
;happens before true/false has been evaluated
;if is a special form - so it is not evaluated using applicative order

;Think about expanding new-if using applicative order. i.e ex1-4

;For clojure we need to look at the cond macro.
(ns chapter1.ex1-6
  (:use clojure.test))

(defn new-if
  [predicate then-clause else-clause]
  (cond predicate then-clause
    :default else-clause)
  )

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

(defn good-enough?
  [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn sqrt-iter
  [guess x]
  (if (good-enough? guess x)
;  (new-if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x)
      x))
  )

(defn sqrt
  [x]
  (sqrt-iter 1.0 x))

;todo test the rest
;find test that allow for a delta
(deftest test-sqrt
  (is(=(sqrt 9) 3.00009155413138)))

(run-tests)