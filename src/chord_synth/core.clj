(ns chord_synth.core
  (:gen-class)
  (:use overtone.live))

(definst saw-wave [freq 440 attack 0.01 sustain 0.4 release 0.1 vol 0.4] 
  (* (env-gen (env-lin attack sustain release) 1 1 0 1 FREE)
     (saw freq)
     vol))

(defn saw2 [music-note]
  (saw-wave (midi->hz (note music-note))))

(defn play-chord [a-chord]
  (doseq [note a-chord] (saw2 note)))