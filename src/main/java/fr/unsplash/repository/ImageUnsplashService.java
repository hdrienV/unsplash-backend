package fr.unsplash.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ImageUnsplashService implements IImageUnsplashService{

    @Autowired
    private IImageDAO dao;

    @Override
    public ImageUnsplash create(ImageUnsplash image) {
        image.setCreationDate(LocalDateTime.now());
        ImageUnsplash imageCreated =  dao.save(image);
        dao.updateDocumentVector();
        return imageCreated;
    }

    @Override
    public List<ImageUnsplash> getImages() {
        return dao.findAllByOrderByCreationDateDesc();
    }

    @Override
    public List<ImageUnsplash> getImagesByLabel(String label) {
        return dao.searchByLabel(label);
    }

    @Override
    public boolean deleteById(Long id) {
        int nbLinesRemoved = dao.deleteImageById(id);
        return nbLinesRemoved != 0;
    }


}
