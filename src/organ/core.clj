(ns organ.core
  (:gen-class)
  (:use overtone.live))

(definst organ [freq 440 dur 1]
  (-> freq
      saw
      (rlpf (mul-add (sin-osc 3) 300 (* freq 4)))
      (rlpf (mul-add (sin-osc 2) 400 (* freq 3)))
      (rlpf (mul-add (sin-osc 2) 200 (* freq 5)))
      (* (square 1))
      (* (env-gen (adsr 0.01 0.2 0.6) (line:kr 1 0 dur) :action FREE))
      (* 1/10)))