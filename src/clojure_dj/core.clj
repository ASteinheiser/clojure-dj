(ns clojure-dj.core
  (:gen-class)
  (:use bass.core
        chord_synth.core
        drums.core)
  (:require [overtone.live :as overtone]
            [leipzig.live :as live]
            [leipzig.scale :as scale]
            [leipzig.melody :refer [all bpm is phrase tempo then times where with]]))

(defmethod live/play-note :default [{midi :pitch}]
  (-> midi overtone/midi->hz (bass)))
(defmethod live/play-note :beat [{midi :pitch}]
  (-> midi overtone/midi->hz (kick)))

(def pixel-beat
  (phrase [1/3 1/3 1/3 1/3 1/3 1/3 1/3 1/3 1/3 1/3 1/3 1/3]
          [2 2 3 2 1 0 0 1 2 2 3 2]))

(def drum-beat
  (->>
    (phrase [2/3 2/3 2/3 2/3 2/3]
            [2 2 1 0 0])
    (where :part (is :beat))))

(def track
  (->>
    (with drum-beat pixel-beat)
    (then (times 2 (with drum-beat pixel-beat)))
    (tempo (bpm 45))
    (where :pitch (comp scale/C scale/major))
    live/play))

(defn -main "Insert Beautiful Music Here." []
  (var track))