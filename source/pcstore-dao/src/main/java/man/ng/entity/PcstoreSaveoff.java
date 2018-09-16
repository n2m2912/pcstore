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
@Table(name = "pcstore_saveoff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcstoreSaveoff.findAll", query = "SELECT p FROM PcstoreSaveoff p")
    , @NamedQuery(name = "PcstoreSaveoff.findById", query = "SELECT p FROM PcstoreSaveoff p WHERE p.id = :id")
    , @NamedQuery(name = "PcstoreSaveoff.findByDiscount", query = "SELECT p FROM PcstoreSaveoff p WHERE p.discount = :discount")
    , @NamedQuery(name = "PcstoreSaveoff.findByDiscountDate", query = "SELECT p FROM PcstoreSaveoff p WHERE p.discountDate = :discountDate")})
public class PcstoreSaveoff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "discount")
    private Integer discount;
    @Column(name = "discount_date")
    @Temporal(TemporalType.DATE)
    private Date discountDate;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PcstoreProducts productId;

    public PcstoreSaveoff() {
    }

    public PcstoreSaveoff(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Date getDiscountDate() {
        return discountDate;
    }

    public void setDiscountDate(Date discountDate) {
        this.discountDate = discountDate;
    }

    public PcstoreProducts getProductId() {
        return productId;
    }

    public void setProductId(PcstoreProducts productId) {
        this.productId = productId;
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
        if (!(object instanceof PcstoreSaveoff)) {
            return false;
        }
        PcstoreSaveoff other = (PcstoreSaveoff) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.PcstoreSaveoff[ id=" + id + " ]";
    }
    
}
