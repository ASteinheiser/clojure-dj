(ns bass.core
  (:gen-class)
  (:use overtone.live))

(definst bass [freq 110]
  (-> freq
      saw
      (rlpf (line:kr (* freq 10) freq 1))
      (* (env-gen (perc 0.1 0.4) :action FREE))))