package by.kanchanin.publications.datamodel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import by.kanchanin.publications.datamodel.AbstractEntity;
import by.kanchanin.publications.datamodel.enums.OrderStatus;


@Entity
public class OrderResult extends AbstractEntity{
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	 @MapsId
		@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
		@JoinColumn(updatable = false, name = "id")
		private ShoppingCart shoppingCart;
	 
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
