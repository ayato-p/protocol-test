(ns protocol-test.core
  (:require [protocol-test.impl]
            [protocol-test.proto :as p]
            [protocol-test.type :as t]))

(deftype StringLength [^String s]
  Object
  (toString [self]
    (str (count s))))

;;; test

(let [obj (StringLength. "Hello, world")
      money (t/map->Money {:value 100 :currency "jpy"})]

  (println "obj->long: " (p/->long obj)) ;; 12
  (println "str->long: " (p/->long "123")) ;; 123
  (println "record->long: " (p/->long money)) ;; 100
  (println "nil->long: " (p/->long nil)) ;; 0
  )
