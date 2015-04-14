package by.kanchanin.publications.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import by.kanchanin.publications.datamodel.AbstractEntity;
import by.kanchanin.publications.datamodel.enums.OrderStatus;


@Entity
public class OrderResult extends AbstractEntity{
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	 @Column
	 @Enumerated(EnumType.ORDINAL)
	    private OrderStatus status;
	 
	 public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }
	    
	    public OrderStatus getStatus(OrderStatus orderStatus) {
	        return status;
	    }

	    public void setStatus(OrderStatus orderStatus) {
	        this.status = orderStatus;
	    }

}
