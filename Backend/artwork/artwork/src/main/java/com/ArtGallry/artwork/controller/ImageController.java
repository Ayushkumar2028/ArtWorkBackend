package com.ArtGallry.artwork.controller;

import com.ArtGallry.artwork.model.Artwork;
import java.util.List;

import com.ArtGallry.artwork.repository.ArtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ImageController {

    @Autowired
    ArtRepository artrepo;

    // create
    @PostMapping("/saveart")
    public Artwork postartdata(@RequestBody Artwork art) {
        return artrepo.save(art);
    }

    // read
    @GetMapping("/allart")
    public List<Artwork> getArtdata() {
        return artrepo.findAll();
    }

    // read by id
    @GetMapping("/{id}")
    public Artwork getArtdataById(@PathVariable String id) {
        return artrepo.findById(id).orElse(null);
    }

    // update
    @PutMapping("/{id}")
    public Artwork updateartwork(@PathVariable String id, @RequestBody Artwork updatedart) {
        Artwork existingArt =  artrepo.findById(id).orElseThrow(() -> new RuntimeException("Artwork Not Found with image id " + id));

        // update fields
        existingArt.setTitle(updatedart.getTitle());
        existingArt.setDescription(updatedart.getDescription());
        existingArt.setImageurl(updatedart.getImageurl());

        return artrepo.save(existingArt);
    }

    // delete
    @DeleteMapping("/{id}")
    public String deleteArtwork(@PathVariable String id){
        if(!artrepo.existsById(id)){
            throw new RuntimeException("Artwork Not Found with image id " + id);
        }
        artrepo.deleteById(id);
        return "Artwork Deleted";
    }

}
