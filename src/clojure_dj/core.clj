(ns clojure-dj.core
  (:gen-class)
  (:use overtone.live))

(defn -main [& args]
  (let [env (envelope [0 1] [2] :sqr)]
    (demo (sin-osc :freq (+ 200 (* 200 (env-gen env :action FREE)))))))