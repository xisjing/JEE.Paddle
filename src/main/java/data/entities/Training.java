package data.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Training {
	
	@Id
	@GeneratedValue
    private int id;
	
	@ManyToOne
    @JoinColumn
	private User user;
	
	private Court court;
	
	private Calendar trainingDate;
	
	public Training(Court court, User user, Calendar trainingDate) {
        this.court = court;
        this.user = user;
        this.trainingDate = trainingDate;
    }
	
    public int getId(){
    	return id;
    }
    
    public User getUser() {
        return user;
    }
    
    //为什么只有User有setUser（）
    public void setUser(User user) {
        this.user = user;
    }
	
	public Court getCourt() {
		return court;
	}

	public Calendar getTrainingDate() {
		return trainingDate;
	}
	
	 @Override
	 public int hashCode() {
	        return id;
	    }

	 @Override
	  public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        return id == ((Training) obj).id;
	    }

	    @Override
	    public String toString() {
	        String time = new SimpleDateFormat("HH:00 dd-MMM-yyyy ").format(trainingDate.getTime());
	        return "Training [id=" + id + ", courtId=" + court.getId() + ", date=" + time + "]";
	    }

	}

