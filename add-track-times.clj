#!/usr/bin/env bb

;; A calculator to sum all durations (mm:ss) found in an arbitrary data structure
;; Example data structure: [["Paper" "03:55"]["Santa" "04:10"]["WhatAmIOn" "02:43"]["Agua Salada" "03:47"]["Candela" "04:03"]]


(require '[clojure.edn :as edn]
         '[clojure.java.io :as io]
         '[clojure.string :as string])


(defn read-edn-file [filename]
  (with-open [reader (io/reader filename)]
    (edn/read (java.io.PushbackReader. reader))))


(def example-times (read-edn-file "records.edn"))


;; Formats a time measured in mm:ss to seconds
(defn time->seconds [time]
  (let [[m s] (mapv #(Integer/parseInt %) (string/split time #":"))]
    (+ (* m 60) s))) ; multiple first add next return the resulting number


;; Formats a time measured in seconds to one in mm:ss
(defn seconds->time [seconds]
  (let [m (quot seconds 60)
        s (mod seconds 60)]
    (str (format "%02d" m) ":" (format "%02d" s))))


(defn average [coll]
  (/ (reduce + coll) (count coll)))


(def reduced-example-times
  (mapv second example-times))


(def track-times-in-seconds
  (mapv time->seconds reduced-example-times))


(defn -main [function]
  (cond (= "help" function) (println "Available commands: average, durations-seconds, list, help, list-durations, total, total-seconds")
        
        ;; Average duration
        (= "average" function) (println (str "Average duration: " (seconds->time (int (average track-times-in-seconds)))))

        ;; List of durations in seconds
        (= "durations-seconds" function) (println (str "Duration (s): " track-times-in-seconds))

        ;; Lists all labeled records and their duration (mm:ss)
        (= "list" function) (doseq [v example-times] (println (str (get v 0) ": " (get v 1))))

        ;; Lists records duration (mm:ss)
        (= "list-durations" function) (doseq [v reduced-example-times] (println v))

        ;; Lists records labels
        (= "list-labels" function) (doseq [v example-times] (println (str (get v 0))))

        ;; Lists records with urls
        (= "list-url" function) (doseq [v example-times] (println (str (get v 0) ": " (if (nil? (get v 2)) "No URL provided" (get v 2)))))

        ;; Maximum duration
        ;; (= "max" function) (println (str "Maximum duration: " (apply max example-times)))
        
        ;; Minimum duration
        ;; (= "min" function) (println (str "Minimum duration: " (reduce (fn [acc v] (get v 1)) 0 example-times)))
        
        ;; Total duration (mm:ss)
        (= "total" function) (println (str "Total (mm:ss): " (seconds->time (reduce + track-times-in-seconds))))

        ;; Total duration (s)
        (= "total-seconds" function) (println (str "Total (s): " (reduce + track-times-in-seconds)))



        ;; More functions to follow...
        
        ;; ...
        
        (= nil function) (println "Error. You must specify a function.")

        :else (println "Invalid command. Use 'help' for the list of available commands.")))


(-main (first *command-line-args*))