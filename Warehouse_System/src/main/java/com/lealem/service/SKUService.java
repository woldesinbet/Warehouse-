package com.lealem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lealem.model.SKU;
import com.lealem.repository.SKURepository;
@Transactional
@Service
public class SKUService {
	@Autowired
	SKURepository skuRepository;

	public void save(SKU sku) {
		this.skuRepository.save(sku);
	}

	public List<SKU> findAll() {
		return this.skuRepository.findAll();
	}

	public SKU findOne(long id) {
		return this.skuRepository.findOne(id);
	}

	public SKU findByProductId(Long productId) {
		return this.skuRepository.findByProductId(productId);
	}
}
