package com.sjc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import com.sjc.dao.IProductDAO;
import com.sjc.model.Product;

/**
 * A data access object (DAO) providing persistence and search support for
 * Product entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.sjc.model.Product
 * @author MyEclipse Persistence Tools
 */
public class ProductDAO extends JpaDaoSupport implements IProductDAO {
	// property constants
	public static final String PRODUCTNAME = "productname";
	public static final String PRICE = "price";
	public static final String DESCPTION = "descption";
	
	public void save(Product entity) {
		logger.info("saving Product instance");
		try {
			getJpaTemplate().persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	public void delete(Product entity) {
		logger.info("deleting Product instance");
		try {
			entity = getJpaTemplate().getReference(Product.class,
					entity.getId());
			getJpaTemplate().remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	public Product update(Product entity) {
		logger.info("updating Product instance");
		try {
			Product result = getJpaTemplate().merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public Product findById(Integer id) {
		logger.info("finding Product instance with id: " + id);
		try {
			Product instance = getJpaTemplate().find(Product.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		logger.info("finding Product instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from Product model where model."
					+ propertyName + "= :propertyValue";
			return getJpaTemplate().executeFind(new JpaCallback() {
				public Object doInJpa(EntityManager em)
						throws PersistenceException {
					Query query = em.createQuery(queryString);
					query.setParameter("propertyValue", value);
					if (rowStartIdxAndCount != null
							&& rowStartIdxAndCount.length > 0) {
						int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
						if (rowStartIdx > 0) {
							query.setFirstResult(rowStartIdx);
						}

						if (rowStartIdxAndCount.length > 1) {
							int rowCount = Math.max(0, rowStartIdxAndCount[1]);
							if (rowCount > 0) {
								query.setMaxResults(rowCount);
							}
						}
					}
					return query.getResultList();
				}
			});
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Product> findByProductname(Object productname,
			int... rowStartIdxAndCount) {
		return findByProperty(PRODUCTNAME, productname, rowStartIdxAndCount);
	}

	public List<Product> findByPrice(Object price, int... rowStartIdxAndCount) {
		return findByProperty(PRICE, price, rowStartIdxAndCount);
	}

	public List<Product> findByDescption(Object descption,
			int... rowStartIdxAndCount) {
		return findByProperty(DESCPTION, descption, rowStartIdxAndCount);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all Product instances");
		try {
			final String queryString = "select model from Product model";
			return getJpaTemplate().executeFind(new JpaCallback() {
				public Object doInJpa(EntityManager em)
						throws PersistenceException {
					Query query = em.createQuery(queryString);
					if (rowStartIdxAndCount != null
							&& rowStartIdxAndCount.length > 0) {
						int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
						if (rowStartIdx > 0) {
							query.setFirstResult(rowStartIdx);
						}

						if (rowStartIdxAndCount.length > 1) {
							int rowCount = Math.max(0, rowStartIdxAndCount[1]);
							if (rowCount > 0) {
								query.setMaxResults(rowCount);
							}
						}
					}
					return query.getResultList();
				}
			});
		} catch (RuntimeException re) {
			logger.error("find all failed", re);
			throw re;
		}
	}

	public static IProductDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IProductDAO) ctx.getBean("ProductDAO");
	}
}