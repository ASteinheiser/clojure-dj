(ns clojure-dj.core
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

(definst kick [freq 50 env-ratio 3 freq-decay 0.02 amp-decay 0.5]
  (let [fenv (* (env-gen (envelope [env-ratio 1] [freq-decay] :exp)) freq)
        aenv (env-gen (perc 0.005 amp-decay) :action FREE)]
    (* (sin-osc fenv (* 0.5 Math/PI)) aenv)))

(defn chord-progression-beat [m beat-num]
  (at (m (+ 1 beat-num)) (play-chord (chord :C4 :major)))
  (at (m (+ 5 beat-num)) (play-chord (chord :G3 :major)))
  (at (m (+ 8 beat-num)) (play-chord (chord :A3 :minor)))
  (at (m (+ 13 beat-num)) (play-chord (chord :F3 :major)))
  (apply-at (m (+ 16 beat-num)) chord-progression-beat m (+ 16 beat-num) []))

(defn drum-beat [m beat-num]
  (at (m (+ 1 beat-num)) (kick))
  (at (m (+ 3 beat-num)) (kick))
  (at (m (+ 5 beat-num)) (kick))
  (at (m (+ 6 beat-num)) (kick))
  (at (m (+ 6.5 beat-num)) (kick))
  (at (m (+ 6.75 beat-num)) (kick))
  (at (m (+ 7 beat-num)) (kick))
  (at (m (+ 9 beat-num)) (kick))
  (at (m (+ 10 beat-num)) (kick))
  (at (m (+ 10.5 beat-num)) (kick))
  (at (m (+ 10.75 beat-num)) (kick))
  (at (m (+ 11 beat-num)) (kick))
  (at (m (+ 13 beat-num)) (kick))
  (at (m (+ 15 beat-num)) (kick))
  (apply-at (m (+ 16 beat-num)) drum-beat m (+ 16 beat-num) []))

(defonce metro (metronome 120))

(defn -main
  "Insert Beautiful Music Here."
  [& args]
  (chord-progression-beat metro (metro))
  (drum-beat metro (metro)))