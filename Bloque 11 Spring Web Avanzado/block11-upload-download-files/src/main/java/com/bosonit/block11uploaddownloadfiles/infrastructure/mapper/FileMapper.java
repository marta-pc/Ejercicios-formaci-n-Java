package com.bosonit.block11uploaddownloadfiles.infrastructure.mapper;
import com.bosonit.block11uploaddownloadfiles.domain.Entity.File;
import com.bosonit.block11uploaddownloadfiles.infrastructure.dto.FileOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileMapper {

    FileMapper INSTANCE = Mappers.getMapper(FileMapper.class);

    FileOutputDto fileMetadataToFileOutputDto(File file);
}
