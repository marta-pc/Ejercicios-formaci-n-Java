package com.bosonit.block11uploaddownloadfiles.domain.repository;

import com.bosonit.block11uploaddownloadfiles.domain.exception.FileNotFoundException;
import com.bosonit.block11uploaddownloadfiles.domain.exception.FileUploadException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Repository
public class FileRepositoryImp implements FileRepository{

    private Path rootLocation;

    @Bean
    CommandLineRunner setInitialPath() {
        return args ->
        {
            if(args.length >=1){
                this.rootLocation = Paths.get(args[0]);
            }
        };
    }

    @Override
    public void saveFile(MultipartFile file) {
        try{
            if(file.isEmpty()) {
                throw new FileUploadException("El archivo se encuentra vacío");
            }
            Objects.requireNonNull(file.getOriginalFilename());
            Path destinationFile = this.rootLocation.resolve(Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();

            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                throw new FileUploadException("No se ha podido guardar el archivo fuera del directorio actual.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new FileUploadException("No se ha podido guardar el archivo.", e);
        }
    }


    @Override
    public Resource findByName(String name) {
        try {
            Path file = rootLocation.resolve(name);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new FileNotFoundException("No se ha podido encontrar el archivo: " + name);
            }
        }
        catch (MalformedURLException e) {
            throw new FileNotFoundException("No se ha podido encontrar el archivo: " + name, e);
        }
    }


    @Override
    public void setPath (String path) {
        this.rootLocation = Paths.get(path);
    }
}
