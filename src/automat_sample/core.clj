(ns automat-sample.core
  (:require 
    [clojurewerkz.neocons.rest :as nr]
    [clojurewerkz.neocons.rest.nodes :as nn]
    [clojurewerkz.neocons.rest.relationships :as nrl]
    [clj-http.client :as client]
    [automat.viz :refer (view)]
    [automat.core :as a])
  (:gen-class))

(def state
  (a/compile [1 (a/$ :complete) 2 (a/$ :processing ) 3]
              {:reducers 
               {:complete   (fn [state input] :compl)
                :processing (fn [state input] :proc)}}))

(def adv
  (partial a/advance state))

;(defn -main
;  [& args]
;  (-> nil (adv 1)(adv 2)(adv 3))) 

; neo4j
;
;(defn -main
;  [& args]
;  (let [conn  (nr/connect "http://localhost:7474/db/data/")
;        page1 (nn/create conn {:url "http://clojurewerkz.org"})
;        page2 (nn/create conn {:url "http://clojureneo4j.info"})
;        ;; a relationship that indicates that page1 links to page2
;        rel   (nrl/create conn page1 page2 :links)]
;    (println rel)))
;

(def ^:const baseurl "http://192.168.10.223:8084/v1")

(defn make-url 
  [prefix]
    (str baseurl "/" prefix ))

(defmacro defscinario 

(defn json-request
  [action url-prefix opts]
  (let 
    [fn-http 
     (cond 
       (= action :get)    client/get
       (= action :post)   client/post
       (= action :delete) client/delete
       (= action :put)    client/put
       :else nil)
     opts (if (not (contains? opts :accept)) (assoc opts :accept "json") opts )]
    (fn-http (make-url url-prefix) opts)))

(defn -main
  [& args]
  (let 
    [sa_no "SA000000006"
     res (json-request 
           :get "sas" 
           {:query-params {:sa_id sa_no}})]
    (println res)))

