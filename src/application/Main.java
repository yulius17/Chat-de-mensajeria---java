package application;
	
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import dominio.Chat;
import dominio.Mensaje;
import dominio.Usuario;
import Repositorio.ChatRepositorio;
import Repositorio.MensajeRepositorio;
import Repositorio.UsuarioRepositorio;
import gui.Bottomdesign;
import gui.FirstGui;
import gui.Leftdesign;
import gui.Rightdesign;
import gui.SecondGui;
import gui.Topdesign;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class Main extends Application {
	UsuarioRepositorio usuarios = new UsuarioRepositorio();
	MensajeRepositorio mensajes = new MensajeRepositorio();
	ChatRepositorio chats = new ChatRepositorio();
	
    @Override
    public void start(Stage stage1) throws Exception { 	
    	FirstGui firstgui = new FirstGui();
       	firstgui.contenidoVbox1();  
    	Scene scene1 = new Scene(firstgui.anchor(), 450, 450);
    	scene1.getStylesheets().add(String.valueOf(this.getClass().getResource("application.css")));
    	stage1.setTitle("Whatsapp");
    	stage1.setScene(scene1);
    	stage1.show();  	
    	
    	firstgui.styles();
    	firstgui.getIniciar().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(usuarios.password(firstgui.getUsertext().getText(), firstgui.getClavetext().getText()) == null) {
					firstgui.notificar(firstgui.getUsertext().getText(), firstgui.getClavetext().getText());
					
					stage1.close();
					Stage stage2 = new Stage();
					Scene scene2 = new Scene(firstgui.contenidoVbox2(), 400, 200);
					scene2.getStylesheets().add(String.valueOf(this.getClass().getResource("application.css")));
					stage2.setTitle("ChatSpace");
					stage2.setScene(scene2);
					stage2.show();
					
					firstgui.getRegresar().setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent event) {
							firstgui.getUsertext().clear();
							firstgui.getClavetext().clear();
							stage2.close();
							stage1.show();
						}
					});				
				}
				
				else {
					stage1.close();
					
					SecondGui secondgui = new SecondGui(10);
					secondgui.getPanelIzq().setContent(secondgui.getVbox());
					
					Topdesign topleft = new Topdesign(firstgui.getUsertext().getText());
					topleft.styles();
					Topdesign topright = new Topdesign();
					Bottomdesign inferior = new Bottomdesign();
					inferior.styles();
					secondgui.setInferior(inferior.getHbox());
					topleft.topLeft();
					secondgui.setTopleft(topleft.getTopleft());
					secondgui.setTopright(topright.getTopright());
					secondgui.anchor1();
										
					Usuario usuario = usuarios.userName(firstgui.getUsertext().getText());
					
					int incremento = 0;
					for(Chat activos: chats.getChat(usuario.getId())) {
						Leftdesign leftdesign = new Leftdesign();
						leftdesign.styles();
						leftdesign.contenido(activos.getUsuario().getImagen(), activos.getUsuario().getNombre(), 
						activos.getMensaje().getMensaje(), activos.getMensaje().getFecha());
						
						leftdesign.leftDesign();
						leftdesign.getLeftdesign().setId(String.valueOf(activos.getUsuario().getId()));	
						
						secondgui.setLeftdesign(leftdesign.getLeftdesign());
						secondgui.getVbox().getChildren().add(secondgui.getLeftdesign());
						
						incremento = incremento + 1;

						leftdesign.getLeftdesign().addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent event) {	
								SecondGui fp = new SecondGui();	
								Usuario contacto = usuarios.userId(Integer.valueOf(leftdesign.getLeftdesign().getId()));
								
								topright.getTopright().getChildren().clear();
								topright.topRight(contacto.getId());
								
								secondgui.visible();
								secondgui.getPanelDer().setVvalue(1.0);									
							
								for(Mensaje msj: mensajes.conversaciones(usuario.getId(), contacto.getId())) {
									Rightdesign rightdesign = new Rightdesign();
									rightdesign.styles();
									
									if(msj.getUsuario1().getId() == usuario.getId()) {		
										rightdesign.messageUser(msj.getUsuario1().getImagen(), msj.getMensaje(), msj.getFecha());										
										fp.getFlowpane().getChildren().add(rightdesign.getRightdesign());
									}
									
									else {
										rightdesign.messageContact(msj.getUsuario1().getImagen(), msj.getMensaje(), msj.getFecha());
										fp.getFlowpane().getChildren().add(rightdesign.getRightdesign());	
									}

									inferior.getBoton().setOnAction(new EventHandler<ActionEvent>() {
										
										@Override
										public void handle(ActionEvent event) {
											if(!inferior.getTexto().getText().equals("")) {	
												
												DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("dd MMM, YYYY  HH:mm");
												LocalDateTime fecha = LocalDateTime.now();
												
												Rightdesign rightdesign = new Rightdesign();
												rightdesign.styles();
		
												rightdesign.messageUser(usuario.getImagen(), inferior.getTexto().getText(), fecha);

												fp.getFlowpane().getChildren().add(rightdesign.getRightdesign());
													
												leftdesign.getMensaje().setText(inferior.getTexto().getText());
												leftdesign.getDatetime().setText(datetimeformat.format(fecha));
													
												secondgui.ajusteDesplDer(fp.getFlowpane());
												
												Mensaje newMessage = new Mensaje(activos.getMensaje().getId()+1, usuario, contacto, fecha, inferior.getTexto().getText());											
												mensajes.addMensajes(newMessage);
												inferior.getTexto().clear();
												
											}
										}
									});
									
									secondgui.getPanelDer().setContent(fp.getFlowpane());
								}			
							}
						});
					}	
					
					Stage stage3 = new Stage();
					Scene scene3 = new Scene(secondgui.getAnchorPane(), 1000, 600);
					scene3.getStylesheets().add(String.valueOf(this.getClass().getResource("application.css")));
					stage3.setTitle("Chat");
					stage3.setScene(scene3);
					stage3.show();
					
					topleft.getLogout().setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent arg0) {
							firstgui.getUsertext().clear();
							firstgui.getClavetext().clear();

							stage3.close();
							stage1.show();
						}
					});
				}	
			}
		});
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
