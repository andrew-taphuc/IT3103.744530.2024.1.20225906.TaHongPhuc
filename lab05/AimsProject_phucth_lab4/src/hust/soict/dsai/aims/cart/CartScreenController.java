package hust.soict.dsai.aims.cart;

import lab04.Cart_phucth;
import hust.soict.dsai.aims.media.Media_phucth;
import hust.soict.dsai.aims.media.Playable_phucth;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart_phucth cart;
    
    @FXML
    private Button btnPlaceOrder;
    
    @FXML
    private Label totalPriceLabel;

     @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media_phucth, String> colMediaCategory;

    @FXML
    private TableColumn<Media_phucth, Float> colMediaCost;

    @FXML
    private TableColumn<Media_phucth, String> colMediaTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media_phucth> tblMedia;

     @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTtile;

    @FXML
    private TextField tfFilter;


    public CartScreenController (Cart_phucth cart) {
        super();
        this.cart = cart;
    }

    @FXML 
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media_phucth, String>("Title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media_phucth, String>("Category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media_phucth, Float>("Cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media_phucth>() {
                @Override
                public void changed(ObservableValue<? extends Media_phucth> observable, Media_phucth oldValue, Media_phucth newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    } 
                }
            });
        
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue <? extends String> observable, String oldValue, String newValue) {
                showFiterMedia(newValue);
            }
        });
        
     // Update total price initially and whenever the cart changes
        updateTotalPrice();

        // Listen for changes in the cart
        cart.getItemsOrdered().addListener(new ListChangeListener<Media_phucth>() {
        	@Override
            public void onChanged(Change<? extends Media_phucth> c) {
                updateTotalPrice();
            }
        });
     // Add action for Place Order button
        btnPlaceOrder.setOnAction(this::handlePlaceOrder);
    }
    
    @FXML
    private void handlePlaceOrder(ActionEvent event) {
        // Check if cart is not empty
        if (!cart.getItemsOrdered().isEmpty()) {
            // Clear the cart
        	cart.emptyMedia_phucth();

            // Show success notification
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Placed");
            alert.setHeaderText(null);
            alert.setContentText("Your order has been placed successfully!");
            alert.showAndWait();

            // Update total price to 0
            updateTotalPrice();
        } else {
            // Show error if cart is empty
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Cart");
            alert.setHeaderText(null);
            alert.setContentText("Your cart is empty. Please add items before placing an order.");
            alert.showAndWait();
        }
    }
    
    // New method to calculate and update total price
    private void updateTotalPrice() {
        float totalPrice = 0f;
        for (Media_phucth media : cart.getItemsOrdered()) {
            totalPrice += media.getCost();
        }
        
        // Update the total price label
        totalPriceLabel.setText(String.format("%.2f $", totalPrice));
    }
    
    void updateButtonBar(Media_phucth media) {
        btnRemove.setVisible(true);
        if(media instanceof Playable_phucth) btnPlay.setVisible(true);
        else btnPlay.setVisible(false);
    }

    void showFiterMedia(String s) {
        cart.searchByTitle(s);
    }

     @FXML
    void btnRemovePressed(ActionEvent event) {
    	 Media_phucth media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia_phucth(media);
    }
}
