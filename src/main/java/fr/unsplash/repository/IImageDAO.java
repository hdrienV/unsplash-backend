package fr.unsplash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IImageDAO extends JpaRepository<ImageUnsplash, Long> {
    @Query(value = "SELECT * FROM image_unsplash iu  WHERE document_vectors @@ to_tsquery(:label)", nativeQuery = true)
    List<ImageUnsplash> searchByLabel(@Param("label") String label);
    @Query("select iu from ImageUnsplash iu  Order by iu.creationDate")
    List<ImageUnsplash> fetchAll();
    @Modifying
    @Transactional
    @Query("delete from ImageUnsplash iu where iu.id=?1")
    int deleteImageById(long id);
}