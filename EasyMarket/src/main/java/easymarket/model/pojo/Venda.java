/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymarket.model.pojo;

import java.util.ArrayList;

/**
 *
 * @author nliggia-ibm
 */
public class Venda {
    
    private int idVenda;
    private int idProduto;
    private int qtdTotalVendida;
    private float precoTotalVenda;
    String dataVenda;
    ArrayList<Produto> produtosVendidos;
    
    public Venda(){
        this.produtosVendidos = new ArrayList<Produto>();
        
    }

       
  
    /**
     * @return the idVenda
     */
    public int getIdVenda() {
        return idVenda;
    }

    /**
     * @param idVenda the idVenda to set
     */
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the qtdTotalVendida
     */
    public int getQtdTotalVendida() {
        return qtdTotalVendida;
    }

    /**
     * @param qtdTotalVendida the qtdTotalVendida to set
     */
    public void setQtdTotalVendida(int qtdTotalVendida) {
        this.qtdTotalVendida = qtdTotalVendida;
    }

    /**
     * @return the precoTotalVenda
     */
    public float getPrecoTotalVenda() {
        return precoTotalVenda;
    }

    /**
     * @param precoTotalVenda the precoTotalVenda to set
     */
    public void setPrecoTotalVenda(float precoTotalVenda) {
        this.precoTotalVenda = precoTotalVenda;
    }
    
    public String getDataVenda() {
        return dataVenda;
    }
    
    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    public void adicionaProdutoVendido(Produto produto){
        produtosVendidos.add(produto);
    }
    
    public void removeProdutoVendido(Produto produto){
        produtosVendidos.remove(produto);
    }
    
}
