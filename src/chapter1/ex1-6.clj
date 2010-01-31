;Exercise 1.6
;Given the new-if, demonstrate what happens to the square-roots.clj example.

(defn new-if
	[predicate then-clause else-clause]
	(cond (predicate then-clause)
				(else else-clause))
  )

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
	(new-if (good-enough? guess x)
		guess
		(sqrt-iter (improve guess x)
			x))
)

(defn sqrt
	[x]
	(sqrt-iter 1.0 x))

(sqrt 9)