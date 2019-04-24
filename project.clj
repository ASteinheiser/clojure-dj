(defproject clojure-dj "0.1.0"
  :description "Epic music"
  :url "https://iamandrew.io"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[overtone/overtone "0.10.3"]]
  :source-paths ["src"]
  :native-path "%s/native"
  :target-path "target"
  :compile-path "%s/aot-files"
  :main clojure-dj.core
  :profiles {:uberjar {:aot :all}})