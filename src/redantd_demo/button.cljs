(ns redantd-demo.button
  (:require
   [redantd.core :as ad]
   [reagent.core :as reagent :refer [atom]]))

(defn index []
  (ad/row
   {:gutter 8}
   (ad/col
    {:span 12}
    (ad/card
     {:title "按钮类型"
      :bodyStyle
      {:display "flex"
       :justify-content "space-around"
       :flex-wrap "wrap"}}
     (ad/button
      {:type "primary"}
      "Primary")
     (ad/button "Default")
     (ad/button
      {:type "dashed"}
      "Dashed")
     (ad/button
      {:type "danger"}
      "Danger")
     (ad/button
      {:type "link"}
      "Link")))
   (ad/col
    {:span 12}
    (ad/card
     {:title "按钮图标"
      :bodyStyle
      {:display "flex"
       :justify-content "space-around"
       :flex-wrap "wrap"}}
     (ad/button
      {:type "primary"
       :shape "circle"
       :icon "search"})
     (ad/button
      {:type "primary"
       :shape "circle"}
      "A")
     (ad/button
      {:type "primary"
       :icon "search"}
      "Search")
     (ad/button
      {:type "danger"}
      "Danger")
     (ad/button
      {:type "link"}
      "Link")))))
