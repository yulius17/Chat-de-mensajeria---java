package gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SecondGui {
	private HBox inferior;
	private HBox topleft;
	private HBox topright;
	private HBox rightdesign;
	private HBox leftdesign;
	private AnchorPane anchorPane;
	private ScrollPane panelIzq;
	private ScrollPane panelDer;
	private FlowPane flowpane;
	private VBox vbox;
	private VBox fondo;

	public SecondGui(int vboxspacing) {
		panelIzq = new ScrollPane();
		panelDer = new ScrollPane();		
		vbox = new VBox(vboxspacing);
		fondo = new VBox();
	
	}
	
	public SecondGui() {
		flowpane = new FlowPane();
	}

	public HBox getTopleft() {
		return topleft;
	}

	public void setTopleft(HBox topleft) {
		this.topleft = topleft;
	}

	public HBox getTopright() {
		return topright;
	}

	public void setTopright(HBox topright) {
		this.topright = topright;
	}

	public HBox getLeftdesign() {
		return leftdesign;
	}

	public void setLeftdesign(HBox leftdesign) {
		this.leftdesign = leftdesign;
	}

	public AnchorPane getAnchorPane() {
		return anchorPane;
	}

	public void setAnchorPane(AnchorPane anchorPane) {
		this.anchorPane = anchorPane;
	}

	public ScrollPane getPanelIzq() {
		return panelIzq;
	}

	public void setPanelIzq(ScrollPane panelIzq) {
		this.panelIzq = panelIzq;
	}

	public ScrollPane getPanelDer() {
		return panelDer;
	}

	public void setPanelDer(ScrollPane panelDer) {
		this.panelDer = panelDer;
	}

	public FlowPane getFlowpane() {
		return flowpane;
	}

	public void setFlowpane(FlowPane flowpane) {
		this.flowpane = flowpane;
	}

	public VBox getVbox() {
		return vbox;
	}

	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}
	
	public HBox getInferior() {
		return inferior;
	}

	public void setInferior(HBox inferior) {
		this.inferior = inferior;
	}

	public HBox getRightdesign() {
		return rightdesign;
	}

	public void setRightdesign(HBox rightdesign) {
		this.rightdesign = rightdesign;
	}
	
	public VBox getFondo() {
		return fondo;
	}

	public void setFondo(VBox fondo) {
		this.fondo = fondo;
	}

	public VBox addRightdesign(HBox [] hbox) {
		for(int m = 0; m < hbox.length; m++) {
			vbox.getChildren().add(hbox[m]);
		}
		
		return vbox;
	}

	public void anchor1() {
		panelDer.setVisible(false);
		topright.setVisible(false);
		inferior.setVisible(false);
		anchorPane = new AnchorPane(fondo, topleft, topright, panelIzq, panelDer, inferior);
		AnchorPane.setTopAnchor(topleft, 0d);
		AnchorPane.setLeftAnchor(topleft, 0d);
		AnchorPane.setRightAnchor(topleft, 705d);
		AnchorPane.setTopAnchor(topright, 0d);
		AnchorPane.setLeftAnchor(topright, 295d);
		AnchorPane.setRightAnchor(topright, 0d);
		AnchorPane.setLeftAnchor(panelIzq, 0d);
		AnchorPane.setRightAnchor(panelIzq, 705d);
		AnchorPane.setTopAnchor(panelIzq, 60d);
		AnchorPane.setBottomAnchor(panelIzq, 0d);
		AnchorPane.setLeftAnchor(panelDer, 295d);
		AnchorPane.setRightAnchor(panelDer, 0d);
		AnchorPane.setTopAnchor(panelDer, 60d);
		AnchorPane.setBottomAnchor(panelDer, 45d);
		AnchorPane.setLeftAnchor(inferior, 295d);
		AnchorPane.setRightAnchor(inferior, 0d);
		AnchorPane.setBottomAnchor(inferior, 0d);
		AnchorPane.setLeftAnchor(fondo, 295d);
		AnchorPane.setRightAnchor(fondo, 0d);
		AnchorPane.setTopAnchor(fondo, 0d);
		AnchorPane.setBottomAnchor(fondo, 0d);
	}
	
	public void visible() {
		panelDer.setVisible(true);
		topright.setVisible(true);
		inferior.setVisible(true);
		fondo.setVisible(false);
	}
	
	public void ajusteDesplDer(FlowPane fp) {
		fp.heightProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<?> observable, Object oldvalue, Object newValue) {	
				panelDer.setVvalue((double)newValue);	
			}

		});
	}
	
}
