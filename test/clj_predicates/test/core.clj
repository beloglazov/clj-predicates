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
  ?coll                  ?val     ?expected
  '(.a. .b. .c.)         .a.      true
  '(.a. .b. .c.)         .b.      true
  '(.a. .b. .c.)         .c.      true
  '(.a. .b. .c.)         .d.      false  
  [.a. .b. .c.]          .a.      true
  [.a. .b. .c.]          .b.      true
  [.a. .b. .c.]          .c.      true
  [.a. .b. .c.]          .d.      false                              
  #{.a. .b. .c.}         .a.      true
  #{.a. .b. .c.}         .b.      true
  #{.a. .b. .c.}         .c.      true
  #{.a. .b. .c.}         .d.      false
  {:a .a. :b .b. :c .c.} .a.      true
  {:a .a. :b .b. :c .c.} .b.      true
  {:a .a. :b .b. :c .c.} .c.      true
  {:a .a. :b .b. :c .c.} .d.      false
  {:a .a. :b .b. :c .c.} :a       false
  {:a .a. :b .b. :c .c.} :b       false
  {:a .a. :b .b. :c .c.} :c       false
  {:a .a. :b .b. :c .c.} :d       false)

(tabular
  (fact
    (not-contains-val? ?coll ?val) => ?expected)
  ?coll                  ?val     ?expected
  '(.a. .b. .c.)         .a.      false
  '(.a. .b. .c.)         .b.      false
  '(.a. .b. .c.)         .c.      false
  '(.a. .b. .c.)         .d.      true  
  [.a. .b. .c.]          .a.      false
  [.a. .b. .c.]          .b.      false
  [.a. .b. .c.]          .c.      false
  [.a. .b. .c.]          .d.      true                              
  #{.a. .b. .c.}         .a.      false
  #{.a. .b. .c.}         .b.      false
  #{.a. .b. .c.}         .c.      false
  #{.a. .b. .c.}         .d.      true
  {:a .a. :b .b. :c .c.} .a.      false
  {:a .a. :b .b. :c .c.} .b.      false
  {:a .a. :b .b. :c .c.} .c.      false
  {:a .a. :b .b. :c .c.} .d.      true
  {:a .a. :b .b. :c .c.} :a       true
  {:a .a. :b .b. :c .c.} :b       true
  {:a .a. :b .b. :c .c.} :c       true
  {:a .a. :b .b. :c .c.} :d       true)

(tabular
  (fact
    (contains-vals? ?coll ?a ?b) => ?expected)
  ?coll                  ?a       ?b          ?expected
  '(.a. .b. .c.)         .a.      .b.         true
  '(.a. .b. .c.)         .b.      .c.         true
  '(.a. .b. .c.)         .c.      .a.         true
  '(.a. .b. .c.)         .d.      .a.         false
  '(.a. .b. .c.)         .a.      .d.         false
  '(.a. .b. .c.)         .b.      .d.         false
  '(.a. .b. .c.)         .c.      .d.         false
  '(.a. .b. .c.)         .d.      .e.         false    
  [.a. .b. .c.]          .a.      .b.         true
  [.a. .b. .c.]          .b.      .c.         true
  [.a. .b. .c.]          .c.      .a.         true
  [.a. .b. .c.]          .d.      .a.         false
  [.a. .b. .c.]          .a.      .d.         false
  [.a. .b. .c.]          .b.      .d.         false
  [.a. .b. .c.]          .c.      .d.         false
  [.a. .b. .c.]          .d.      .e.         false    
  #{.a. .b. .c.}         .a.      .b.         true
  #{.a. .b. .c.}         .b.      .c.         true
  #{.a. .b. .c.}         .c.      .a.         true
  #{.a. .b. .c.}         .d.      .a.         false
  #{.a. .b. .c.}         .a.      .d.         false
  #{.a. .b. .c.}         .b.      .d.         false
  #{.a. .b. .c.}         .c.      .d.         false
  #{.a. .b. .c.}         .d.      .e.         false  
  {:a .a. :b .b. :c .c.} .a.      .b.         true
  {:a .a. :b .b. :c .c.} .b.      .c.         true
  {:a .a. :b .b. :c .c.} .c.      .a.         true
  {:a .a. :b .b. :c .c.} .d.      .a.         false
  {:a .a. :b .b. :c .c.} :a       :b          false
  {:a .a. :b .b. :c .c.} :b       :c          false
  {:a .a. :b .b. :c .c.} :c       :a          false
  {:a .a. :b .b. :c .c.} :d       :a          false
  {:a .a. :b .b. :c .c.} .a.      .d.         false
  {:a .a. :b .b. :c .c.} .b.      .d.         false
  {:a .a. :b .b. :c .c.} .c.      .d.         false
  {:a .a. :b .b. :c .c.} .d.      .e.         false
  {:a .a. :b .b. :c .c.} :a       :d          false
  {:a .a. :b .b. :c .c.} :b       :d          false
  {:a .a. :b .b. :c .c.} :c       :d          false
  {:a .a. :b .b. :c .c.} :d       :e          false)

