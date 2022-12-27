package com.bosonit.block11uploaddownloadfiles.infrastructure.controller;

import com.bosonit.block11uploaddownloadfiles.application.FileService;
import com.bosonit.block11uploaddownloadfiles.domain.Entity.File;
import com.bosonit.block11uploaddownloadfiles.infrastructure.dto.FileOutputDto;
import com.bosonit.block11uploaddownloadfiles.infrastructure.mapper.FileMapper;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("file")
@AllArgsConstructor

public class FileController {
    private FileService fileService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public FileOutputDto uploadFile(@RequestParam("file") MultipartFile file) {
        File metadata = fileService.saveFile(file);
        return FileMapper.INSTANCE.fileMetadataToFileOutputDto(metadata);
    }

    @GetMapping("{id}")
    public Resource downloadById(@PathVariable int id) {
        return fileService.findById(id);
    }

    @GetMapping("name/{name}")
    public Resource downloadByName(@PathVariable String name) {
        return fileService.findByName(name);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        fileService.saveFile(file);
    }

    @GetMapping("setPath")
    public void setPath(@RequestParam String path) {
        fileService.setPath(path);

    }

}
