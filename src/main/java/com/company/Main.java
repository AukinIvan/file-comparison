package com.company;

import difflib.Delta;
import difflib.DiffUtils;
import difflib.Patch;

import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            var fileOriginLines = Files.readAllLines(Paths.get(args[0]));
            var fileModifiedLines = Files.readAllLines(Paths.get(args[1]));

            Patch<String> patch = DiffUtils.diff(fileOriginLines, fileModifiedLines);

            if (patch.getDeltas().size() == 0) {
                System.out.println("Files are equal");
                return;
            }

            for (Delta<?> delta : patch.getDeltas()) {
                var line = "";
                switch (delta.getType()) {
                    case INSERT: line = delta.getRevised().getLines().toString(); break;
                    case DELETE: line = delta.getOriginal().getLines().toString(); break;
                    case CHANGE: line = delta.getOriginal().getLines().toString() + " to " + delta.getRevised().getLines().toString();
                }

                var type = delta.getType();
                var position = delta.getOriginal().getPosition() + 1;

                System.out.println(position + " | " + type + " | " + line);
            }

        } catch (NoSuchFileException e) {
            System.out.println("No found file: " + e.getFile());
        } catch (AccessDeniedException e) {
            System.out.println("No access to file: " + e.getFile());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Specify parameters: original and modified files");
            System.out.println("Example: file-comparison original_file.txt modified_file.txt");
        } catch (Exception e) {
            System.out.println("Unknown error");
        }
    }
}
