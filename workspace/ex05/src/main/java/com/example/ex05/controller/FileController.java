package com.example.ex05.controller;

import com.example.ex05.domain.vo.FileVO;
import com.example.ex05.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/files/*")
@RequiredArgsConstructor
@Slf4j
public class FileController {
    private final FileService fileService;

    @GetMapping("upload")
    public String goUploadForm(){
        return "/upload";
    }

//    파일 저장
    @PostMapping("save")
    @ResponseBody
    public void save(@RequestBody List<FileVO> files){
        fileService.write(files);
    }



    //PathVariable : 쿼리스트링으로 전달되는 경우 외에 uri에 전달되는 값을 받아오는 역할
//    파일 업로드
    @PostMapping("upload")
    @ResponseBody
    public List<String> upload(@RequestParam("file") List<MultipartFile> multipartFiles) throws IOException {
        List<String> uuids = new ArrayList<>();
        String path = "C:/upload/" + getPath();
        // fileVO.absolute_path ->
        // 절대 경로 : 가장 최상위 위치가 되는 root 위치에서부터  현재 실행되거나 지정한 파일명까지의 모든 파일 및 디렉터리들을 포함하는 전체 경로이다.
        File file = new File(path);

        //mkdirs() : 함수는 생성하려는 폴더의 위치에 가기 전까지 폴더가 존재해야지만 새로 만들려고 하는 폴더를 생성할 수 있다
        if(!file.exists()) {file.mkdirs();}

        for(int i=0; i<multipartFiles.size(); i++){
            uuids.add(UUID.randomUUID().toString());
            multipartFiles.get(i).transferTo(new File(path, uuids.get(i) + "_" + multipartFiles.get(i).getOriginalFilename()));

            if(multipartFiles.get(i).getContentType().startsWith("image")){
                FileOutputStream out = new FileOutputStream(new File(path, "t_" + uuids.get(i) + "_" + multipartFiles.get(i).getOriginalFilename()));
                Thumbnailator.createThumbnail(multipartFiles.get(i).getInputStream(), out, 100, 100);
                out.close();
            }
        }
        return uuids;
    }

//    파일 불러오기
    @GetMapping("display")
    @ResponseBody
    public byte[] display(String fileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("C:/upload", fileName));
    }

    @GetMapping("download")
    public ResponseEntity<Resource> download(String fileName) throws UnsupportedEncodingException {
        Resource resource = new FileSystemResource("C:/upload/" + fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=" + new String(fileName.substring(fileName.indexOf("_") + 1).getBytes("UTF-8"), "ISO-8859-1"));
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    //    현재 날짜 경로 구하기
    private String getPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}

















