(ns protocol-test.impl
  (:require [protocol-test.proto :as p]))

(extend-protocol p/CoerceLong
  Object
  (->long [obj] (p/->long (str obj)))

  String
  (->long [str] (Long/parseLong str 10))

  protocol_test.type.Money
  (->long [money] (:value money))

  nil
  (->long [x] 0))
