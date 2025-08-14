import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.File;

import java.io.PrintWriter;
import javafx.scene.control.ToolBar;
import javafx.stage.FileChooser;

public class ProjetoEditorDeTextoBasico extends Application {

    @Override
    public void start (Stage palco){
        // Criação do TextArea para o editor de texto
        TextArea areaEditavel = new TextArea();

        // Botão para salvar o texto
        Button botaoSalvar = new Button("Salvar");
        botaoSalvar.setOnAction(e-> salvarTexto(areaEditavel));

        // Barra de ferramentas com o botão de salvar
        ToolBar barradeFerramentas = new ToolBar(botaoSalvar);

        // Configuração do layout principal
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(barradeFerramentas);
        borderPane.setCenter(areaEditavel);

        // Configuração da cena e do palco
        Scene cena = new Scene(borderPane, 800,600 );
        palco.setTitle("Editor de Texto Básico");
        palco.setScene(cena);
        palco.show();
    }

    private void salvarTexto(TextArea textArea){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Salvar Arquivo de Texto");
        File file = fileChooser.showSaveDialog(null);
        if (file != null){
            try (PrintWriter writer = new PrintWriter(file)){
                 writer.println(textArea.getText()); // Escreve o conteudo que o usuário digitou no arquivo
            } catch (Exception e){
                 System.out.println(e.getMessage());
            }
        }

    }

    public static void main (String [] args){
        launch(args);
    }

}
