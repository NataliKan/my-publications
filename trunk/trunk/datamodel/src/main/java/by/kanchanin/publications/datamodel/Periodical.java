package by.kanchanin.publications.datamodel;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import by.kanchanin.publications.datamodel.AbstractEntity;

@Entity
public class Periodical extends AbstractEntity{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@MapsId
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(updatable = false, name = "id")
	private Company company;
	
	@Column
    private String title;
	
	@Column
    private String perType;
	
	@Column
    private Date dateOfIssue;
	
	@Column
    private BigDecimal price;
	
	@Column
	private Boolean available;
	
	 
	 
	 public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		
		public String getPerType() {
			return perType;
		
		}
		
		public void setPerType(String perType) {
			this.perType = perType;
		}
		
		public Date getDateOfIssue() {
			return dateOfIssue;
		
		}
		
		public void setDateOfIssue(Date dateOfIssue) {
			this.dateOfIssue = dateOfIssue;
			
		}
		

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public Boolean getAvailable() {
			return available;
		}

		public void setAvailable(Boolean available) {
			this.available = available;
		}
		
		public Company getCompany() {
			return company;
		}

		public void setCompany(Company company) {
			this.company = company;
		}
		
		
}
		
