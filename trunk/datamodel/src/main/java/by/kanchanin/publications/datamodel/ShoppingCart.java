package by.kanchanin.publications.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import by.kanchanin.publications.datamodel.AbstractEntity;

@Entity
public class ShoppingCart extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "periodical_id", nullable = false)
	private Periodical periodical;
	
	@MapsId
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(updatable = false, name = "id")
	private UserAccount userAccount;
	 
	public Periodical getPeriodical() {
	    return periodical;
	}
	 
	public void setPeriodical(Periodical periodical) {
	    this.periodical = periodical;
	}
	
	
	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
