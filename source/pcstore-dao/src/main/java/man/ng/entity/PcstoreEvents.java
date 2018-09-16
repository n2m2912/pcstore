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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manng
 */
@Entity
@Table(name = "pcstore_events")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcstoreEvents.findAll", query = "SELECT p FROM PcstoreEvents p")
    , @NamedQuery(name = "PcstoreEvents.findById", query = "SELECT p FROM PcstoreEvents p WHERE p.id = :id")
    , @NamedQuery(name = "PcstoreEvents.findByName", query = "SELECT p FROM PcstoreEvents p WHERE p.name = :name")})
public class PcstoreEvents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 100)
    private String name;
    @Lob
    @Column(name = "content", length = 65535)
    private String content;

    public PcstoreEvents() {
    }

    public PcstoreEvents(Integer id) {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        if (!(object instanceof PcstoreEvents)) {
            return false;
        }
        PcstoreEvents other = (PcstoreEvents) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.PcstoreEvents[ id=" + id + " ]";
    }
    
}
