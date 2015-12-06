(ns protocol-test.proto)

(defprotocol CoerceLong
  (->long [x] "Coerce to Long"))
