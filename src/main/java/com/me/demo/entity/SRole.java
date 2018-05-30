package com.me.demo.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "s_role", catalog = "test")
public class SRole implements java.io.Serializable {



    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private SUser SUser;

    private String name;



    public SRole() {

    }



    public SRole(SUser SUser) {

       this.SUser = SUser;

    }



    public SRole(SUser SUser, String name) {

       this.SUser = SUser;

       this.name = name;

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



    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "uid", nullable = false)

    public SUser getSUser() {

       return this.SUser;

    }



    public void setSUser(SUser SUser) {

       this.SUser = SUser;

    }



    @Column(name = "name", length = 20)

    public String getName() {

       return this.name;

    }



    public void setName(String name) {

       this.name = name;

    }



}