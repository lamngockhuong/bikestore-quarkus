package com.ngockhuong.model.entity

import com.ngockhuong.model.dto.res.BrandResDto
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "brands")
class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", unique = true, nullable = false)
    var brandId: Long = 0

    @Column(name = "brand_name")
    lateinit var brandName: String

    fun transformToBrandResDto(): BrandResDto {
        val item = BrandResDto()
        item.brandId = this.brandId
        item.brandName = this.brandName

        return item
    }
}
