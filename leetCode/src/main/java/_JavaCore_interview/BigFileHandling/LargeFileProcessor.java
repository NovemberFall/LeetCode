package _JavaCore_interview.BigFileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class LargeFileProcessorTask implements Runnable {
    private final String filePath;
    private final long start;
    private final long end;

    public LargeFileProcessorTask(String filePath, long start, long end) {
        this.filePath = filePath;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            LargeFileProcessor processor = new LargeFileProcessor();
            processor.processChunk(filePath, start, end);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class LargeFileProcessor {
    private static final int BUFFER_SIZE = 1024 * 1024; // 1MB buffer size for reading the file

    public void processChunk(String filePath, long start, long end) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath), BUFFER_SIZE)) {
            // skip lines up to start position
            for (long i = 0; i < start; i++) {
                reader.readLine();
            }

            String line;
            long lineNumber = start;
            while ((line = reader.readLine()) != null && lineNumber <= end) {
                // Process each line of the file here
                System.out.println(line);

                lineNumber++;
            }
        }
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "/path/to/large/file.log";
        Path path = Paths.get(filePath);
        long fileSize = path.toFile().length();
        int numThreads = Runtime.getRuntime().availableProcessors();
        long chunkSize = fileSize / numThreads;

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            long start = i * chunkSize;
            long end = (i + 1) * chunkSize;
            if (i == numThreads - 1) {
                end = fileSize;
            }
            executor.submit(new LargeFileProcessorTask(filePath, start, end));
        }

        executor.shutdown();
    }
}
