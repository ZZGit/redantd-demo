(ns redantd-demo.form
  (:require
   [redantd.core :as ad]))

(defn index []
  (ad/card
   (ad/create-form
    (fn [{:keys [form]}]
      (ad/form
       {:labelCol {:span 6}
        :wrapperCol {:span 14}
        :onSubmit #((.preventDefault %)
                    (ad/validate-fields-and-scroll
                     form
                     (fn [err vals]
                       (prn err vals))))}
       (ad/form-item
        {:label "Plain Text"}
        [:span "ant-form-text"])
       (ad/form-item
        {:label "Select"
         :hasFeedback true}
        (ad/get-field-decorator
         "select"
         {:rules [{:required true
                   :message "Please select your country!"}]}
         (ad/select
          {:placeholder "Please select a country"}
          (ad/select-option
           {:value "china"}
           "China")
          (ad/select-option
           {:value "usa"}
           "U.S.A"))))
       (ad/form-item
        {:label "Select[multiple]"}
        (ad/get-field-decorator
         "select-multiple"
         {:rules [{:required true
                   :message "Please select your country!"
                   :type "array"}]}
         (ad/select
          {:mode "multiple"
           :placeholder "Please select favourite colors"}
          (ad/select-option {:value "red"} "Red")
          (ad/select-option {:value "green"} "Green")
          (ad/select-option {:value "blue"} "Blue"))))
       (ad/form-item
        {:label "InputNumber"}
        (ad/get-field-decorator
         "input-number"
         {:initialValue 3}
         (ad/input-number
          {:min 1
           :max 10})))
       (ad/form-item
        {:label "Switch"}
        (ad/get-field-decorator
         "switch"
         {:valuePropName "checked"}
         (ad/switch)))
       (ad/form-item
        {:label "Slider"}
        (ad/get-field-decorator
         "slider"
         (ad/slider
          {:marks {0 "A" 20 "B" 40 "C" 60 "D"}})))
       (ad/form-item
        {:label "Radio.Group"}
        (ad/get-field-decorator
         "radio-group"
         (ad/radio-group
          (ad/radio {:value "a"} "itme 1")
          (ad/radio {:value "b"} "itme 2")
          (ad/radio {:value "c"} "itme 3"))))
       (ad/form-item
        {:label "Radio.Button"}
        (ad/get-field-decorator
         "radio-button"
         (ad/radio-group
          (ad/radio-button {:value "a"} "itme 1")
          (ad/radio-button {:value "b"} "itme 2")
          (ad/radio-button {:value "c"} "itme 3"))))
       (ad/form-item
        {:label "Checkbox.Group"}
        (ad/get-field-decorator
         "checkbox-group"
         {:initialValue ["A" "B"]}
         (ad/checkbox-group
          (ad/row
           (ad/col
            {:span 8}
            (ad/checkbox {:value "A"} "A"))
           (ad/col
            {:span 8}
            (ad/checkbox {:value "B"} "B"))
           (ad/col
            {:span 8}
            (ad/checkbox {:value "C"} "C"))
           (ad/col
            {:span 8}
            (ad/checkbox {:value "D"} "D"))
           (ad/col
            {:span 8}
            (ad/checkbox {:value "E"} "E"))))))
       (ad/form-item
        {:label "Rate"}
        (ad/get-field-decorator
         "rate"
         {:initialValue 3.5}
         (ad/rate)))
       (ad/form-item
        {:label "Upload"
         :extra "longgggggggggggggggggggggggggggggggggg"}
        (ad/get-field-decorator
         "upload"
         {:valuePropName "fileList"
          :getValueFromEvent (fn [e]
                               (let [props (js->clj e :keywordize-keys true)]
                                 (clj->js (:fileList props))))}
         (ad/upload
          {:name "logo"
           :action "/upload.do"
           :listType "picture"}
          (ad/button
           (ad/icon {:type "upload"})
           "Click to upload"))))
       (ad/form-item
        {:wrapperCol {:span 12 :offset 6}}
        (ad/button
         {:type "primary"
          :htmlType "submit"}
         "Submit")))))))
