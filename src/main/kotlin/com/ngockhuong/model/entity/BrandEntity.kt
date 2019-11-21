package com.ngockhuong.model.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "brands")
data class BrandEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", unique = true, nullable = false)
    val brandId: Long,

    @Column(name = "brand_name")
    val brandName: String,

    @Column(name = "created_at")
    val createdAt: LocalDateTime,

    @Column(name = "updated_at")
    val updatedAt: LocalDateTime?
)
