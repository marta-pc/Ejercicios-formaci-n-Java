package com.bosonit.block11uploaddownloadfiles.application;

import com.bosonit.block11uploaddownloadfiles.domain.Entity.File;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    File saveFile (MultipartFile file);

    Resource findById (int id);

    Resource findByName (String name);

    void setPath (String path);

}
