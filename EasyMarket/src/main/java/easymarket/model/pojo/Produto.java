/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymarket.model.pojo;

import java.util.Date;

/**
 *
 * @author Nathalia
 */
public class Produto {
    
    private String nome;
    private String marca;
    private String fornecedor;
    private long codigoDeBarras;
    private long lote;
    private Date dataValidade;
    private String setor;
    private float precoCompra;
    private float precoVenda;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private int qtdAtual;
    private int qtdVendida;
    private boolean status;
    
    public Produto(String nome, String marca, String fornecedor, long codigoDeBarras, long lote, Date dataValidade, String setor,
            float precoCompra, float precoVenda, int estoqueMinimo, int estoqueMaximo, int qtdAtual, int qtdVendida, boolean status){
        this.nome = nome;
        this.marca = marca;
        this.fornecedor = fornecedor;
        this.codigoDeBarras = codigoDeBarras;
        this.lote = lote;
        this.dataValidade = dataValidade;
        this.setor = setor;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
        this.qtdAtual = qtdAtual;
        this.qtdVendida = qtdVendida;
        this.status = status;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the fornecedor
     */
    public String getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the codigoDeBarras
     */
    public long getCodigoDeBarras() {
        return codigoDeBarras;
    }

    /**
     * @param codigoDeBarras the codigoDeBarras to set
     */
    public void setCodigoDeBarras(long codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    /**
     * @return the lote
     */
    public long getLote() {
        return lote;
    }

    /**
     * @param lote the lote to set
     */
    public void setLote(long lote) {
        this.lote = lote;
    }

    /**
     * @return the dataValidade
     */
    public Date getDataValidade() {
        return dataValidade;
    }

    /**
     * @param dataValidade the dataValidade to set
     */
    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    /**
     * @return the setor
     */
    public String getSetor() {
        return setor;
    }

    /**
     * @param setor the setor to set
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }

    /**
     * @return the precoCompra
     */
    public float getPrecoCompra() {
        return precoCompra;
    }

    /**
     * @param precoCompra the precoCompra to set
     */
    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    /**
     * @return the precoVenda
     */
    public float getPrecoVenda() {
        return precoVenda;
    }

    /**
     * @param precoVenda the precoVenda to set
     */
    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    /**
     * @return the estoqueMinimo
     */
    public float getEstoqueMinimo() {
        return estoqueMinimo;
    }

    /**
     * @param estoqueMinimo the estoqueMinimo to set
     */
    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    /**
     * @return the estoqueMaximo
     */
    public float getEstoqueMaximo() {
        return estoqueMaximo;
    }

    /**
     * @param estoqueMaximo the estoqueMaximo to set
     */
    public void setEstoqueMaximo(int estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    /**
     * @return the qtdAtual
     */
    public int getQtdAtual() {
        return qtdAtual;
    }

    /**
     * @param qtdAtual the qtdAtual to set
     */
    public void setQtdAtual(int qtdAtual) {
        this.qtdAtual = qtdAtual;
    }

    /**
     * @return the qtdVendida
     */
    public int getQtdVendida() {
        return qtdVendida;
    }

    /**
     * @param qtdVendida the qtdVendida to set
     */
    public void setQtdVendida(int qtdVendida) {
        this.qtdVendida = qtdVendida;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
