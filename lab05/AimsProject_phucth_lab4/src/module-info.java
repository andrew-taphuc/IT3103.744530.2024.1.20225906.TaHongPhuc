/**
 * 
 */
/**
 * 
 */
module AimsProject {
	requires java.desktop;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.swing;
	requires java.naming;
	opens hust.soict.dsai.aims.cart to javafx.fxml;
	opens hust.soict.dsai.aims.media to javafx.base;
    exports hust.soict.dsai.aims.cart;
}