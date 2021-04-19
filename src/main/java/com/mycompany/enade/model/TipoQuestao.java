/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pichau
 */
@Entity
@Table(name = "TipoQuestao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoQuestao.findAll", query = "SELECT t FROM TipoQuestao t"),
    @NamedQuery(name = "TipoQuestao.findByIdTipoQuestao", query = "SELECT t FROM TipoQuestao t WHERE t.idTipoQuestao = :idTipoQuestao"),
    @NamedQuery(name = "TipoQuestao.findByNomeTipoQuestao", query = "SELECT t FROM TipoQuestao t WHERE t.nomeTipoQuestao = :nomeTipoQuestao")})
public class TipoQuestao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoQuestao")
    private Integer idTipoQuestao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeTipoQuestao")
    private String nomeTipoQuestao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoQuestaoidTipoQuestao")
    private List<Questao> questaoList;

    public TipoQuestao() {
    }

    public TipoQuestao(Integer idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    public TipoQuestao(Integer idTipoQuestao, String nomeTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
        this.nomeTipoQuestao = nomeTipoQuestao;
    }

    public Integer getIdTipoQuestao() {
        return idTipoQuestao;
    }

    public void setIdTipoQuestao(Integer idTipoQuestao) {
        this.idTipoQuestao = idTipoQuestao;
    }

    public String getNomeTipoQuestao() {
        return nomeTipoQuestao;
    }

    public void setNomeTipoQuestao(String nomeTipoQuestao) {
        this.nomeTipoQuestao = nomeTipoQuestao;
    }

    @XmlTransient
    public List<Questao> getQuestaoList() {
        return questaoList;
    }

    public void setQuestaoList(List<Questao> questaoList) {
        this.questaoList = questaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoQuestao != null ? idTipoQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoQuestao)) {
            return false;
        }
        TipoQuestao other = (TipoQuestao) object;
        if ((this.idTipoQuestao == null && other.idTipoQuestao != null) || (this.idTipoQuestao != null && !this.idTipoQuestao.equals(other.idTipoQuestao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.enade.model.TipoQuestao[ idTipoQuestao=" + idTipoQuestao + " ]";
    }
    
}
