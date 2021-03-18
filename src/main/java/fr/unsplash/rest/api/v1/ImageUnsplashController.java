package fr.unsplash.rest.api.v1;

import fr.unsplash.repository.ImageUnsplash;
import fr.unsplash.repository.ImageUnsplashService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:8081")
public class ImageUnsplashController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImageUnsplashController.class);

    private final ImageUnsplashService imageUnsplashService;

    @Autowired
    public ImageUnsplashController(ImageUnsplashService imageUnsplashService) {
        this.imageUnsplashService = imageUnsplashService;
    }

    @GetMapping(value = "/image")
    @ResponseBody
    public List<ImageUnsplash> getImages() {
        LOGGER.info("Attempt to retrieve images");
       return imageUnsplashService.getImages();
    }

    @GetMapping(value = "/image/search")
    @ResponseBody
    public List<ImageUnsplash> getImages(@RequestParam String label) {
        return imageUnsplashService.getImagesByLabel(label);
    }


    @DeleteMapping(value = "/image/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id) {
        var isRemoved = imageUnsplashService.deleteById(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(value = "/image")
    @ResponseStatus(HttpStatus.CREATED)
    public ImageUnsplash createImage(@RequestBody ImageUnsplash imageUnsplash) {
        return imageUnsplashService.create(imageUnsplash);
    }
}
