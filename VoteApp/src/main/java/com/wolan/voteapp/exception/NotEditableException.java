package com.wolan.voteapp.exception;

public class NotEditableException extends Exception{
    private static final String VOTE_IS_NOT_EDITABLE = "Vote is not editable";

    public NotEditableException() {
        super(VOTE_IS_NOT_EDITABLE);
    }
}
