package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Controller  implements Initializable{

	@FXML
	private Button a1;
	@FXML
	private Button a2;
	@FXML
	private Button a3;
	@FXML
	private Button a4;
	
	private Button[] tab = new Button[4];
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.tab[0] = a1;
		this.tab[1] = a2;
		this.tab[2] = a3;
		this.tab[3] = a4;
		for(int i=0; i<4; i++) {
				tab[i].setText("0");
		}
	}
	
	public void updateVue() {
	}

}
