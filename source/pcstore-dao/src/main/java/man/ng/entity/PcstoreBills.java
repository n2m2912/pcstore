/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package man.ng.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manng
 */
@Entity
@Table(name = "pcstore_bills")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcstoreBills.findAll", query = "SELECT p FROM PcstoreBills p")
    , @NamedQuery(name = "PcstoreBills.findById", query = "SELECT p FROM PcstoreBills p WHERE p.id = :id")
    , @NamedQuery(name = "PcstoreBills.findByAmount", query = "SELECT p FROM PcstoreBills p WHERE p.amount = :amount")
    , @NamedQuery(name = "PcstoreBills.findByBuyDate", query = "SELECT p FROM PcstoreBills p WHERE p.buyDate = :buyDate")})
public class PcstoreBills implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "buy_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date buyDate;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PcstoreProducts productId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PcstoreUsers userId;

    public PcstoreBills() {
    }

    public PcstoreBills(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public PcstoreProducts getProductId() {
        return productId;
    }

    public void setProductId(PcstoreProducts productId) {
        this.productId = productId;
    }

    public PcstoreUsers getUserId() {
        return userId;
    }

    public void setUserId(PcstoreUsers userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PcstoreBills)) {
            return false;
        }
        PcstoreBills other = (PcstoreBills) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.PcstoreBills[ id=" + id + " ]";
    }
    
}
