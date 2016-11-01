package com.showeasy.philiptest;

/**
 * Created by 邵一哲_Native on 2016/11/1.
 */

public class PTException extends Exception {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** NO_ERROR */
    public static final int NO_ERROR = 0;

    /** UNKNOWN_ERROR */
    public static final int UNKNOWN_ERROR = 1;
    /** SHAREDPREFS_FAILED */
    public static final int SHAREDPREFS_FAILED = 11;

    /** errorType : the type of exception. */
    protected int errorType = 0;

    /** errorData : the extra data of the exception. */
    private Object errorData;

    /**
     * @param message
     *            : the message of exception.
     * @param throwable
     *            : the throwable object.
     */
    public PTException(String message, Throwable throwable) {
        this(UNKNOWN_ERROR, message, throwable);
    }

    /**
     * @param type
     *            : the type of exception.
     * @param message
     *            : the message of exception.
     * @param throwable
     *            : the throwable object.
     */
    public PTException(int type, String message, Throwable throwable) {
        super(message, throwable);
        errorType = type;
        errorData = null;
    }

    /**
     * @param type
     *            : the type of exception.
     */
    public PTException(int type) {
        this(type, "", null);
    }

    /**
     * @param type
     *            : the type of exception.
     * @param message
     *            : the message of exception.
     * @param data
     *            : the extra data of the exception.
     */
    public PTException(int type, String message, Object data) {
        super(message);
        errorData = data;
        errorType = type;
    }

    public Object getErrorData() {
        return errorData;
    }

    public void setErrorData(Object errorData) {
        this.errorData = errorData;
    }

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }
}
