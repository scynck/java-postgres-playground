package com.example.financeiro;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.financeiro.dao.ConnectionManager;
import com.example.financeiro.dao.TransacaoDAO;
import com.example.financeiro.model.Transacao;

public class Principal {

    public static void main(String[] args) {

        

        try(Connection conn = ConnectionManager.getConnection()){
            TransacaoDAO tD = new TransacaoDAO(conn);
            System.out.println("flag_1");
            Transacao t1 = new Transacao("Fulano", 200.00, "R$", 'd');
            System.out.println("flag_2");
            Transacao t2 = new Transacao("Beltrano", 100.00, "US$", 'r');
            System.out.println("flag_3");
            Transacao t3 = new Transacao("Fulano", 40.00, "US$", 'r');
            System.out.println("flag_4");
            Transacao t4 = new Transacao("Beltrano", 32.00, "R$", 't');
            System.out.println(t4.getCliente());
            System.out.println(t4.getValor());
            System.out.println(t4.getMoeda());
            System.out.println(t4.getTipo());

            /*tD.criarTransacao(t1);
            tD.criarTransacao(t2);
            tD.criarTransacao(t3);
            tD.criarTransacao(t4);*/
            System.out.println(tD.listarTransacao());   
            
            System.out.println(t4.filtrar("Beltrano"));


    }catch(SQLException e){
        System.err.println("Não foi póssível realizar a transaçao; Erro: " + e);
    }
        
    }



    

    
}
