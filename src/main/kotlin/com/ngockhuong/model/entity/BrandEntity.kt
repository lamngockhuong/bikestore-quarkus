package com.ngockhuong.model.entity

import com.ngockhuong.model.dto.res.BrandResDto
import java.time.LocalDateTime
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

    @Column(name = "created_at")
    lateinit var createdAt: LocalDateTime

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null

    fun transformToBrandResDto(): BrandResDto {
        val item = BrandResDto()
        item.brandId = this.brandId
        item.brandName = this.brandName
        item.createdAt = this.createdAt
        item.updatedAt = this.updatedAt

        return item
    }
}
