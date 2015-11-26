/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package easymarket.model.pojo;

/**
 *
 * @author Ander
 */
public class Venda_Produtos {
    private int id_venda;
    private int id_produto;
    private int qtd_vendida;
    private double valor_venda;
    
    public void Venda_Produtos(int _id_venda, int _id_produto, int _qtd_vendida, double _valor_venda){
        this.id_venda = _id_venda;
        this.id_produto = _id_produto;
        this.setQtd_vendida(_qtd_vendida);
        this.setValor_venda(_valor_venda);
    }

    
    public Venda_Produtos(){
        
    }
    public int getidVenda()
    {
        return id_venda;
    }
    
    public void setidVenda(int _idVenda) {
        this.id_venda = _idVenda;
    }
    public int getId_Produto() {
        return this.id_produto;
    }

    public void setId_produto(int _id_produto) {
        this.id_produto = _id_produto;
    }

    /**
     * @return the qtd_vendida
     */
    public int getQtd_vendida() {
        return qtd_vendida;
    }

    /**
     * @param qtd_vendida the qtd_vendida to set
     */
    public void setQtd_vendida(int qtd_vendida) {
        this.qtd_vendida = qtd_vendida;
    }

    /**
     * @return the valor_venda
     */
    public double getValor_venda() {
        return valor_venda;
    }

    /**
     * @param valor_venda the valor_venda to set
     */
    public void setValor_venda(double valor_venda) {
        this.valor_venda = valor_venda;
    }
}
