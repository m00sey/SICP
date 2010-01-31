;Observe that our model of evaluation allows for combinations whose operators are compound expressions.
;Use this observation to describe the behavior of the following procedure:

;(define (a-plus-abs-b a b) ((if (> b 0) + -) a b)) - Lisp
(ns chapter1.ex1-4
  (:use clojure.test))

(defn a-plus-abs-b
  [a b]
  ;Note the opperand for the last procedure is evaluated by (if (> b 0) + -).
  ((if (> b 0) + -) a b)
  )


(deftest test-a-plus-abs-b
  (is (= (a-plus-abs-b 1 2) 3))
  (is (= (a-plus-abs-b 3 -1) 4))
  )

(run-tests)

; ((if (> 2 0) + -) 1 2)            ; ((if (> -1 0) + -) 3 -1)
;Evaluate 2 > 0 => true             ;Evaluate -1 > 0 => false

; ((if true + -) 1 2)               ; ((if false + -) 3 -1)
;Evaluate true (consequent) => +    ;Evaluate false (alternative) => -

; (+ 1 2)                           ; (- 3 -1)
; 3                                 ; 4
