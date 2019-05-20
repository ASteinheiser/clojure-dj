# clojure-dj

A clojure app, made with overtone and leipzig, designed to make _(good?)_ music. I'm not a musician.

## Run Locally
```
lein deps
lein run
```
#### or
```
lein repl
=> (use 'clojure-dj.core :reload)
```

## Build & Distribute App
```
lein uberjar
java -jar target/clojure-dj-0.1.0-standalone.jar
```