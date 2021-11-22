package com.jarno.pictureservice.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.jarno.pictureservice.models.ImageObject;
import com.jarno.pictureservice.repositories.ImageObjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ThImageController {

    @Autowired
    private ImageObjectRepository imageRepository;

    /* Create */
    @Transactional
    @PostMapping("/")
    public String addImage(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.getContentType().equals("image/png")) {
            ImageObject newImage = new ImageObject();
            newImage.setContent(file.getBytes());
            imageRepository.save(newImage);
        }
        return "redirect:/index";

    }

    /* Read */
    @ResponseBody
    @GetMapping("/images")
    public List<ImageObject> getAllImages() {
        return imageRepository.findAll();
    }

    /* Get image content */
    @GetMapping(path = "/images/{id}/content", produces = "image/png")
    @ResponseBody
    public byte[] getImage(@PathVariable Long id) {
        Optional<ImageObject> imageContent = imageRepository.findById(id);
        if (imageContent.isPresent()) {
            return imageContent.get().getContent();
        }
        return new ImageObject().getContent();
    }

    @GetMapping(path = "/images/{id}", produces = "application/json")
    @ResponseBody
    public ImageObject getImageObject(@PathVariable Long id) {
        Optional<ImageObject> imageObject = imageRepository.findById(id);
        if (imageObject.isPresent()) {
            return imageObject.get();
        }

        return imageObject.get();
    }

    /* Update */

    /* Delete */
    @DeleteMapping("/images/{id}/delete")
    @ResponseBody
    public ImageObject deleteImage(@PathVariable Long id) {
        Optional<ImageObject> imageToRemove = imageRepository.findById(id);
        if (imageToRemove.isPresent()) {
            imageRepository.deleteById(id);
            return imageToRemove.get();
        }
        return new ImageObject();

    }

}