(tabular
  (fact
    (not-contains-vals? ?coll ?a ?b) => ?expected)
  ?coll                  ?a       ?b          ?expected
  '(.a. .b. .c.)         .a.      .b.         false
  '(.a. .b. .c.)         .b.      .c.         false
  '(.a. .b. .c.)         .c.      .a.         false
  '(.a. .b. .c.)         .d.      .a.         false
  '(.a. .b. .c.)         .a.      .d.         false
  '(.a. .b. .c.)         .b.      .d.         false
  '(.a. .b. .c.)         .c.      .d.         false
  '(.a. .b. .c.)         .d.      .e.         true    
  [.a. .b. .c.]          .a.      .b.         false
  [.a. .b. .c.]          .b.      .c.         false
  [.a. .b. .c.]          .c.      .a.         false
  [.a. .b. .c.]          .d.      .a.         false
  [.a. .b. .c.]          .a.      .d.         false
  [.a. .b. .c.]          .b.      .d.         false
  [.a. .b. .c.]          .c.      .d.         false
  [.a. .b. .c.]          .d.      .e.         true    
  #{.a. .b. .c.}         .a.      .b.         false
  #{.a. .b. .c.}         .b.      .c.         false
  #{.a. .b. .c.}         .c.      .a.         false
  #{.a. .b. .c.}         .d.      .a.         false
  #{.a. .b. .c.}         .a.      .d.         false
  #{.a. .b. .c.}         .b.      .d.         false
  #{.a. .b. .c.}         .c.      .d.         false
  #{.a. .b. .c.}         .d.      .e.         true  
  {:a .a. :b .b. :c .c.} .a.      .b.         false
  {:a .a. :b .b. :c .c.} .b.      .c.         false
  {:a .a. :b .b. :c .c.} .c.      .a.         false
  {:a .a. :b .b. :c .c.} .d.      .a.         false
  {:a .a. :b .b. :c .c.} :a       :b          true
  {:a .a. :b .b. :c .c.} :b       :c          true
  {:a .a. :b .b. :c .c.} :c       :a          true
  {:a .a. :b .b. :c .c.} :d       :a          true
  {:a .a. :b .b. :c .c.} .a.      .d.         false
  {:a .a. :b .b. :c .c.} .b.      .d.         false
  {:a .a. :b .b. :c .c.} .c.      .d.         false
  {:a .a. :b .b. :c .c.} .d.      .e.         true
  {:a .a. :b .b. :c .c.} :a       :d          true
  {:a .a. :b .b. :c .c.} :b       :d          true
  {:a .a. :b .b. :c .c.} :c       :d          true
  {:a .a. :b .b. :c .c.} :d       :e          true)

