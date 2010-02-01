;Exercise 1.5.
;Ben Bitdiddle has invented a test to determine whether the interpreter he is faced with is using
; applicative-order evaluation or normal-order evaluation. He defines the following two procedures:
;(define (p) (p))
;
;(define (test x y)
;  (if (= x 0)
;      0
;      y))
;
;Then he evaluates the expression
;
;(test 0 (p))
;
(ns chapter1.ex1-5)

(defn p []
  (p)
  ;(recur)
  )

;test is reserved for clojure.text :(
(defn testp
  [x y]
  (if (= x 0)
    0
    y)
  )

;chapter1.ex1-5=> (testp 0 (p))
;java.lang.StackOverflowError (NO_SOURCE_FILE:0)
;same if we have (recur) as the impl of p
;java.lang.StackOverflowError (NO_SOURCE_FILE:0)

;What happened?
;both 0 and (p) are evaluated before we actually run the body of test (before test is invoked?)
;evaluation of p is to call itself so we get stuck in an infinite loop
