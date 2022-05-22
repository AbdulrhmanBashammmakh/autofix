/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jautofixapp;

/**
 *
 * @author shammakh
 */
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
// لعرض أي نوافذ التنبيه في التطبيق بدون الحاجة إلى تكرار كود كبير SpecialAlert قمنا ببناء الكلاس
public class SpecialAlert {
    
    // يمثل أي نافذة منبثقة سنعرضها في التطبيق مهما كان نوعها alert هنا قمنا بإنشاء كائن من الكلاس
    Alert alert = new Alert(AlertType.NONE);
    
    // الدالة التالية قمنا ببنائها لتحديد كل المعلومات التي نريد تمريرها للنافذة المنبثقة عند إظهارها دفعةً واحدة
    public void show(String title, String message, AlertType alertType) {
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.setAlertType(alertType);
        alert.showAndWait();
    }

    void show(String error, AlertType alertType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
