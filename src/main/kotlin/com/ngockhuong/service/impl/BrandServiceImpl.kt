package com.ngockhuong.service.impl

import com.ngockhuong.exception.EntityNotFoundException
import com.ngockhuong.model.dto.req.BrandReqDto
import com.ngockhuong.model.dto.res.BrandResDto
import com.ngockhuong.model.entity.BrandEntity
import com.ngockhuong.repository.BrandRepository
import com.ngockhuong.service.BrandService
import com.ngockhuong.util.toBrandEntity
import com.ngockhuong.util.toBrandResDto
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

@ApplicationScoped
class BrandServiceImpl : BrandService {

    @Inject
    internal lateinit var brandRepository: BrandRepository

    override fun list(): List<BrandResDto>? {
        return brandRepository.list().map { brandEntity -> brandEntity.toBrandResDto() }
    }

    override fun findById(id: Long): BrandEntity {
        return brandRepository.findItemById(id) ?: throw EntityNotFoundException("Không tìm thấy")
    }

    override fun get(id: Long): BrandResDto {
        val item: BrandEntity? = findById(id)
        return item!!.toBrandResDto()
    }

    @Transactional
    override fun create(item: BrandReqDto): BrandResDto {
        return brandRepository.create(item.toBrandEntity()).toBrandResDto()
    }

    @Transactional
    override fun update(item: BrandReqDto): BrandResDto {
        return brandRepository.update(item.toBrandEntity()).toBrandResDto()
    }

    @Transactional
    override fun delete(id: Long) {
        brandRepository.delete(id)
    }
}
