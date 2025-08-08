package com.ArtGallry.artwork.repository;

import com.ArtGallry.artwork.model.Artwork;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtRepository extends MongoRepository<Artwork,String> {

}
