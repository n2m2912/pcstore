/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package man.ng.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manng
 */
@Entity
@Table(name = "pcstore_vendors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcstoreVendors.findAll", query = "SELECT p FROM PcstoreVendors p")
    , @NamedQuery(name = "PcstoreVendors.findById", query = "SELECT p FROM PcstoreVendors p WHERE p.id = :id")
    , @NamedQuery(name = "PcstoreVendors.findByVendorName", query = "SELECT p FROM PcstoreVendors p WHERE p.vendorName = :vendorName")})
public class PcstoreVendors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "vendor_name", length = 50)
    private String vendorName;
    @OneToMany(mappedBy = "vendorId", fetch = FetchType.LAZY)
    private List<PcstoreProducts> pcstoreProductsList;

    public PcstoreVendors() {
    }

    public PcstoreVendors(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @XmlTransient
    public List<PcstoreProducts> getPcstoreProductsList() {
        return pcstoreProductsList;
    }

    public void setPcstoreProductsList(List<PcstoreProducts> pcstoreProductsList) {
        this.pcstoreProductsList = pcstoreProductsList;
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
        if (!(object instanceof PcstoreVendors)) {
            return false;
        }
        PcstoreVendors other = (PcstoreVendors) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.PcstoreVendors[ id=" + id + " ]";
    }
    
}
