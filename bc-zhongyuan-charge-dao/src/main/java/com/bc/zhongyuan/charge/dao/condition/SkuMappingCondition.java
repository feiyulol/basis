
package com.bc.zhongyuan.charge.dao.condition;

import com.bc.zhongyuan.charge.dao.abs.DaoCondition;

/**
 * <p>用于封装查询条件</p>
 * <p>默认条件下仅生成数据表字段的查询条件，更多条件，请自行添加</p>
 * @author Generator
 * @date 2019年07月01日 13时30分48秒
 */
public class SkuMappingCondition implements DaoCondition{

	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 核销的商品唯一Id
	 */
	private String productId;
	/**
	 * 直充平台sku
	 */
	private String sku;
	
	/**
	 * 主键
	 */
	public Integer getId(){
		return id;
	}
	
	/**
	 * 主键
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
	/**
	 * 核销的商品唯一Id
	 */
	public String getProductId(){
		return productId;
	}
	
	/**
	 * 核销的商品唯一Id
	 */
	public void setProductId(String productId){
		this.productId = productId;
	}
	
	/**
	 * 直充平台sku
	 */
	public String getSku(){
		return sku;
	}
	
	/**
	 * 直充平台sku
	 */
	public void setSku(String sku){
		this.sku = sku;
	}

}