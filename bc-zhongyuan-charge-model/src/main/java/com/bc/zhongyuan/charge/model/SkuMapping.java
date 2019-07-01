
package com.bc.zhongyuan.charge.model;

/**
 * <p>封装实体bean</p>
 * @author Generator
 * @date 2019年07月01日 13时30分48秒
 */
public class SkuMapping {

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
