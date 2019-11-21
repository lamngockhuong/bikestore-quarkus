package com.ngockhuong.service

import com.ngockhuong.model.dto.req.BrandReqDto
import com.ngockhuong.model.dto.res.BrandResDto
import com.ngockhuong.model.entity.BrandEntity

interface BrandService : BaseService<BrandReqDto, BrandResDto, BrandEntity> {
}
