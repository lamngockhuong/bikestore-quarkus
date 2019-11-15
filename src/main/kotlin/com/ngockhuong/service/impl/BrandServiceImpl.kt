package com.ngockhuong.service.impl

import com.ngockhuong.exception.EntityNotFoundException
import com.ngockhuong.model.dto.req.BrandReqDto
import com.ngockhuong.model.dto.res.BrandResDto
import com.ngockhuong.model.entity.BrandEntity
import com.ngockhuong.repository.BrandRepository
import com.ngockhuong.service.BrandService
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class BrandServiceImpl : BrandService {

    @Inject
    internal lateinit var brandRepository: BrandRepository

    override fun list(): List<BrandResDto>? {
        return brandRepository.list().map { brandEntity -> brandEntity.transformToBrandResDto() }
    }

    override fun findById(id: Long): BrandResDto {
        val item: BrandEntity? = brandRepository.findItemById(id) ?: throw EntityNotFoundException("Không tìm thấy")

        return item!!.transformToBrandResDto()
    }

    override fun create(item: BrandReqDto): BrandResDto {
        return BrandResDto()
    }

    override fun update(item: BrandReqDto): BrandResDto {
        return BrandResDto()
    }

    override fun delete(id: Int) {

    }
}
