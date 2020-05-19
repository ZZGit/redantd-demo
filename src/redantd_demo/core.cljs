(ns redantd-demo.core
  (:require
   [redantd.core :as ad]
   [reagent.core :as reagent :refer [atom]]
   [redantd-demo.form :as form]
   [redantd-demo.button :as button]
   [redantd-demo.table :as table]
   [redantd-demo.tree :as tree]
   [redantd-demo.alert :as alert]))

(def menu-key (atom :tree))
(def collapsed (atom false))

(defn main []
  (ad/layout
   (ad/layout-sider
    {:trigger nil
     :collapsible true
     :collapsed @collapsed
     :style {:min-height "100vh"}}
    [:div.logo
     [:a
      [:img {:src "/assets/logo.svg"}]
      [:h1 "RedAntd"]]]
    (ad/menu
     {:theme "dark"
      :mode "inline"
      :selectedKeys [(str @menu-key)]
      :onClick #(reset! menu-key (:key %))}
     (ad/menu-sub-menu
      {:title "通用"}
      (ad/menu-item
       {:key :button}
       "Button 按钮"))
     (ad/menu-sub-menu
      {:title "数据录入"}
      (ad/menu-item
       {:key :form}
       "Form 表单"))
     (ad/menu-sub-menu
      {:title "数据展示"}
      (ad/menu-item
       {:key :table}
       "Table 表格")
      (ad/menu-item
       {:key :tree}
       "Tree 树形控件"))
     (ad/menu-sub-menu
      {:title "反馈"}
      (ad/menu-item
       {:key :alert}
       "Alert警告提示")
      (ad/menu-item
       {:key :modal}
       "Modal对话框")
      (ad/menu-item
       {:key :message}
       "Message全局提示")
      (ad/menu-item
       {:key :notification}
       "Notification通知提醒框"))))
   (ad/layout
    (ad/layout-header
     {:style {:background "#fff"
              :padding 0}}
     (ad/icon
      {:className "trigger"
       :type (if @collapsed "menu-unfold" "menu-fold")
       :onClick #(swap! collapsed not)}))
    (ad/layout-content
     {:style {:padding 10}}
     (case (keyword @menu-key)
       :button [button/index]
       :form [form/index]
       :table [table/index]
       :tree [tree/index]
       :alert [alert/index]
       [:div "无"]))
    (ad/layout-footer
     {:style {:text-align "center"}}
     "Ant Design ©2018 Created by Ant UED"))))

(defn start []
  (reagent/render-component [main]
                            (. js/document (getElementById "app"))))

(defn ^:export init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (start))

(defn stop []
  ;; stop is called before any code is reloaded
  ;; this is controlled by :before-load in the config
  (js/console.log "stop"))
