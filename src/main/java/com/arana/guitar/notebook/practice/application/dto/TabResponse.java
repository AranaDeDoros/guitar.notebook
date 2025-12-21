package com.arana.guitar.notebook.practice.application.dto;

import com.arana.guitar.notebook.practice.domain.models.Tab;

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

