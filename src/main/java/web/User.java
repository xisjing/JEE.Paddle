package web;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

	@NotNull
	private int id;
	
	@Size(min = 2, max = 30)
	private String username;

	private String email;

    private String password;

    private Calendar birthDate;

    private boolean active;
    
    public User() {
    }

    public User(int id) {
        this(id,"","","",null);
    }

    public User(int id, String username, String email, String password,Calendar birthDate)
      {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate ;
        this.active = true;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
	        return id == ((User) obj).id;
	    }

	    @Override
	    public String toString() {
	        String date = new SimpleDateFormat("dd-MMM-yyyy ").format(birthDate.getTime());
	        return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", birthDate=" + date
	                + ", active=" + active + "]";
	    }
 

	   
	    

}
