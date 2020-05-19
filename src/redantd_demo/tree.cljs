(ns redantd-demo.tree
  (:require
   [redantd.core :as ant]))

(def data [{:title "0-0",
            :key "0-0",
            :children
            [{:title "0-0-0",
              :key "0-0-0",
              :children
              [{:title "0-0-0-0", :key "0-0-0-0"}
               {:title "0-0-0-1", :key "0-0-0-1"}
               {:title "0-0-0-2", :key "0-0-0-2"}]}
             {:title "0-0-1",
              :key "0-0-1",
              :children
              [{:title "0-0-1-0", :key "0-0-1-0"}
               {:title "0-0-1-1", :key "0-0-1-1"}
               {:title "0-0-1-2", :key "0-0-1-2"}]}
             {:title "0-0-2", :key "0-0-2"}]}
           {:title "0-1",
            :key "0-1",
            :children
            [{:title "0-1-0-0", :key "0-1-0-0"}
             {:title "0-1-0-1", :key "0-1-0-1"}
             {:title "0-1-0-2", :key "0-1-0-2"}]}
           {:title "0-2", :key "0-2"}])

(defn index []
  (ant/card
   (ant/row
    (ant/col
     {:span 12}
     (ant/tree
      {:checkable true}
      (ant/tree-tree-node
       {:title "parent 1"
        :key "0-0"}
       (ant/tree-tree-node
        {:title "parent 1-0"
         :key "0-0-0"
         :disabled true}
        (ant/tree-tree-node
         {:title "leaf"
          :key "0-0-0-0"})
        (ant/tree-tree-node
         {:title "leaf"
          :key "0-0-0-1"
          :disabled true}))
       (ant/tree-tree-node
        {:title "parent 1-1"
         :key "0-0-0"
         :disabled true}
        (ant/tree-tree-node
         {:title [:span {:style {:color "#1890ff"}} "sss"]
          :key "0-0-1-0"}))))))))
