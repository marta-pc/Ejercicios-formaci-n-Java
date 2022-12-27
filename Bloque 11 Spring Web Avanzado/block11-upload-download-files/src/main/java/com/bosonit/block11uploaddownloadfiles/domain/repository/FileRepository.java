package com.bosonit.block11uploaddownloadfiles.domain.repository;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface FileRepository {

    void saveFile(MultipartFile file);

    Resource findByName(String name);

    void setPath (String path);

}
