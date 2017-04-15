package com.fortegroupe.utill;

import com.fortegroupe.model.Message;

/**
 * Created by alex on 13.4.17.
 */
public final class MessageFactory {

    private MessageFactory(){

    }

    public static Message getMessage(String pUserEmail, boolean pHasError, String pMessage){
        return new Message(pUserEmail,pHasError,pMessage);
    }
}
