package br.com.bpss.hg.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TTA401_USUARIO")
public class Usuario extends GenericDomain implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_USUARIO")
	private String cdUsuario;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DIRETORIO")
	private String diretorio;

	@Column(name = "CD_USUARIO_MANUTENCAO")
	private String cdUsuarioManutencao;

	@Column(name = "DH_SYS_MANUTENCAO")
	private Timestamp dhSysManutencao;

	@Column(name = "FL_STATUS")
	private String flStatus;

	@Column(name = "FK_ID_GRUPO")
	private Integer fkIdGrupo;

	@Column(name = "FL_ADM_SISTEMA")
	private Integer flAdmSistema;

	@Column(name = "NM_SENHA_USUARIO")
	private String nmSenhaUsuario;

	@Column(name = "NM_SENHA_PADRAO")
	private String nmSenhaPadrao;

	public String getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(String cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiretorio() {
		return diretorio;
	}

	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

	public String getCdUsuarioManutencao() {
		return cdUsuarioManutencao;
	}

	public void setCdUsuarioManutencao(String cdUsuarioManutencao) {
		this.cdUsuarioManutencao = cdUsuarioManutencao;
	}

	public Timestamp getDhSysManutencao() {
		return dhSysManutencao;
	}

	public void setDhSysManutencao(Timestamp dhSysManutencao) {
		this.dhSysManutencao = dhSysManutencao;
	}

	public String getFlStatus() {
		return flStatus;
	}

	public void setFlStatus(String flStatus) {
		this.flStatus = flStatus;
	}

	public Integer getFkIdGrupo() {
		return fkIdGrupo;
	}

	public void setFkIdGrupo(Integer fkIdGrupo) {
		this.fkIdGrupo = fkIdGrupo;
	}

	public Integer getFlAdmSistema() {
		return flAdmSistema;
	}

	public void setFlAdmSistema(Integer flAdmSistema) {
		this.flAdmSistema = flAdmSistema;
	}

	public String getNmSenhaUsuario() {
		return nmSenhaUsuario;
	}

	public void setNmSenhaUsuario(String nmSenhaUsuario) {
		this.nmSenhaUsuario = nmSenhaUsuario;
	}

	public String getNmSenhaPadrao() {
		return nmSenhaPadrao;
	}

	public void setNmSenhaPadrao(String nmSenhaPadrao) {
		this.nmSenhaPadrao = nmSenhaPadrao;
	}

	public Usuario getClone() {
		try {
			return (Usuario) this.clone();
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
