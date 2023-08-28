package com.example;

import java.sql.DriverManager;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML TextField txtAnotacao;
    @FXML ListView<Anotacao> lista; 
    
    ArrayList<Anotacao> notas = new ArrayList<>();

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = "RM97898";
    private static final String PASS = "210904";
    
    @FXML 
    private void adicionar(){

        String descricao_anotacao = txtAnotacao.getText();
        var anotacao = new Anotacao(descricao_anotacao);
z
        try {
            var conexao = DriverManager.getConnection(URL, USER, PASS);

            var sql = "INSERT INTO TBL_ANOTACOES_RM97898 (DESCRICAO_ANOTACAO) VALUES (?)";
            var comando = conexao.prepareStatement(sql);
            comando.setString(1, anotacao.getDescricao_anotacao());

            comando.executeUpdate();

            Alert alertaErro = new Alert (AlertType.INFORMATION);
            alertaErro.setTitle("Sucesso.");
            alertaErro.setContentText("Nota inserida com sucesso");
            alertaErro.show();

            conexao.close();
        } catch (Exception erro) {
            Alert alertaErro = new Alert (AlertType.ERROR);
            alertaErro.setTitle("Erro ao conectar.");
            alertaErro.setContentText(erro.getLocalizedMessage());
            alertaErro.show();
        }
        notas.add(anotacao);
        mostrarAnotacoes();
    }

    public void mostrarAnotacoes(){
        lista.getItems().clear();
        for(var anotacao : notas){
            lista.getItems().add(anotacao);
        }
    }
}
