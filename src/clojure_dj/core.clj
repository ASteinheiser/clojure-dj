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

(def melody
  (phrase [3/3 3/3 2/3 1/3 3/3]
          [0 0 0 1 2]))

(def track
  (->>
    melody
    (then (times 2 melody))
    (tempo (bpm 90))
    (where :pitch (comp scale/C scale/major))
    live/play))

(defn -main "Insert Beautiful Music Here." []
  (var track))