(ns clojure-dj.core
  (:gen-class)
  (:use overtone.live))

(defsynth fuzz-synth
  "A fuzzing sound."
  [freq 200 duration 1.5]
  (let [src (- (sin-osc freq (* 2 Math/PI (lf-saw 2)))
               (lf-saw freq))
        env (env-gen (perc 0.1 duration) :action FREE)]
    (out 0 (pan2 (* src env)))))

(defn fuzz-beat
  "Lifechanging beat."
  [speed]
  (fuzz-synth)
  (Thread/sleep (* 1000 speed))
  (fuzz-synth)
  (Thread/sleep (* 4000 speed)))

(defn -main
  "Insert Beautiful Music Here."
  [& args]
  (fuzz-beat 1))