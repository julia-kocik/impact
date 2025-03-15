package pl.puzzle.impact.project;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.common.exception.ErrorMessage;
import pl.puzzle.impact.common.exception.NotFoundException;
import pl.puzzle.impact.project.dto.ImageCreateRequest;
import pl.puzzle.impact.project.dto.ImageUpdateRequest;

import java.util.UUID;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image createImage(ImageCreateRequest imageCreateRequest, UUID projectId) {
       Image image = Image.createImage(imageCreateRequest, projectId);
        return imageRepository.save(image);
    }

    public Image updateImage(UUID imageId, ImageUpdateRequest imageUpdateRequest) {
        Image image = imageRepository.findById(imageId).orElseThrow(() -> new NotFoundException(ErrorMessage.IMAGE_NOT_FOUND));
        image.updateImage(imageUpdateRequest);
        imageRepository.save(image);
        return image;
    }
}
