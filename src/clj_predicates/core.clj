; This is a modified file from Clj-MiscUtil distributed by Shantanu Kumar under the Apache License, Version 2.0.
; The original source file: https://bitbucket.org/kumarshantanu/clj-miscutil/src/acfb97c662d9/src/main/clj/org/bituf/clj_miscutil.clj
(ns clj-predicates.core
  (:import (java.util Collection Map)))

(defn not-associative?      [& x] (not (apply associative?      x)))
(defn not-bound?            [& x] (not (apply bound?            x)))
(defn not-char?             [& x] (not (apply char?             x)))
(defn not-chunked-seq?      [& x] (not (apply chunked-seq?      x)))
(defn not-class?            [& x] (not (apply class?            x)))
(defn not-coll?             [& x] (not (apply coll?             x)))
(defn not-contains?         [& x] (not (apply contains?         x)))
(defn not-counted?          [& x] (not (apply counted?          x)))
(defn not-decimal?          [& x] (not (apply decimal?          x)))
(defn not-delay?            [& x] (not (apply delay?            x)))
(defn not-distinct?         [& x] (not (apply distinct?         x)))
(defn not-empty?            [& x] (not (apply empty?            x)))
(defn not-even?             [& x] (not (apply even?             x)))
(defn not-extends?          [& x] (not (apply extends?          x)))
(defn not-false?            [& x] (not (apply false?            x)))
(defn not-float?            [& x] (not (apply float?            x)))
(defn not-fn?               [& x] (not (apply fn?               x)))
(defn not-future-cancelled? [& x] (not (apply future-cancelled? x)))
(defn not-future-done?      [& x] (not (apply future-done?      x)))
(defn not-future?           [& x] (not (apply future?           x)))
(defn not-identical?        [& x] (not (apply identical?        x)))
(defn not-ifn?              [& x] (not (apply ifn?              x)))
(defn not-instance?         [& x] (not (apply instance?         x)))
(defn not-integer?          [& x] (not (apply integer?          x)))
(defn not-isa?              [& x] (not (apply isa?              x)))
(defn not-keyword?          [& x] (not (apply keyword?          x)))
(defn not-list?             [& x] (not (apply list?             x)))
(defn not-map?              [& x] (not (apply map?              x)))
(defn not-neg?              [& x] (not (apply neg?              x)))
(defn not-nil?              [& x] (not (apply nil?              x)))
(defn not-number?           [& x] (not (apply number?           x)))
(defn not-odd?              [& x] (not (apply odd?              x)))
(defn not-pos?              [& x] (not (apply pos?              x)))
(defn not-ratio?            [& x] (not (apply ratio?            x)))
(defn not-rational?         [& x] (not (apply rational?         x)))
(defn not-reversible?       [& x] (not (apply reversible?       x)))
(defn not-satisfies?        [& x] (not (apply satisfies?        x)))
(defn not-seq?              [& x] (not (apply seq?              x)))
(defn not-sequential?       [& x] (not (apply sequential?       x)))
(defn not-set?              [& x] (not (apply set?              x)))
(defn not-sorted?           [& x] (not (apply sorted?           x)))
(defn not-special-symbol?   [& x] (not (apply special-symbol?   x)))
(defn not-string?           [& x] (not (apply string?           x)))
(defn not-symbol?           [& x] (not (apply symbol?           x)))
(defn not-thread-bound?     [& x] (not (apply thread-bound?     x)))
(defn not-true?             [& x] (not (apply true?             x)))
(defn not-var?              [& x] (not (apply var?              x)))
(defn not-vector?           [& x] (not (apply vector?           x)))
(defn not-zero?             [& x] (not (apply zero?             x)))

(defn boolean?
  "Returns true if x is a boolean, false otherwise"
  [x]
  (instance? Boolean x))

(defn not-boolean?
  "Returns true if x is not a boolean, false otherwise"
  [x]
  {:post [(boolean? %)]}
  (not (boolean? x)))

(defn zeronum?
  "Safe version of zero? - returns true if n is zero, false otherwise"
  [n]
  {:post [(boolean? %)]}
  (and (number? n) (zero? n)))

(defn not-zeronum?
  "Safe version of not-zero? - returns true if n is non-zero, false otherwise"
  [n]
  {:post [(boolean? %)]}
  (and (number? n) (or (pos? n) (neg? n))))

(defn posnum?
  "Safe version of pos? - returns true if n is a positive number, false otherwise"
  [n]
  {:post [(boolean? %)]}
  (and (number? n) (pos? n)))

(defn negnum?
  "Safe version of neg? - returns true if n is a negative number, false otherwise"
  [n]
  {:post [(boolean? %)]}
  (and (number? n) (neg? n)))

(defn not-negnum?
  "Safe version of not-neg? - returns true if n is a non-negative number, false otherwise"
  [n]
  {:post [(boolean? %)]}
  (and (number? n) (or (zero? n) (pos? n))))

(defn not-posnum?
  "Safe version of not-pos? - returns true if n is a non-positive number, false otherwise"
  [n]
  {:post [(boolean? %)]}
  (and (number? n) (or (zero? n) (neg? n))))

(defn contains-val?
  "Looks for a value in a collection"
  [coll needle]
  {:pre [(coll? coll)]
   :post [(boolean? %)]}
  (cond
    (not-coll? coll) false
    (map? coll)      (.containsValue ^Map coll needle)
    :else            (.contains ^Collection coll needle)))

(defn not-contains-val?
  "Checks if coll does not contain the needle value"
  [coll needle]
  {:pre [(coll? coll)]
   :post [(boolean? %)]}
  (not (contains-val? coll needle)))

(defn contains-vals?
  "Checks if coll contains all the listed values"
  [coll & vs]
  {:pre [(coll? coll)]
   :post [(boolean? %)]}
  (every? (partial contains-val? coll) vs))

(defn not-contains-vals?
  "Checks if coll does not contain all the listed values"
  [coll & vs]
  {:pre [(coll? coll)]
   :post [(boolean? %)]}  
  (not (some (partial contains-val? coll) vs)))

(defn contains-keys? 
  "Checks if coll contains all the listed keys. Looks for values in sets"
  [coll & ks]
  {:pre [(coll? coll)]
   :post [(boolean? %)]}
  (every? (partial contains? coll) ks))

(defn not-contains-keys? 
  "Checks if coll does not contain all the listed keys. Looks for values in sets"
  [coll & ks]
  {:pre [(coll? coll)]
   :post [(boolean? %)]}
  (not (some (partial contains? coll) ks)))

(defn contains-meta? 
  "Checks if x contains all the listed keys in its meta map"
  [x & ks]
  {:post [(boolean? %)]}
  (every? (partial contains? (meta x)) ks))

(defn not-contains-meta? 
  "Checks if x does not contain all the listed keys in its meta map"
  [x & ks]
  {:post [(boolean? %)]}
  (not (some (partial contains? (meta x)) ks)))

(defn every-contains-keys? 
  "Checks if every item in coll contains all the listed keys"
  [coll & ks]
  {:pre [(coll? coll)]
   :post [(boolean? %)]}
  (every? #(apply contains-keys? % ks) coll))

(defn every-contains-meta? 
  "Checks if every item in coll contains all the listed keys in its meta map"
  [coll & ks]  
  {:pre [(coll? coll)]
   :post [(boolean? %)]}
  (every? #(apply contains-meta? % ks) coll))