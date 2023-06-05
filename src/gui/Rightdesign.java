package gui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class Rightdesign {
	
	private HBox rightdesign;
	private Circle imagen;
	private Label mensaje;
	private Label fecha;
	
	public Rightdesign() {
		rightdesign = new HBox(10);
		imagen = new Circle(25);
		mensaje = new Label();
		fecha = new Label();
		imagen.setStroke(Color.TRANSPARENT);
		imagen.setSmooth(true);
	}
	
	public HBox getRightdesign() {
		return rightdesign;
	}
	
	public void setRightdesign(HBox rightdesign) {
		this.rightdesign = rightdesign;
	}

	public Circle getImagen() {
		return imagen;
	}

	public void setImagen(Circle imagen) {
		this.imagen = imagen;
	}

	public Label getMensaje() {
		return mensaje;
	}

	public void setMensaje(Label mensaje) {
		this.mensaje = mensaje;
	}

	public Label getFecha() {
		return fecha;
	}

	public void setFecha(Label fecha) {
		this.fecha = fecha;
	}
	
	public void messageUser(String foto, String message, LocalDateTime datetime) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd MMM, YYYY  HH:mm");
		imagen.setFill(new ImagePattern(new Image(foto)));
		mensaje.setText(message);
		fecha.setText(formato.format(datetime));
		VBox vbox = new VBox(5, mensaje, fecha);
		vbox.setStyle("-fx-padding: 12px 11px 12px 11px;\r\n"
				+ "	-fx-background-color: rgba(255,255,255,0.70);\r\n"
				+ "	-fx-max-width: 350px;");
		rightdesign.setAlignment(Pos.CENTER_RIGHT);
		rightdesign.getChildren().addAll(vbox, imagen);
	}
	
	public void messageContact(String foto, String message, LocalDateTime datetime) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd MMM, YYYY  HH:mm");
		imagen.setFill(new ImagePattern(new Image(foto)));
		mensaje.setText(message);
		fecha.setText(formato.format(datetime));
		VBox vbox = new VBox(5, mensaje, fecha);
		vbox.setStyle("-fx-padding: 12px 11px 12px 11px;\r\n"
				+ "	-fx-background-color: rgba(255,255,255,0.70);\r\n"
				+ "	-fx-max-width: 350px;");
		rightdesign.setAlignment(Pos.CENTER_LEFT);
		rightdesign.getChildren().addAll(imagen, vbox);
	}
	
	public void styles() {
		rightdesign.setStyle("-fx-padding: 15px 5px 15px 5px;\r\n"
				+ "	-fx-pref-width: 693px;");
		
		mensaje.setStyle("-fx-font-family: '';\r\n"
				+ "	-fx-text-alignment: justify;\r\n"
				+ "	-fx-max-width: 350px;\r\n"
				+ "	-fx-wrap-text: true;\r\n"
				+ "	-fx-font-size: 100%");
		
		fecha.setStyle("-fx-font-family: '';\r\n"
				+ "	-fx-text-alignment: right;\r\n"
				+ "	-fx-font-size: 90%;");
	}

}
