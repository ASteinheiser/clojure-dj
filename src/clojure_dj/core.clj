(ns clojure-dj.core
  (:gen-class)
  (:use bass.core
        chord_synth.core
        drums.core)
  (:require [leipzig.live :as live]
            [leipzig.scale :as scale]
            [leipzig.temperament :as temperament]
            [leipzig.melody :refer [all bpm is phrase tempo then times where with]]))

(defmethod live/play-note :default [{hertz :pitch}] (bass hertz))
(defmethod live/play-note :beat [{hertz :pitch}] (kick hertz))

(def bass-line
  (phrase [2/4 2/4 2/4 2/4 1/4 2/4 2/4 2/4 2/4 1/4 2/4 2/4 1/4 2/4 2/4 1/4 2/4 2/4]
          [  2   2   2   3   3   3   2   2   2   1   1   0   0   0   1   1   1   2]))

(def pixel-beat
  (->>
    (phrase [2/4 2/4 2/4 2/4 2/4 6/4]
            [  4   4   3   2   2   2])
    (where :part (is :beat))))

(def end-beat
  (phrase [3/4 1/4 2/4 4/4 4/4 4/4]
          [  3   2   2   3   1   0]))

(def track
  (->>
    bass-line
    (then (times 2 (with bass-line (times 2 pixel-beat))))
    (then bass-line)
    (then end-beat)
    (tempo (bpm 90))
    (where :pitch (comp temperament/equal scale/C scale/major))
    live/play))

(defn -main "Insert Beautiful Music Here." []
  (var track))