(ns redantd-demo.table
  (:require
   [redantd.core :as ant]))

(def columns
  [{:title "Name"
    :dataIndex "name"
    :key "key"
    :render (fn [t] [:a t])}
   {:title "Age"
    :dataIndex "age"
    :key "age"}
   {:title "Address"
    :dataIndex "address"
    :key "address"}
   {:title "Tags"
    :dataIndex "tags"
    :key "name"
    :render (fn [tags]
              (map
               #(ant/tag {:color "geekblue" :key %} %)
               tags))}
   {:title "Action"
    :key "action"
    :render (fn [_ row]
              [:span
               [:a (str "Invite" (:name row))]
               (ant/divider {:type "vertical"})
               [:a "Delete"]])}])

(def data [{:key "1",
            :name "John Brown",
            :age 32,
            :address "New York No. 1 Lake Park",
            :tags ["nice" "developer"]}
           {:key "2",
            :name "Jim Green",
            :age 42,
            :address "London No. 1 Lake Park",
            :tags ["loser"]}
           {:key "3",
            :name "Joe Black",
            :age 32,
            :address "Sidney No. 1 Lake Park",
            :tags ["cool" "teacher"]}])

(defn index []
  (ant/card
   (ant/table
    {:columns columns
     :dataSource data})))
