package com.supertrampai.springbootsimpleloadfile.exception;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/18 18:46
 */
public class FileStorageException extends RuntimeException {
    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}