/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package man.ng.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manng
 */
@Entity
@Table(name = "pcstore_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcstoreUsers.findAll", query = "SELECT p FROM PcstoreUsers p")
    , @NamedQuery(name = "PcstoreUsers.findById", query = "SELECT p FROM PcstoreUsers p WHERE p.id = :id")
    , @NamedQuery(name = "PcstoreUsers.findByUsername", query = "SELECT p FROM PcstoreUsers p WHERE p.username = :username")
    , @NamedQuery(name = "PcstoreUsers.findByPassword", query = "SELECT p FROM PcstoreUsers p WHERE p.password = :password")
    , @NamedQuery(name = "PcstoreUsers.findByName", query = "SELECT p FROM PcstoreUsers p WHERE p.name = :name")
    , @NamedQuery(name = "PcstoreUsers.findByEmail", query = "SELECT p FROM PcstoreUsers p WHERE p.email = :email")
    , @NamedQuery(name = "PcstoreUsers.findByDateOfBirth", query = "SELECT p FROM PcstoreUsers p WHERE p.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "PcstoreUsers.findByPrivilege", query = "SELECT p FROM PcstoreUsers p WHERE p.privilege = :privilege")})
public class PcstoreUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "username", length = 20)
    private String username;
    @Column(name = "password", length = 100)
    private String password;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "privilege", length = 10)
    private String privilege;
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<PcstoreComments> pcstoreCommentsList;
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<PcstoreBills> pcstoreBillsList;

    public PcstoreUsers() {
    }

    public PcstoreUsers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @XmlTransient
    public List<PcstoreComments> getPcstoreCommentsList() {
        return pcstoreCommentsList;
    }

    public void setPcstoreCommentsList(List<PcstoreComments> pcstoreCommentsList) {
        this.pcstoreCommentsList = pcstoreCommentsList;
    }

    @XmlTransient
    public List<PcstoreBills> getPcstoreBillsList() {
        return pcstoreBillsList;
    }

    public void setPcstoreBillsList(List<PcstoreBills> pcstoreBillsList) {
        this.pcstoreBillsList = pcstoreBillsList;
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
        if (!(object instanceof PcstoreUsers)) {
            return false;
        }
        PcstoreUsers other = (PcstoreUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.PcstoreUsers[ id=" + id + " ]";
    }
    
}
