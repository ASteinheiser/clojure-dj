(ns clojure-dj.core
  (use 'overtone.live))

(demo 7 (lpf (mix (saw [50 (line 100 1600 5) 101 100.5]))
             (lin-lin (lf-tri (line 2 20 5)) -1 1 400 4000)))

(def foo (synth (out 0 (pan2 (sin-osc 440)))))

(def id (foo))
(kill id)