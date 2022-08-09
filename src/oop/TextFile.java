package oop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextFile implements AutoCloseable {

    private static final Logger LOGGER = LogManager.getLogger(LawyerOffice.class);

    private String name;
    private byte[] content;

    @Override
    public void close() {
        LOGGER.info("File is closed");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
