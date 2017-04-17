package com.lynas.security.utill;

import com.lynas.security.model.Message;

/**
 * Created by alex on 16.4.17.
 */
public final class MessageFactory {

    private MessageFactory() {
    }

    public static Message getMessage(String pMessage,boolean pIsError,String pToken){
        return new Message(pIsError,pMessage,pToken);
    }
}