(tabular
  (fact
    (contains-keys? ?coll ?a ?b) => ?expected)
  ?coll                  ?a       ?b          ?expected
  '(.a. .b. .c.)         .a.      .b.         false
  '(.a. .b. .c.)         .b.      .c.         false
  '(.a. .b. .c.)         .c.      .a.         false
  '(.a. .b. .c.)         .d.      .a.         false
  '(.a. .b. .c.)         .a.      .d.         false
  '(.a. .b. .c.)         .b.      .d.         false
  '(.a. .b. .c.)         .c.      .d.         false
  '(.a. .b. .c.)         .d.      .e.         false    
  [.a. .b. .c.]          .a.      .b.         false
  [.a. .b. .c.]          .b.      .c.         false
  [.a. .b. .c.]          .c.      .a.         false
  [.a. .b. .c.]          .d.      .a.         false
  [.a. .b. .c.]          .a.      .d.         false
  [.a. .b. .c.]          .b.      .d.         false
  [.a. .b. .c.]          .c.      .d.         false
  [.a. .b. .c.]          .d.      .e.         false    
  #{.a. .b. .c.}         .a.      .b.         true
  #{.a. .b. .c.}         .b.      .c.         true
  #{.a. .b. .c.}         .c.      .a.         true
  #{.a. .b. .c.}         .d.      .a.         false
  #{.a. .b. .c.}         .a.      .d.         false
  #{.a. .b. .c.}         .b.      .d.         false
  #{.a. .b. .c.}         .c.      .d.         false
  #{.a. .b. .c.}         .d.      .e.         false  
  {:a .a. :b .b. :c .c.} .a.      .b.         false
  {:a .a. :b .b. :c .c.} .b.      .c.         false
  {:a .a. :b .b. :c .c.} .c.      .a.         false
  {:a .a. :b .b. :c .c.} .d.      .a.         false
  {:a .a. :b .b. :c .c.} :a       :b          true
  {:a .a. :b .b. :c .c.} :b       :c          true
  {:a .a. :b .b. :c .c.} :c       :a          true
  {:a .a. :b .b. :c .c.} :d       :a          false
  {:a .a. :b .b. :c .c.} .a.      .d.         false
  {:a .a. :b .b. :c .c.} .b.      .d.         false
  {:a .a. :b .b. :c .c.} .c.      .d.         false
  {:a .a. :b .b. :c .c.} .d.      .e.         false
  {:a .a. :b .b. :c .c.} :a       :d          false
  {:a .a. :b .b. :c .c.} :b       :d          false
  {:a .a. :b .b. :c .c.} :c       :d          false
  {:a .a. :b .b. :c .c.} :d       :e          false)

(tabular
  (fact
    (not-contains-keys? ?coll ?a ?b) => ?expected)
  ?coll                  ?a       ?b          ?expected
  '(.a. .b. .c.)         .a.      .b.         true
  '(.a. .b. .c.)         .b.      .c.         true
  '(.a. .b. .c.)         .c.      .a.         true
  '(.a. .b. .c.)         .d.      .a.         true
  '(.a. .b. .c.)         .a.      .d.         true
  '(.a. .b. .c.)         .b.      .d.         true
  '(.a. .b. .c.)         .c.      .d.         true
  '(.a. .b. .c.)         .d.      .e.         true    
  [.a. .b. .c.]          .a.      .b.         true
  [.a. .b. .c.]          .b.      .c.         true
  [.a. .b. .c.]          .c.      .a.         true
  [.a. .b. .c.]          .d.      .a.         true
  [.a. .b. .c.]          .a.      .d.         true
  [.a. .b. .c.]          .b.      .d.         true
  [.a. .b. .c.]          .c.      .d.         true
  [.a. .b. .c.]          .d.      .e.         true    
  #{.a. .b. .c.}         .a.      .b.         false
  #{.a. .b. .c.}         .b.      .c.         false
  #{.a. .b. .c.}         .c.      .a.         false
  #{.a. .b. .c.}         .d.      .a.         false
  #{.a. .b. .c.}         .a.      .d.         false
  #{.a. .b. .c.}         .b.      .d.         false
  #{.a. .b. .c.}         .c.      .d.         false
  #{.a. .b. .c.}         .d.      .e.         true  
  {:a .a. :b .b. :c .c.} .a.      .b.         true
  {:a .a. :b .b. :c .c.} .b.      .c.         true
  {:a .a. :b .b. :c .c.} .c.      .a.         true
  {:a .a. :b .b. :c .c.} .d.      .a.         true
  {:a .a. :b .b. :c .c.} :a       :b          false
  {:a .a. :b .b. :c .c.} :b       :c          false
  {:a .a. :b .b. :c .c.} :c       :a          false
  {:a .a. :b .b. :c .c.} :d       :a          false
  {:a .a. :b .b. :c .c.} .a.      .d.         true
  {:a .a. :b .b. :c .c.} .b.      .d.         true
  {:a .a. :b .b. :c .c.} .c.      .d.         true
  {:a .a. :b .b. :c .c.} .d.      .e.         true
  {:a .a. :b .b. :c .c.} :a       :d          false
  {:a .a. :b .b. :c .c.} :b       :d          false
  {:a .a. :b .b. :c .c.} :c       :d          false
  {:a .a. :b .b. :c .c.} :d       :e          true)

