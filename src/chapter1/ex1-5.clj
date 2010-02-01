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

;What about normal order?
;The thing to remember here is that normal order expands everything first, then reduces.
;when we expand (testp 0 (p))
;we first expand 0, which is easy, that is 0
;we then expand (p), which results in the body of p.
;our body of testp after the expansion would look like
;(if (= 0 0) 0 (p)))
;there is nothing else to expand, as we then begin the reduce
;we get to evaluating (= 0 0)
;which results in 0
