/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author fzr
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FrageNotFoundException extends BaseRuntimeException {

    public FrageNotFoundException(String message) {
        super(message);
    }

    public FrageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
