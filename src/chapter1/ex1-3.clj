;Exercise 1.3.
;Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers.
;
;e.g. (sum-of-squares 4 5 6)
;			=> 61
(ns chapter1.ex1-3
  (:use clojure.test))

(defn square
  [x]
  (* x x)
  )

(defn sum-of-squares
  [x y]
  (+ (square y) (square x))
  )

(defn sum-squares-of-larger-numbers
  [x y z]
  (if (> x y)
    (if (> y z)
      (sum-of-squares x y)
      (sum-of-squares x z))
    (if (> x z)
      (sum-of-squares y x)
      (sum-of-squares y z))
    )
  )

(deftest test-square
  (is (= (square 2) 4))
  (is (not (= (square 2) 6)))
  )

(deftest test-sum-of-squares
  (is (= (sum-of-squares 2 3) 13))
  (is (not= (sum-of-squares 2 3) 14))
  )

(deftest test-sum-squares-of-larger-numbers
  (is (= (sum-squares-of-larger-numbers 2 3 4) 25))
  (is (= (sum-squares-of-larger-numbers 2 4 3) 25))
  (is (= (sum-squares-of-larger-numbers 3 2 4) 25))
  (is (= (sum-squares-of-larger-numbers 0 2 0) 4))
  (is (= (sum-squares-of-larger-numbers 5 5 5) 50))
  (is (not= (sum-squares-of-larger-numbers 2 3 4) 20))
  )

(run-tests)