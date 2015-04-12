package by.kanchanin.publications.datamodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import by.kanchanin.publications.datamodel.AbstractEntity;


import by.kanchanin.publications.datamodel.enums.UserRole;

@Entity
public class UserProfile extends AbstractEntity{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 @MapsId
	    @OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	    @JoinColumn(updatable = false, name = "id")
	    private UserAccount userAccount;
	
	@Column
	private String adress;
	
	@Column
	private Long telefone;
	
	@Column
	private Long creditCard;

    @Column
    private Date created;
    
    @Column
	 @Enumerated(EnumType.ORDINAL)
	    private UserRole role;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
	
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Long getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(Long creditCard) {
		this.creditCard = creditCard;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	public UserRole getUserRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
   

}
