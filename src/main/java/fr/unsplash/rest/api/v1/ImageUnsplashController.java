package fr.unsplash.rest.api.v1;

import fr.unsplash.repository.ImageUnsplash;
import fr.unsplash.repository.ImageUnsplashService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @GetMapping(value = "getImages")
    @ResponseBody
    public List<ImageUnsplash> getImages() {

        LOGGER.info("Attempt to retrieve images");

       return imageUnsplashService.getImages();
    }

    @GetMapping(value = "info")
    @ResponseBody
    public String getInfo() {
        return "info";
    }
}
