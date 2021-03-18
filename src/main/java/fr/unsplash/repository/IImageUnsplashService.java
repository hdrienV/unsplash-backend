package fr.unsplash.repository;

import java.util.List;

public interface IImageUnsplashService {

    ImageUnsplash create(ImageUnsplash image);
    List<ImageUnsplash> getImages();
    List<ImageUnsplash> getImagesByLabel(String label);
    boolean deleteById(Long id);
}
