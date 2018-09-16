/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package man.ng.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manng
 */
@Entity
@Table(name = "pcstore_product_images")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcstoreProductImages.findAll", query = "SELECT p FROM PcstoreProductImages p")
    , @NamedQuery(name = "PcstoreProductImages.findById", query = "SELECT p FROM PcstoreProductImages p WHERE p.id = :id")})
public class PcstoreProductImages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @JoinColumn(name = "procducts_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PcstoreProducts procductsId;

    public PcstoreProductImages() {
    }

    public PcstoreProductImages(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public PcstoreProducts getProcductsId() {
        return procductsId;
    }

    public void setProcductsId(PcstoreProducts procductsId) {
        this.procductsId = procductsId;
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
        if (!(object instanceof PcstoreProductImages)) {
            return false;
        }
        PcstoreProductImages other = (PcstoreProductImages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.PcstoreProductImages[ id=" + id + " ]";
    }
    
}
