package com.example.demo.Controller;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/barcode")
public class BarcodeController {

    @GetMapping("/test")
    public String test(){
        return "test success";
    }

    @GetMapping(value = "/code128.png", produces = MediaType.IMAGE_PNG_VALUE)
    public Image code128barcode(@RequestParam(value = "data", defaultValue = "abcd")String data){
        System.out.println(data);
        return code128barcodeGenerator(data);
    }

    @Bean
    public HttpMessageConverter<BufferedImage> bufferedImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }

    private Image code128barcodeGenerator(String data){
        Code128Bean code128Bean = new Code128Bean();

        BitmapCanvasProvider bitmapCanvasProvider = new BitmapCanvasProvider(280, BufferedImage.TYPE_BYTE_BINARY, false, 0);
        code128Bean.generateBarcode(bitmapCanvasProvider, data.trim());

        return bitmapCanvasProvider.getBufferedImage();
    }
}
