package com.bosonit.block11uploaddownloadfiles.application;


import com.bosonit.block11uploaddownloadfiles.domain.Entity.File;
import com.bosonit.block11uploaddownloadfiles.domain.exception.FileNotFoundException;
import com.bosonit.block11uploaddownloadfiles.domain.repository.FileInfoRepository;
import com.bosonit.block11uploaddownloadfiles.domain.repository.FileRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j

public class FileServiceImp implements FileService {

    private FileInfoRepository fileInfoRepository;
    private FileRepository fileRepository;

    @Override
    public File saveFile(MultipartFile file) {

        Objects.requireNonNull(file.getOriginalFilename());

        fileRepository.saveFile(file);

        Optional<File> optionalFileMetadata = fileInfoRepository.findByName(file.getOriginalFilename());
        File fileInfo = new File();

        optionalFileMetadata.ifPresent(value -> fileInfo.setId(value.getId()));

        fileInfo.setName(file.getOriginalFilename());

        fileInfo.setUploadDate(LocalDate.now());
        return fileInfoRepository.save(fileInfo);
    }


    @Override
    public Resource findById(int id) {


        Optional<File> optionalMetadata = fileInfoRepository.findById(id);
        if(optionalMetadata.isEmpty()) {
            throw new FileNotFoundException("No se ha podido almacenar en la base de datos");
        }
        File metadata = optionalMetadata.get();
        return this.findByName(metadata.getName());
    }

    @Override
    public Resource findByName(String name) {

        return fileRepository.findByName(name);
    }

    @Override
    public void setPath(String path) {

        fileRepository.setPath(path);
    }
}
