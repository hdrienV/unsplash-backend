package fr.unsplash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IImageDAO extends JpaRepository<ImageUnsplash, Long> {
    ImageUnsplash findByLabel(String label);
    @Query("select iu from ImageUnsplash iu  Order by iu.creationDate")
    List<ImageUnsplash> fetchAll();
}