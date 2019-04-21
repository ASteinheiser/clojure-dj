(defproject clojure-dj "0.1.0-SNAPSHOT"
  :description "Epic music"
  :url "https://iamandrew.io"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [
    [org.clojure/clojure "1.8.0"]
    [overtone "0.10.3"]
  ]
  :repl-options {:init-ns clojure-dj.core}
  :profiles {:uberjar {:aot :all}}
  :main clojure-dj.core
  :aot [clojure-dj.core])
