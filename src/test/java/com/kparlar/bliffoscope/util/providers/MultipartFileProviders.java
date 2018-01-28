package com.kparlar.bliffoscope.util.providers;

import com.kparlar.bliffoscope.util.BliffoscopeTestConstantsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MultipartFileProviders {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public MultipartFile getStarShipMultipart() throws IOException {
        File file = new File(BliffoscopeTestConstantsUtil.FOLDER_SAMPLE, BliffoscopeTestConstantsUtil.FILE_STAR_SHIP);
        return getMultipartFile(file);

    }

    private MultipartFile getMultipartFile(File fileStarShip) throws IOException {
        Path path = fileStarShip.toPath();
        byte[] fileBytes = Files.readAllBytes(path);
        return new MockMultipartFile("file", "orig", null, fileBytes);
    }

    public MultipartFile getTestDataMultipart() throws IOException {
        File file = new File(BliffoscopeTestConstantsUtil.FOLDER_SAMPLE, BliffoscopeTestConstantsUtil.FILE_TEST_DATA);
        return getMultipartFile(file);
    }


}
