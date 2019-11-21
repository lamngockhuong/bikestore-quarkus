package com.ngockhuong.service

import com.ngockhuong.model.dto.req.CategoryReqDto
import com.ngockhuong.model.dto.res.CategoryResDto
import com.ngockhuong.model.entity.CategoryEntity

interface CategoryService : BaseService<CategoryReqDto, CategoryResDto, CategoryEntity> {
}
