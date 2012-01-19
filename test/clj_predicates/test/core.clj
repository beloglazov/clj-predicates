(ns clj-predicates.test.core
  (:use clj-predicates.core
        midje.sweet))

(tabular
  (fact
    (boolean? ?arg) => ?expected)
  ?arg                 ?expected
  true                 true  
  false                true     
  -1                   false      
  0                    false
  1                    false 
  -1.0                 false        
  0.0                  false       
  1.0                  false
  \a                   false
  "a"                  false   
  '()                  false       
  []                   false          
  {}                   false  
  #{}                  false   
  #()                  false)

(tabular
  (fact
    (not-boolean? ?arg) => ?expected)
  ?arg                 ?expected
  true                 false  
  false                false     
  -1                   true      
  0                    true
  1                    true 
  -1.0                 true        
  0.0                  true       
  1.0                  true
  \a                   true  
  "a"                  true   
  '()                  true       
  []                   true          
  {}                   true  
  #{}                  true   
  #()                  true   
)

(tabular
  (fact
    (zeronum? ?arg) => ?expected)
  ?arg                 ?expected
  true                 false  
  false                false     
  -1                   false      
  0                    true 
  1                    false 
  -1.0                 false        
  0.0                  true       
  1.0                  false  
  \a                   false  
  "a"                  false   
  '()                  false       
  []                   false          
  {}                   false  
  #{}                  false   
  #()                  false)

(tabular
  (fact
    (not-zeronum? ?arg) => ?expected)
  ?arg                 ?expected
  true                 false  
  false                false     
  -1                   true      
  0                    false 
  1                    true 
  -1.0                 true        
  0.0                  false       
  1.0                  true  
  \a                   false  
  "a"                  false   
  '()                  false       
  []                   false          
  {}                   false  
  #{}                  false   
  #()                  false)

(tabular
  (fact
    (posnum? ?arg) => ?expected)
  ?arg                 ?expected
  true                 false  
  false                false     
  -1                   false      
  0                    false 
  1                    true 
  -1.0                 false        
  0.0                  false       
  1.0                  true  
  \a                   false  
  "a"                  false   
  '()                  false       
  []                   false          
  {}                   false  
  #{}                  false   
  #()                  false)

(tabular
  (fact
    (negnum? ?arg) => ?expected)
  ?arg                 ?expected
  true                 false  
  false                false     
  -1                   true      
  0                    false 
  1                    false 
  -1.0                 true        
  0.0                  false       
  1.0                  false  
  \a                   false  
  "a"                  false   
  '()                  false       
  []                   false          
  {}                   false  
  #{}                  false   
  #()                  false)

(tabular
  (fact
    (not-negnum? ?arg) => ?expected)
  ?arg                 ?expected
  true                 false  
  false                false     
  -1                   false      
  0                    true 
  1                    true 
  -1.0                 false        
  0.0                  true       
  1.0                  true  
  \a                   false  
  "a"                  false   
  '()                  false       
  []                   false          
  {}                   false  
  #{}                  false   
  #()                  false)

(tabular
  (fact
    (not-posnum? ?arg) => ?expected)
  ?arg                 ?expected
  true                 false  
  false                false     
  -1                   true      
  0                    true 
  1                    false 
  -1.0                 true        
  0.0                  true       
  1.0                  false  
  \a                   false  
  "a"                  false   
  '()                  false       
  []                   false          
  {}                   false  
  #{}                  false   
  #()                  false)

(tabular
  (fact
    (contains-val? ?coll ?val) => ?expected)
  ?coll            ?val   ?expected
  '(1 2 3)         1      true
  '(1 2 3)         2      true
  '(1 2 3)         3      true
  '(1 2 3)         4      false  
  [1 2 3]          1      true
  [1 2 3]          2      true
  [1 2 3]          3      true
  [1 2 3]          4      false                              
  #{1 2 3}         1      true
  #{1 2 3}         2      true
  #{1 2 3}         3      true
  #{1 2 3}         4      false
  {:a 1 :b 2 :c 3} 1      true
  {:a 1 :b 2 :c 3} 2      true
  {:a 1 :b 2 :c 3} 3      true
  {:a 1 :b 2 :c 3} 4      false
  {:a 1 :b 2 :c 3} :a     false
  {:a 1 :b 2 :c 3} :b     false
  {:a 1 :b 2 :c 3} :c     false
  {:a 1 :b 2 :c 3} :d     false)

(tabular
  (fact
    (not-contains-val? ?coll ?val) => ?expected)
  ?coll            ?val   ?expected
  '(1 2 3)         1      false
  '(1 2 3)         2      false
  '(1 2 3)         3      false
  '(1 2 3)         4      true  
  [1 2 3]          1      false
  [1 2 3]          2      false
  [1 2 3]          3      false
  [1 2 3]          4      true                              
  #{1 2 3}         1      false
  #{1 2 3}         2      false
  #{1 2 3}         3      false
  #{1 2 3}         4      true
  {:a 1 :b 2 :c 3} 1      false
  {:a 1 :b 2 :c 3} 2      false
  {:a 1 :b 2 :c 3} 3      false
  {:a 1 :b 2 :c 3} 4      true
  {:a 1 :b 2 :c 3} :a     true
  {:a 1 :b 2 :c 3} :b     true
  {:a 1 :b 2 :c 3} :c     true
  {:a 1 :b 2 :c 3} :d     true)

(tabular
  (fact
    (contains-vals? ?coll ?a ?b) => ?expected)
  ?coll            ?a     ?b        ?expected
  '(1 2 3)         1      2         true
  '(1 2 3)         2      3         true
  '(1 2 3)         3      1         true
  '(1 2 3)         4      1         false
  '(1 2 3)         1      4         false
  '(1 2 3)         2      4         false
  '(1 2 3)         3      4         false
  '(1 2 3)         4      5         false    
  [1 2 3]          1      2         true
  [1 2 3]          2      3         true
  [1 2 3]          3      1         true
  [1 2 3]          4      1         false
  [1 2 3]          1      4         false
  [1 2 3]          2      4         false
  [1 2 3]          3      4         false
  [1 2 3]          4      5         false    
  #{1 2 3}         1      2         true
  #{1 2 3}         2      3         true
  #{1 2 3}         3      1         true
  #{1 2 3}         4      1         false
  #{1 2 3}         1      4         false
  #{1 2 3}         2      4         false
  #{1 2 3}         3      4         false
  #{1 2 3}         4      5         false  
  {:a 1 :b 2 :c 3} 1      2         true
  {:a 1 :b 2 :c 3} 2      3         true
  {:a 1 :b 2 :c 3} 3      1         true
  {:a 1 :b 2 :c 3} 4      1         false
  {:a 1 :b 2 :c 3} :a     :b        false
  {:a 1 :b 2 :c 3} :b     :c        false
  {:a 1 :b 2 :c 3} :c     :a        false
  {:a 1 :b 2 :c 3} :d     :a        false
  {:a 1 :b 2 :c 3} 1      4         false
  {:a 1 :b 2 :c 3} 2      4         false
  {:a 1 :b 2 :c 3} 3      4         false
  {:a 1 :b 2 :c 3} 4      5         false
  {:a 1 :b 2 :c 3} :a     :d        false
  {:a 1 :b 2 :c 3} :b     :d        false
  {:a 1 :b 2 :c 3} :c     :d        false
  {:a 1 :b 2 :c 3} :d     :e        false)

(tabular
  (fact
    (not-contains-vals? ?coll ?a ?b) => ?expected)
  ?coll            ?a     ?b        ?expected
  '(1 2 3)         1      2         false
  '(1 2 3)         2      3         false
  '(1 2 3)         3      1         false
  '(1 2 3)         4      1         false
  '(1 2 3)         1      4         false
  '(1 2 3)         2      4         false
  '(1 2 3)         3      4         false
  '(1 2 3)         4      5         true    
  [1 2 3]          1      2         false
  [1 2 3]          2      3         false
  [1 2 3]          3      1         false
  [1 2 3]          4      1         false
  [1 2 3]          1      4         false
  [1 2 3]          2      4         false
  [1 2 3]          3      4         false
  [1 2 3]          4      5         true    
  #{1 2 3}         1      2         false
  #{1 2 3}         2      3         false
  #{1 2 3}         3      1         false
  #{1 2 3}         4      1         false
  #{1 2 3}         1      4         false
  #{1 2 3}         2      4         false
  #{1 2 3}         3      4         false
  #{1 2 3}         4      5         true  
  {:a 1 :b 2 :c 3} 1      2         false
  {:a 1 :b 2 :c 3} 2      3         false
  {:a 1 :b 2 :c 3} 3      1         false
  {:a 1 :b 2 :c 3} 4      1         false
  {:a 1 :b 2 :c 3} :a     :b        true
  {:a 1 :b 2 :c 3} :b     :c        true
  {:a 1 :b 2 :c 3} :c     :a        true
  {:a 1 :b 2 :c 3} :d     :a        true
  {:a 1 :b 2 :c 3} 1      4         false
  {:a 1 :b 2 :c 3} 2      4         false
  {:a 1 :b 2 :c 3} 3      4         false
  {:a 1 :b 2 :c 3} 4      5         true
  {:a 1 :b 2 :c 3} :a     :d        true
  {:a 1 :b 2 :c 3} :b     :d        true
  {:a 1 :b 2 :c 3} :c     :d        true
  {:a 1 :b 2 :c 3} :d     :e        true)

(tabular
  (fact
    (contains-keys? ?coll ?a ?b) => ?expected)
  ?coll            ?a     ?b        ?expected
  '(1 2 3)         1      2         false
  '(1 2 3)         2      3         false
  '(1 2 3)         3      1         false
  '(1 2 3)         4      1         false
  '(1 2 3)         1      4         false
  '(1 2 3)         2      4         false
  '(1 2 3)         3      4         false
  '(1 2 3)         4      5         false    
  [1 2 3]          1      2         true
  [1 2 3]          2      3         false
  [1 2 3]          3      1         false
  [1 2 3]          4      1         false
  [1 2 3]          1      4         false
  [1 2 3]          2      4         false
  [1 2 3]          3      4         false
  [1 2 3]          4      5         false    
  #{1 2 3}         1      2         true
  #{1 2 3}         2      3         true
  #{1 2 3}         3      1         true
  #{1 2 3}         4      1         false
  #{1 2 3}         1      4         false
  #{1 2 3}         2      4         false
  #{1 2 3}         3      4         false
  #{1 2 3}         4      5         false  
  {:a 1 :b 2 :c 3} 1      2         false
  {:a 1 :b 2 :c 3} 2      3         false
  {:a 1 :b 2 :c 3} 3      1         false
  {:a 1 :b 2 :c 3} 4      1         false
  {:a 1 :b 2 :c 3} :a     :b        true
  {:a 1 :b 2 :c 3} :b     :c        true
  {:a 1 :b 2 :c 3} :c     :a        true
  {:a 1 :b 2 :c 3} :d     :a        false
  {:a 1 :b 2 :c 3} 1      4         false
  {:a 1 :b 2 :c 3} 2      4         false
  {:a 1 :b 2 :c 3} 3      4         false
  {:a 1 :b 2 :c 3} 4      5         false
  {:a 1 :b 2 :c 3} :a     :d        false
  {:a 1 :b 2 :c 3} :b     :d        false
  {:a 1 :b 2 :c 3} :c     :d        false
  {:a 1 :b 2 :c 3} :d     :e        false)

(tabular
  (fact
    (not-contains-keys? ?coll ?a ?b) => ?expected)
  ?coll            ?a     ?b        ?expected
  '(1 2 3)         1      2         true
  '(1 2 3)         2      3         true
  '(1 2 3)         3      1         true
  '(1 2 3)         4      1         true
  '(1 2 3)         1      4         true
  '(1 2 3)         2      4         true
  '(1 2 3)         3      4         true
  '(1 2 3)         4      5         true    
  [1 2 3]          1      2         false
  [1 2 3]          2      3         false
  [1 2 3]          3      1         false
  [1 2 3]          4      1         false
  [1 2 3]          1      4         false
  [1 2 3]          2      4         false
  [1 2 3]          3      4         true
  [1 2 3]          4      5         true   
  #{1 2 3}         1      2         false
  #{1 2 3}         2      3         false
  #{1 2 3}         3      1         false
  #{1 2 3}         4      1         false
  #{1 2 3}         1      4         false
  #{1 2 3}         2      4         false
  #{1 2 3}         3      4         false
  #{1 2 3}         4      5         true  
  {:a 1 :b 2 :c 3} 1      2         true
  {:a 1 :b 2 :c 3} 2      3         true
  {:a 1 :b 2 :c 3} 3      1         true
  {:a 1 :b 2 :c 3} 4      1         true
  {:a 1 :b 2 :c 3} :a     :b        false
  {:a 1 :b 2 :c 3} :b     :c        false
  {:a 1 :b 2 :c 3} :c     :a        false
  {:a 1 :b 2 :c 3} :d     :a        false
  {:a 1 :b 2 :c 3} 1      4         true
  {:a 1 :b 2 :c 3} 2      4         true
  {:a 1 :b 2 :c 3} 3      4         true
  {:a 1 :b 2 :c 3} 4      5         true
  {:a 1 :b 2 :c 3} :a     :d        false
  {:a 1 :b 2 :c 3} :b     :d        false
  {:a 1 :b 2 :c 3} :c     :d        false
  {:a 1 :b 2 :c 3} :d     :e        true)

(tabular
  (fact
    (contains-meta? ?x ?a ?b) => ?expected)
  ?x                   ?a     ?b         ?expected
  (with-meta []
    {:a 1 :b 2 :c 3})  1      2          false
  (with-meta []
    {:a 1 :b 2 :c 3})  2      3          false
  (with-meta []
    {:a 1 :b 2 :c 3})  3      1          false
  (with-meta []
    {:a 1 :b 2 :c 3})  4      1          false
  (with-meta []
    {:a 1 :b 2 :c 3})  1      4          false
  (with-meta []
    {:a 1 :b 2 :c 3})  2      4          false
  (with-meta []
    {:a 1 :b 2 :c 3})  3      4          false
  (with-meta []
    {:a 1 :b 2 :c 3})  4      5          false
  (with-meta []
    {:a 1 :b 2 :c 3})  :a     :b         true
  (with-meta []
    {:a 1 :b 2 :c 3})  :b     :c         true
  (with-meta []
    {:a 1 :b 2 :c 3})  :c     :d         false
  (with-meta []
    {:a 1 :b 2 :c 3})  :d     :a         false
  (with-meta []
    {:a 1 :b 2 :c 3})  :a     :d         false
  (with-meta []
    {:a 1 :b 2 :c 3})  :b     :d         false
  (with-meta []
    {:a 1 :b 2 :c 3})  :c     :d         false
  (with-meta []
    {:a 1 :b 2 :c 3})  :d     :e         false)

(tabular
  (fact
    (not-contains-meta? ?x ?a ?b) => ?expected)
  ?x                   ?a    ?b          ?expected
  (with-meta []
    {:a 1 :b 2 :c 3})  1      2          true
  (with-meta []
    {:a 1 :b 2 :c 3})  2      3          true
  (with-meta []
    {:a 1 :b 2 :c 3})  3      1          true
  (with-meta []
    {:a 1 :b 2 :c 3})  4      1          true
  (with-meta []
    {:a 1 :b 2 :c 3})  1      4          true
  (with-meta []
    {:a 1 :b 2 :c 3})  2      4          true
  (with-meta []
    {:a 1 :b 2 :c 3})  3      4          true
  (with-meta []
    {:a 1 :b 2 :c 3})  4      5          true
  (with-meta []
    {:a 1 :b 2 :c 3})  :a     :b         false
  (with-meta []
    {:a 1 :b 2 :c 3})  :b     :c         false
  (with-meta []
    {:a 1 :b 2 :c 3})  :c     :d         false
  (with-meta []
    {:a 1 :b 2 :c 3})  :d     :a         false
  (with-meta []
    {:a 1 :b 2 :c 3})  :a     :d         false
  (with-meta []
    {:a 1 :b 2 :c 3})  :b     :d         false
  (with-meta []
    {:a 1 :b 2 :c 3})  :c     :d         false
  (with-meta []
    {:a 1 :b 2 :c 3})  :d     :e         true)

(tabular
  (fact
    (every-contains-keys? ?coll ?a ?b) => ?expected)
  ?coll                  ?a       ?b         ?expected
  [{:a 1 :b 2}
   {:a 3 :c 4}]          :a       :a         true
  [{:a 1 :b 2}
   {:a 3 :c 4}]          :b.      :a         false
  [{:a 1 :b 2}
   {:a 3 :c 4}]          :c       :d         false
  [{:a 1 :b 2}
   {:a 3 :c 4}]          :d       :e         false)

(tabular
  (fact
    (every-contains-meta? ?coll ?a ?b) => ?expected)
  ?coll                        ?a       ?b         ?expected
  [(with-meta [] {:a 1 :b 2})
   (with-meta [] {:a 3 :c 4})] :a       :a         true
  [(with-meta [] {:a 1 :b 2})
   (with-meta [] {:a 3 :c 4})] :b       :a         false
  [(with-meta [] {:a 1 :b 2})
   (with-meta [] {:a 3 :c 4})] :c       :d         false
  [(with-meta [] {:a 1 :b 2})
   (with-meta [] {:a 3 :c 4})] :d       :e         false)
