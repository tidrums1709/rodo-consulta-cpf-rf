package br.com.tiagoss.robo.test.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class ImagemService {


    public String convertImagem64EmImagemPng(String img){

        String path = "./img/img.png";

        try (FileOutputStream imageOutFile = new FileOutputStream(path)) {
            byte[] imageByteArray = Base64.getDecoder().decode(img);
            imageOutFile.write(imageByteArray);
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }

        return path;
    }

}
