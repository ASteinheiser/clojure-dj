(defproject clojure-dj "0.1.0"
  :description "Epic music"
  :url "https://iamandrew.io"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [
    [org.clojure/clojure "1.8.0"]
    [overtone/overtone "0.10.3"]
    [leipzig "0.10.0"]
  ]
  :source-paths ["src"]
  :native-path "%s/native"
  :target-path "target"
  :compile-path "%s/aot-files"
  :main clojure-dj.core
  :profiles {:uberjar {:aot :all}})