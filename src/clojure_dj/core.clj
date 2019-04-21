(ns clojure-dj.core
  (:gen-class)
  (:use [overtone.live]))

(defn -main [& args]
  (demo (sin-osc)))