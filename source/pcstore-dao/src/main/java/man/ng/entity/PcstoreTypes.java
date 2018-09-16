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
@Table(name = "pcstore_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcstoreTypes.findAll", query = "SELECT p FROM PcstoreTypes p")
    , @NamedQuery(name = "PcstoreTypes.findById", query = "SELECT p FROM PcstoreTypes p WHERE p.id = :id")
    , @NamedQuery(name = "PcstoreTypes.findByName", query = "SELECT p FROM PcstoreTypes p WHERE p.name = :name")})
public class PcstoreTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 100)
    private String name;
    @OneToMany(mappedBy = "typeId", fetch = FetchType.LAZY)
    private List<PcstoreProducts> pcstoreProductsList;

    public PcstoreTypes() {
    }

    public PcstoreTypes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof PcstoreTypes)) {
            return false;
        }
        PcstoreTypes other = (PcstoreTypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.PcstoreTypes[ id=" + id + " ]";
    }
    
}
