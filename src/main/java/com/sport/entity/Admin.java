package com.sport.entity;


	
	import java.io.Serializable;

	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

	@Entity
	//@SequenceGenerator(name = "Adminsequence", initialValue = 100)
	@PrimaryKeyJoinColumn(name="admin_id")
	public class Admin extends UserEntity  {
		
		/**
		 * 
		 */
		//private static final long serialVersionUID = -535712062774093171L;
//		@Id
//		@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "Cardsequence")
//		private Long id;
		
		/*
		 * @OneToMany(targetEntity = Customer.class,cascade=CascadeType.ALL,mappedBy =
		 * "admin")
		 * 
		 * @JsonManagedReference(value = "5") List<Customer> customer=new ArrayList<>();
		 */
		
		/*
		 * @OneToMany private GasBooking gasBooking;
		 */

		
		public Admin() {
			super();
		}

		public Admin(String userName, String password, String Role) {
			super(userName, password ,Role);
		}

		/*
		 * public List<Customer> getCustomer() { return customer; }
		 * 
		 * public void setCustomer(List<Customer> customer) { this.customer = customer;
		 * }
		 */
	}


