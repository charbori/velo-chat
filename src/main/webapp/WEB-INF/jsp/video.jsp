<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html>
 <head>
     <meta charset="UTF-8">
     <title>HTML5 video태그 예제</title>
 </head>
 <body>
     <video width="640" height="344" controls autoplay="autoplay">
       <source src="${ROOT}${fileName}" type="video/mp4">
       Your browser does not support the video tag.
     </video>
 </body>
 </html>