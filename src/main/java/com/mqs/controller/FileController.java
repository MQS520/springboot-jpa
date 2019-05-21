package com.mqs.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class FileController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final String folder = "E:/";

    @ApiOperation(value = "上传", notes = "sssss")
    @ApiImplicitParams({})
    @RequestMapping(value = "/upload", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
    public void upload(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2){
        logger.info(file1.getName() + "---------------------------------" + file1.getSize());
        logger.info(file2.getName() + "---------------------------------" + file2.getSize());

    }

}
