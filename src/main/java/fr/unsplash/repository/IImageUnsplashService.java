package fr.unsplash.repository;

import java.util.List;

public interface IImageUnsplashService {

    ImageUnsplash create(ImageUnsplash imageUnsplash);
    List<ImageUnsplash> getImages();
}
