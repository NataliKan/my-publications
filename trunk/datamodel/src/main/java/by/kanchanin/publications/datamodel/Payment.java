package by.kanchanin.publications.datamodel;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "user_id", nullable = false)
	private UserAccount userAccount;
	 
	public UserAccount getUserAccount() {
	    return userAccount;
	}
	 
	public void setUserAccount(UserAccount userAccount) {
	    this.userAccount = userAccount;
	}
	
	 @Column
	    private Date dateOfPayment;
	 
	 public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		public Date getDateOfPayment() {
			return dateOfPayment;
		}

		public void setDateOfPayment(Date dateOfPayment) {
			this.dateOfPayment = dateOfPayment;
		}
		


}
