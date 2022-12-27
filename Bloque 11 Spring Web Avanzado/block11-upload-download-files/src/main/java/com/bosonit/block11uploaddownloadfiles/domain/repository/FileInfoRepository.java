package com.bosonit.block11uploaddownloadfiles.domain.repository;

import com.bosonit.block11uploaddownloadfiles.domain.Entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.util.Optional;

@Repository
public interface FileInfoRepository extends JpaRepository<File, Integer> {

    Optional<File> findByName(String name);

}
