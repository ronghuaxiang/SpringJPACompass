package com.sjc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableComponent;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

/**
 * Product entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "product", catalog = "sjc")
@Searchable
public class Product implements java.io.Serializable {

	// Fields

	private Integer id;
	private Category category=new Category();
	private String productname;
	private Float price;
	private String descption;

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Product(Integer id, Category category, String productname,
			Float price, String descption) {
		this.id = id;
		this.category = category;
		this.productname = productname;
		this.price = price;
		this.descption = descption;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@SearchableId
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(cascade=CascadeType.REFRESH,optional=false,fetch=FetchType.EAGER)
	@JoinColumn(name = "category_id")
	@SearchableComponent
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "name", length = 50)
	@SearchableProperty(index=Index.ANALYZED,store=Store.YES,boost=2.0f)
	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	@Column(name = "price", precision = 12, scale = 0)
	@SearchableProperty(index=Index.NOT_ANALYZED,store=Store.YES)
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Column(name = "descption", length = 20)
	@SearchableProperty(index=Index.ANALYZED,store=Store.YES)
	public String getDescption() {
		return this.descption;
	}

	public void setDescption(String descption) {
		this.descption = descption;
	}

}