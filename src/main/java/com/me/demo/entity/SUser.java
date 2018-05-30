package com.me.demo.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "s_user", catalog = "test")
public class SUser implements java.io.Serializable {



    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    private String email;

    private String password;

    private Date dob;

    private Set<SRole> SRoles = new HashSet<SRole>(0);



    public SUser() {

    }



    public SUser(String name, String email, String password, Date dob, Set<SRole> SRoles) {

       this.name = name;

       this.email = email;

       this.password = password;

       this.dob = dob;

       this.SRoles = SRoles;

    }



    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)

    public Integer getId() {
       return this.id;

    }



    public void setId(Integer id) {

       this.id = id;

    }



    @Column(name = "name", length = 20)

    public String getName() {

       return this.name;

    }



    public void setName(String name) {

       this.name = name;

    }



    @Column(name = "email", length = 20)

    public String getEmail() {

       return this.email;

    }



    public void setEmail(String email) {

       this.email = email;

    }



    @Column(name = "password", length = 200)

    public String getPassword() {

       return this.password;

    }



    public void setPassword(String password) {

       this.password = password;

    }



    @Temporal(TemporalType.DATE)

    @Column(name = "dob", length = 10)

    public Date getDob() {

       return this.dob;

    }



    public void setDob(Date dob) {

       this.dob = dob;

    }



    @OneToMany(fetch = FetchType.EAGER, mappedBy = "SUser")

    public Set<SRole> getSRoles() {

       return this.SRoles;

    }



    public void setSRoles(Set<SRole> SRoles) {

       this.SRoles = SRoles;

    }



}
