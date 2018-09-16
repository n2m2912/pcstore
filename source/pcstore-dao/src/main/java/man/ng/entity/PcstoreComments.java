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
@Table(name = "pcstore_comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcstoreComments.findAll", query = "SELECT p FROM PcstoreComments p")
    , @NamedQuery(name = "PcstoreComments.findById", query = "SELECT p FROM PcstoreComments p WHERE p.id = :id")
    , @NamedQuery(name = "PcstoreComments.findByCommentTime", query = "SELECT p FROM PcstoreComments p WHERE p.commentTime = :commentTime")})
public class PcstoreComments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "comment_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentTime;
    @JoinColumn(name = "procducts_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PcstoreProducts procductsId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PcstoreUsers userId;

    public PcstoreComments() {
    }

    public PcstoreComments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public PcstoreProducts getProcductsId() {
        return procductsId;
    }

    public void setProcductsId(PcstoreProducts procductsId) {
        this.procductsId = procductsId;
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
        if (!(object instanceof PcstoreComments)) {
            return false;
        }
        PcstoreComments other = (PcstoreComments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.PcstoreComments[ id=" + id + " ]";
    }
    
}
