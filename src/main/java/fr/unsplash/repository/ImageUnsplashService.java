package fr.unsplash.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageUnsplashService implements IImageUnsplashService{

    @Autowired
    private IImageDAO dao;

    @Override
    public ImageUnsplash create(ImageUnsplash image) {
        return dao.save(image);
    }

    @Override
    public List<ImageUnsplash> getImages() {
        return dao.findAll();
    }

    @Override
    public List<ImageUnsplash> getImagesByLabel(String label) {
        return dao.searchByLabel(label);
    }

    @Override
    public boolean deleteById(Long id) {
        long nbLinesRemoved = dao.deleteImageById(id);
        return nbLinesRemoved != 0;
    }


}
