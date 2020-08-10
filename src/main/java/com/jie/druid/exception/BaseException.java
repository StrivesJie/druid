package com.jie.druid.exception;

/**
 * FEBS系统内部异常
 *
 * @author MrBird
 */
public class BaseException extends RuntimeException  {

    private static final long serialVersionUID = -994962710559017255L;

    public BaseException(String message) {
        super(message);
    }
}
