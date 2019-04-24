(ns drums.core
  (:gen-class)
  (:use overtone.live))

(definst kick [freq 50 env-ratio 3 freq-decay 0.02 amp-decay 0.5]
  (let [fenv (* (env-gen (envelope [env-ratio 1] [freq-decay] :exp)) freq)
        aenv (env-gen (perc 0.005 amp-decay) :action FREE)]
    (* (sin-osc fenv (* 0.5 Math/PI)) aenv)))