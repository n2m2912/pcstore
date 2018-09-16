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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "pcstore_products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcstoreProducts.findAll", query = "SELECT p FROM PcstoreProducts p")
    , @NamedQuery(name = "PcstoreProducts.findById", query = "SELECT p FROM PcstoreProducts p WHERE p.id = :id")
    , @NamedQuery(name = "PcstoreProducts.findByName", query = "SELECT p FROM PcstoreProducts p WHERE p.name = :name")
    , @NamedQuery(name = "PcstoreProducts.findByReleaseDate", query = "SELECT p FROM PcstoreProducts p WHERE p.releaseDate = :releaseDate")
    , @NamedQuery(name = "PcstoreProducts.findByPrice", query = "SELECT p FROM PcstoreProducts p WHERE p.price = :price")
    , @NamedQuery(name = "PcstoreProducts.findByDetail", query = "SELECT p FROM PcstoreProducts p WHERE p.detail = :detail")
    , @NamedQuery(name = "PcstoreProducts.findByWarranty", query = "SELECT p FROM PcstoreProducts p WHERE p.warranty = :warranty")
    , @NamedQuery(name = "PcstoreProducts.findByRate", query = "SELECT p FROM PcstoreProducts p WHERE p.rate = :rate")
    , @NamedQuery(name = "PcstoreProducts.findByQuantity", query = "SELECT p FROM PcstoreProducts p WHERE p.quantity = :quantity")})
public class PcstoreProducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price", precision = 22)
    private Double price;
    @Column(name = "detail", length = 1000)
    private String detail;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Column(name = "warranty", length = 1000)
    private String warranty;
    @Column(name = "rate")
    private Integer rate;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "vendor_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PcstoreVendors vendorId;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PcstoreTypes typeId;
    @JoinColumn(name = "list_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PcstoreList listId;
    @OneToMany(mappedBy = "procductsId", fetch = FetchType.LAZY)
    private List<PcstoreComments> pcstoreCommentsList;
    @OneToMany(mappedBy = "productId", fetch = FetchType.LAZY)
    private List<PcstoreBills> pcstoreBillsList;
    @OneToMany(mappedBy = "productId", fetch = FetchType.LAZY)
    private List<PcstoreSaveoff> pcstoreSaveoffList;
    @OneToMany(mappedBy = "procductsId", fetch = FetchType.LAZY)
    private List<PcstoreProductImages> pcstoreProductImagesList;

    public PcstoreProducts() {
    }

    public PcstoreProducts(Integer id) {
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public PcstoreVendors getVendorId() {
        return vendorId;
    }

    public void setVendorId(PcstoreVendors vendorId) {
        this.vendorId = vendorId;
    }

    public PcstoreTypes getTypeId() {
        return typeId;
    }

    public void setTypeId(PcstoreTypes typeId) {
        this.typeId = typeId;
    }

    public PcstoreList getListId() {
        return listId;
    }

    public void setListId(PcstoreList listId) {
        this.listId = listId;
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

    @XmlTransient
    public List<PcstoreSaveoff> getPcstoreSaveoffList() {
        return pcstoreSaveoffList;
    }

    public void setPcstoreSaveoffList(List<PcstoreSaveoff> pcstoreSaveoffList) {
        this.pcstoreSaveoffList = pcstoreSaveoffList;
    }

    @XmlTransient
    public List<PcstoreProductImages> getPcstoreProductImagesList() {
        return pcstoreProductImagesList;
    }

    public void setPcstoreProductImagesList(List<PcstoreProductImages> pcstoreProductImagesList) {
        this.pcstoreProductImagesList = pcstoreProductImagesList;
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
        if (!(object instanceof PcstoreProducts)) {
            return false;
        }
        PcstoreProducts other = (PcstoreProducts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.PcstoreProducts[ id=" + id + " ]";
    }
    
}
