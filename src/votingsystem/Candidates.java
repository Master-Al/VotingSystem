/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votingsystem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author ejave
 */
@Entity
@Table(name = "candidates", catalog = "shs_election", schema = "")
@NamedQueries({
    @NamedQuery(name = "Candidates.findAll", query = "SELECT c FROM Candidates c")
    , @NamedQuery(name = "Candidates.findById", query = "SELECT c FROM Candidates c WHERE c.id = :id")
    , @NamedQuery(name = "Candidates.findByCandidatename", query = "SELECT c FROM Candidates c WHERE c.candidatename = :candidatename")
    , @NamedQuery(name = "Candidates.findByDivision", query = "SELECT c FROM Candidates c WHERE c.division = :division")
    , @NamedQuery(name = "Candidates.findByPosition", query = "SELECT c FROM Candidates c WHERE c.position = :position")})
public class Candidates implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CANDIDATENAME")
    private String candidatename;
    @Column(name = "DIVISION")
    private String division;
    @Column(name = "POSITION")
    private String position;

    public Candidates() {
    }

    public Candidates(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getCandidatename() {
        return candidatename;
    }

    public void setCandidatename(String candidatename) {
        String oldCandidatename = this.candidatename;
        this.candidatename = candidatename;
        changeSupport.firePropertyChange("candidatename", oldCandidatename, candidatename);
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        String oldDivision = this.division;
        this.division = division;
        changeSupport.firePropertyChange("division", oldDivision, division);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        String oldPosition = this.position;
        this.position = position;
        changeSupport.firePropertyChange("position", oldPosition, position);
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
        if (!(object instanceof Candidates)) {
            return false;
        }
        Candidates other = (Candidates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "votingsystem.Candidates[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
