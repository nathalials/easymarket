/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package easymarket.model.pojo;

/**
 *
 * @author Anderson
 */
public class Venda {
    private int id_venda;
    private int qtd_total;
    private double valor_total;
    private String status;
    
    
    public Venda(double _valor_total, int _qtd_total, String _status){
        this.valor_total = _valor_total;
        this.qtd_total = _qtd_total;
        this.status = _status;
    }
    
    public Venda(){
        
    }

    public int getidVenda()
    {
        return id_venda;
    }
    
    public void setidVenda(int _idVenda) {
        this.id_venda = _idVenda;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String _status) {
        this.status = _status;
    }
    
    public double getValorTotal() {
        return this.valor_total;
    }

    public void setValorTotal(double _valor_total) {
        this.valor_total = _valor_total;
    }

    /**
     * @return the qtd_total
     */
    public int getQtd_total() {
        return qtd_total;
    }

    /**
     * @param qtd_total the qtd_total to set
     */
    public void setQtd_total(int qtd_total) {
        this.qtd_total = qtd_total;
    }
}
