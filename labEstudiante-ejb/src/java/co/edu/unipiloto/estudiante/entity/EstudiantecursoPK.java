/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.estudiante.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dlpol
 */
@Embeddable
public class EstudiantecursoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_CURSO")
    private int codigoCurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ESTUDIANTE")
    private int idEstudiante;

    public EstudiantecursoPK() {
    }

    public EstudiantecursoPK(int codigoCurso, int idEstudiante) {
        this.codigoCurso = codigoCurso;
        this.idEstudiante = idEstudiante;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoCurso;
        hash += (int) idEstudiante;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudiantecursoPK)) {
            return false;
        }
        EstudiantecursoPK other = (EstudiantecursoPK) object;
        if (this.codigoCurso != other.codigoCurso) {
            return false;
        }
        if (this.idEstudiante != other.idEstudiante) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.estudiante.entity.EstudiantecursoPK[ codigoCurso=" + codigoCurso + ", idEstudiante=" + idEstudiante + " ]";
    }
    
}
