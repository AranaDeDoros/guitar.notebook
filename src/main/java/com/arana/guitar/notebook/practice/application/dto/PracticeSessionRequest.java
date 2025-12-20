package com.arana.guitar.notebook.practice.application.dto;

import lombok.Data;

import java.util.List;
@Data
public class PracticeSessionRequest {
    String name;
    List<Long> songIds;
}
