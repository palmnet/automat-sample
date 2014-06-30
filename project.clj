(defproject automat-sample "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                 [automat "0.1.2"]
                 [clj-http "0.9.2"]
                 [clojurewerkz/neocons "3.0.0"]
                 [cheshire "5.3.1"]
                 [org.clojure/clojure "1.5.1"]]
  :main ^:skip-aot automat-sample.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
