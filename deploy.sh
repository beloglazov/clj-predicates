#!/bin/sh
lein clean, jar, pom
scp pom.xml clj-predicates-$1.jar clojars@clojars.org:
rm clj-predicates-$1.jar