(tabular
  (fact
    (contains-meta? ?x ?a ?b) => ?expected)
  ?x                         ?a       ?b           ?expected
  (with-meta []
    {:a .a. :b .b. :c .c.})  .a.      .b.          false
  (with-meta []
    {:a .a. :b .b. :c .c.})  .b.      .c.          false
  (with-meta []
    {:a .a. :b .b. :c .c.})  .c.      .a.          false
  (with-meta []
    {:a .a. :b .b. :c .c.})  .d.      .a.          false
  (with-meta []
    {:a .a. :b .b. :c .c.})  .a.      .d.          false
  (with-meta []
    {:a .a. :b .b. :c .c.})  .b.      .d.          false
  (with-meta []
    {:a .a. :b .b. :c .c.})  .c.      .d.          false
  (with-meta []
    {:a .a. :b .b. :c .c.})  .d.      .e.          false
  (with-meta []
    {:a .a. :b .b. :c .c.})  :a       :b           true
  (with-meta []
    {:a .a. :b .b. :c .c.})  :b       :c           true
  (with-meta []
    {:a .a. :b .b. :c .c.})  :c       :d           false
  (with-meta []
    {:a .a. :b .b. :c .c.})  :d       :a           false
  (with-meta []
    {:a .a. :b .b. :c .c.})  :a       :d           false
  (with-meta []
    {:a .a. :b .b. :c .c.})  :b       :d           false
  (with-meta []
    {:a .a. :b .b. :c .c.})  :c       :d           false
  (with-meta []
    {:a .a. :b .b. :c .c.})  :d       :e           false)

(tabular
  (fact
    (not-contains-meta? ?x ?a ?b) => ?expected)
  ?x                         ?a       ?b           ?expected
  (with-meta []
    {:a .a. :b .b. :c .c.})  .a.      .b.          true
  (with-meta []
    {:a .a. :b .b. :c .c.})  .b.      .c.          true
  (with-meta []
    {:a .a. :b .b. :c .c.})  .c.      .a.          true
  (with-meta []
    {:a .a. :b .b. :c .c.})  .d.      .a.          true
  (with-meta []
    {:a .a. :b .b. :c .c.})  .a.      .d.          true
  (with-meta []
    {:a .a. :b .b. :c .c.})  .b.      .d.          true
  (with-meta []
    {:a .a. :b .b. :c .c.})  .c.      .d.          true
  (with-meta []
    {:a .a. :b .b. :c .c.})  .d.      .e.          true
  (with-meta []
    {:a .a. :b .b. :c .c.})  :a       :b           false
  (with-meta []
    {:a .a. :b .b. :c .c.})  :b       :c           false
  (with-meta []
    {:a .a. :b .b. :c .c.})  :c       :d           false
  (with-meta []
    {:a .a. :b .b. :c .c.})  :d       :a           false
  (with-meta []
    {:a .a. :b .b. :c .c.})  :a       :d           false
  (with-meta []
    {:a .a. :b .b. :c .c.})  :b       :d           false
  (with-meta []
    {:a .a. :b .b. :c .c.})  :c       :d           false
  (with-meta []
    {:a .a. :b .b. :c .c.})  :d       :e           true)

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
