/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pawel
 */
@Entity
@Table(name = "CHATUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chatuser.findAll", query = "SELECT c FROM Chatuser c"),
    @NamedQuery(name = "Chatuser.findByName", query = "SELECT c FROM Chatuser c WHERE c.name = :name"),
    @NamedQuery(name = "Chatuser.findByStatus", query = "SELECT c FROM Chatuser c WHERE c.status = :status")})
public class Chatuser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NAME")
    private String name;
    @Column(name = "STATUS")
    private Boolean status;

    public Chatuser() {
    }

    public Chatuser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chatuser)) {
            return false;
        }
        Chatuser other = (Chatuser) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Chatuser[ name=" + name + " ]";
    }
    
}
