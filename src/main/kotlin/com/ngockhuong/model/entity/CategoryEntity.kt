package com.ngockhuong.model.entity

import com.ngockhuong.model.dto.res.CategoryResDto
import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "categories")
class CategoryEntity : PanacheEntityBase() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var categoryId: Int = 0

    lateinit var categoryName: String


    fun findByCategoryName(categoryName: String): CategoryEntity? {
        return null;
    }

    fun findAll(): List<CategoryEntity>? {
        return null;
    }

    @Column(name = "created_date")
    var createdDate: LocalDateTime = LocalDateTime.now()


    fun transformToCategoryResDto(): CategoryResDto {
        var item = CategoryResDto()
        item.categoryId = this.categoryId
        item.categoryName = this.categoryName

        return item
    }
}
