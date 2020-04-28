package com.srtmaker.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
public class SrtUtils {

    final private DateTimeFormatter formatter;
    final private LocalDateTime timer;
    final Logger logger = LoggerFactory.getLogger(SrtUtils.class);

    public SrtUtils() {
        timer = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        formatter = DateTimeFormatter.ofPattern("hh:mm:ss,S");
    }

    public String getSrtText(String text, int wordsPerMinute) {
        logger.debug(String.format("got request with words/minute: %d",wordsPerMinute));
        List wordList = Arrays.asList(text.split(" "));
        int wordPerSecondleft = wordList.size()%wordsPerMinute;
        int wordPerSecond = wordList.size()/wordsPerMinute;
        logger.debug("starting to write file");
        StringBuilder builder = new StringBuilder();
        int totalWordsWritten = 0;
        int subtitleSectionNumber = 1;
        while(totalWordsWritten < wordList.size()) {
            builder.append(subtitleSectionNumber).append('\n');
            builder.append(formatter.format(timer)).append(" --> ").append(formatter.format(timer.plusSeconds(1))).append('\n');
            for (int i = 0; i < wordPerSecond; i++) {
                if(i == wordPerSecond - 1) {
                    builder.append(wordList.get(i));
                } else {
                    builder.append(wordList.get(i)).append(" ");
                }
            }
            builder.append('\n').append('\n');
            subtitleSectionNumber++;
            totalWordsWritten += wordPerSecond;
        }
        logger.debug("initial loop completed");
        if(wordPerSecondleft > 0) {
            builder.append(subtitleSectionNumber).append('\n');
            builder.append(formatter.format(timer)).append(" --> ").append(formatter.format(timer.plusSeconds(1))).append('\n');
            for (int j = 0; j < wordPerSecondleft ; j ++) {
                if(j == wordPerSecondleft - 1) {
                    builder.append(wordList.get(j));
                } else {
                    builder.append(wordList.get(j)).append(" ");
                }
            }
        } else {
            writeFile(builder);
        }
        return builder.toString();
    }

    private void writeFile(StringBuilder builder) {
        File srtFile = new File("generatedSrt.srt");
        try {
            if(srtFile.createNewFile()) {
                PrintWriter writer = new PrintWriter("generatedSrt.srt");
                writer.print(builder.toString());
            } else {
                logger.error("File creation failed!");
            }
        }
        catch(IOException ex) {
            logger.error("Encountered error while writing file: ",ex);
        }
    }
}
