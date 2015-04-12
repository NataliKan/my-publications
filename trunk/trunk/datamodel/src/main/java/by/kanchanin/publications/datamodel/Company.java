package by.kanchanin.publications.datamodel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import by.kanchanin.publications.datamodel.AbstractEntity;

@Entity
public class Company extends AbstractEntity{
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column
	    private String companyName;
	    
	    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	    @JoinColumn(name = "periodical_id", nullable = false)
	    private Periodical periodical;
	     
	    public Periodical getPeriodical() {
	        return periodical;
	    }
	     
	    public void setPeriodical(Periodical periodical) {
	        this.periodical = periodical;
	    }
	    
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }
	    
	    public String getCompanyName() {
	        return companyName;
	    }

	    public void setCompanyName(String companyName) {
	        this.companyName = companyName;
	    }


}
