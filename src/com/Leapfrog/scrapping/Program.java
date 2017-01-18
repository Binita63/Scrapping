/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Leapfrog.scrapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author user
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try{
            
            
                 
      URL url= new URL("http://leapfrog.academy");
            URLConnection conn= url.openConnection();
            BufferedReader reader= new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line="";
            System.out.println(line);
            StringBuilder content = new StringBuilder();
            while((line=reader.readLine())!=null){
               content.append(line).append("\n");
               
            }
            reader.close(); 
          
            String regex="<a href=\"(.*?)\" class=\"track\" data-target=\"Course\"(.*?)>\\s(.*?)\n(.*?)<h5>(.*?)</h5>";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher= pattern.matcher(content.toString());
            while(matcher.find()){
                System.out.println(matcher.group());
            
             }
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
               
    
    
}
