(ns redantd-demo.alert
  (:require
   [redantd.core :as ant]))

(defn index []
  (ant/card
   (ant/alert
    {:type "success"
     :message "Success Tip"
     :showIcon true})
   (ant/alert
    {:type "info"
     :message "Informational"
     :showIcon true})
   (ant/alert
    {:type "warning"
     :message "Warning"
     :showIcon true})
   (ant/alert
    {:type "error"
     :message "Error"
     :showIcon true})))
