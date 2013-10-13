(ns ndigits.core)

(defn welcome []
  (println "Welcome to ndigit game."))

(defn dup? [digit]
  (if (= (count digit) (count (into #{} digit)))
    false
    true
  )
)

(defn input-n-digit []
  (print "Input number of digits[1-9]: ") (flush) 
  (let [n-digit (Integer/parseInt (read-line))] 
    (if (and (<= 1 n-digit) (<= n-digit 9)) 
      n-digit 
      (do (println "Wrong number.") (input-n-digit))
    )
  )
)

(defn count-result [gen-digit answer index result]
  (if (>= index (count gen-digit))
    result
	  (let [find-index (.indexOf gen-digit (str (.charAt answer index)))]
	    (if (= find-index -1)
	      (count-result gen-digit answer (inc index) result)
	      (if (= find-index index)
	        (count-result gen-digit answer (inc index) [(inc (result 0)) (result 1)])
	        (count-result gen-digit answer (inc index) [(result 0) (inc (result 1))])
	      )
	    )
    )
  )
)

(defn print-result [gen-digit answer]
  (let [result (count-result gen-digit answer 0 [0 0])]
    (println (str (result 0) "S " (result 1) "B"))
  )
)

(defn check-result [gen-digit answer]
  (if (= gen-digit answer)
    true
    (do (print-result gen-digit answer) false)
  )
)

(defn invalid-answer? [gen-digit answer]
  (if (or (dup? answer) 
          (not= (count gen-digit) (count answer))
      )
    true
    false
  )
)

(defn gen-digit [n-digit]
  (let [result (format (str "%0" n-digit "d") (rand-int (Math/pow 10 n-digit)))]
    (if (dup? result)
      (gen-digit n-digit)
      result
    )
  )
)


(defn check-answer [gen-digit turn]
  (print (str "[Turn " turn "] Input: ")) (flush)
  (let [answer (read-line)]
    (if (invalid-answer? gen-digit answer)
      (do (println "Wrong number.") 
        (check-answer gen-digit turn))
	    (if (check-result gen-digit answer) 
	      (println "You Win!" turn "turns.")
	      (check-answer gen-digit (inc turn))
	    )
    )
  )
)

(defn -main [& m]
  (welcome)
  (let [turn 1
        n-digit (input-n-digit)
        gen-digit (gen-digit n-digit)]
    ;;(println gen-digit)
    (check-answer gen-digit turn)
  )
)
