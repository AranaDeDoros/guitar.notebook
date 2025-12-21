package com.arana.guitar.notebook.practice.application.dto;

 public sealed interface TabResponse   permits
         TabResponse.SuccessfulTabResponse,
         TabResponse.ErrorTabResponse {
     record SuccessfulTabResponse(String message, String content)
             implements TabResponse {
     }

     record ErrorTabResponse(String message)
             implements TabResponse {
     }
 }

