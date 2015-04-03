package by.kanchanin.publications.datamodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
