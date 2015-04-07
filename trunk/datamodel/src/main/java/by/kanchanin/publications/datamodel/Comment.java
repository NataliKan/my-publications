package by.kanchanin.publications.datamodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@Column
	private String comment;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = UserAccount.class)
	private UserAccount userAccount;
	
	@Column
	private Date dateOfComment;
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public UserAccount getUserAccount()
    {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
	public Date getDateOfComment() {
		return dateOfComment;
	}
	
	public void setDateOfComment(Date dateOfComment) {
		this.dateOfComment = dateOfComment;
	}
	

}
